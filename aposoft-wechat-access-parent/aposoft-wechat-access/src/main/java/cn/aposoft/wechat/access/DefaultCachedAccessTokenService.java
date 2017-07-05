/**
 * 
 */
package cn.aposoft.wechat.access;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.concurrent.AsyncRefreshService;
import cn.aposoft.framework.concurrent.SelfRefreshWorker;
import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.CompanyAccountId;
import cn.aposoft.wechat.account.AccountId;
import cn.aposoft.wechat.account.AccountType;
import cn.aposoft.wechat.config.RefreshConfig;
import cn.aposoft.wechat.config.WechatConfig;
import cn.aposoft.wechat.config.WechatConfigService;

/**
 * 访问授权码本地Token声明周期维护及远程访问综合管理服务
 * <p>
 * 1. 会对本地的访问授权码进行管理
 * <p>
 * 2. 当本地授权码即将过期时,将调用远程对授权码进行更新
 * 
 * @author Jann Liu
 * @since 1.0
 */
@Service
public class DefaultCachedAccessTokenService implements SelfRefreshWorker, CachedAccessTokenService {
	private static final Logger logger = LoggerFactory.getLogger(DefaultCachedAccessTokenService.class);
	// 缓存管理服务
	@Autowired
	private CompanyAccessTokenManagement accessTokenManagement;
	// 配置管理服务
	@Autowired
	private WechatConfigService configService;
	// 刷新配置信息
	@Autowired
	private RefreshConfig refreshConfig;
	// 远程访问
	@Autowired
	private AccessTokenClient accessTokenClient;
	// 异步刷新服务

	private AsyncRefreshService service;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.access.CachedAccessTokenService#setRefreshService(cn.
	 * aposoft.framework.concurrent.AsyncRefreshService)
	 */
	@Override
	public void setRefreshService(AsyncRefreshService service) {
		this.service = service;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.access.CachedAccessTokenService#refresh(java.lang.
	 * Object)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	@Override
	public void refresh(Object context) {
		if (context != null && context instanceof AccountId) {
			try {
				// refresh cache
				AccessToken token = getNewToken((AccountId) context);
				if (token == null) {
					logger.error("failed to asynchronously refresh access-token,the resp is null.");
				}
			} catch (AccessTokenException e) {
				logger.error("failed to asynchronously refresh access-token,meets some exception", e);
			}
		} else {
			logger.error("context is not valid, expect an accountId.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.access.CachedAccessTokenService#getAccessToken(cn.
	 * aposoft.wechat.account.AccountId)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	@Override
	public AccessToken getAccessToken(final AccountId accountId) throws AccessTokenException {
		return getAccessToken(accountId, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.access.CachedAccessTokenService#getAccessToken(cn.
	 * aposoft.wechat.CompanyAccountId)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	@Override
	public AccessToken getAccessToken(CompanyAccountId accountId) throws AccessTokenException {
		return getAccessToken(accountId, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.access.CachedAccessTokenService#getAccessToken(cn.
	 * aposoft.wechat.account.AccountId, boolean)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	@Override
	public AccessToken getAccessToken(AccountId accountId, boolean forUpdate) throws AccessTokenException {
		try {
			if (accessTokenManagement == null) {
				logger.error("accessTokenManagement is empty");
			}
			AccessToken accessToken = accessTokenManagement.getAccessToken(accountId);
			accessToken = ensure(accessToken, accountId, forUpdate);
			return accessToken;
		} catch (RuntimeException e) {
			throw new AccessTokenException(e.getMessage(), e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.access.CachedAccessTokenService#getAccessToken(cn.
	 * aposoft.wechat.CompanyAccountId, boolean)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	@Override
	public AccessToken getAccessToken(CompanyAccountId accountId, boolean forUpdate) throws AccessTokenException {
		try {
			AccessToken accessToken = accessTokenManagement.getAccessToken(accountId);
			accessToken = ensure(accessToken, accountId, forUpdate);
			return accessToken;
		} catch (RuntimeException e) {
			throw new AccessTokenException(e.getMessage(), e);
		}
	}

	// 判断访问码是否过期，如果过期，调用远程服务，刷新AccessToken,返回AccessToken
	// 如果没有过期，但到刷新阈值,则异步调用远程服务，刷新AccessToken
	@SuppressWarnings("unused")
	private AccessToken ensure(final AccessToken accessToken, final AccountId accountId) throws AccessTokenException {
		return ensure(accessToken, accountId, false);
	}

	// 判断访问码是否过期，如果过期，调用远程服务，刷新AccessToken,返回AccessToken
	// 如果没有过期，但到刷新阈值,则异步调用远程服务，刷新AccessToken
	private AccessToken ensure(final AccessToken accessToken, final AccountId accountId, final boolean forUpdate)
			throws AccessTokenException {
		// token 对象有效性
		if (requireHoldon(accessToken) || (forUpdate && !isSafe(accessToken))) {
			AccessToken newAccessToken = getNewToken(accountId);
			return newAccessToken;
		}
		if (isSafe(accessToken)) {
			return accessToken;
		} else {
			asyncRefresh(accountId);
			return accessToken;
		}
	}

	// 异步触发后台的access-token更新
	private void asyncRefresh(AccountId accountId) {
		service.execute(accountId);
	}

	// 从wechat远程服务器读取新的access-token，并刷新本地缓存 ，如果失败，抛出AccessTokenException
	private AccessToken getNewToken(final AccountId accountId) throws AccessTokenException {
		// 1. 锁定数据库，避免远程访问争用
		AccessToken newCachedToken = accessTokenManagement.getAccessToken(accountId, true);

		// 其他会话已经完成数据更新
		if (isSafe(newCachedToken)) {
			return newCachedToken;
		}
		// 2. 执行远程访问
		AccessToken token = getRemoteToken(accountId);
		// 3. 成功后，更新数据库内部缓存
		refreshCache(accountId, token);

		return token;
	}

	// 刷新缓存
	private void refreshCache(final AccountId accountId, final AccessToken token) {
		if (AccountType.MP.equals(accountId.getAccountType())) {
			accessTokenManagement.setAccessToken(wrap(accountId, token));
		} else {
			accessTokenManagement.setAccessToken(wrap((CompanyAccountId) accountId, token));
		}
	}

	private MpAccessTokenStore wrap(final AccountId accountId, final AccessToken token) {
		AccessTokenStore accessTokenStore = new AccessTokenStore();
		copy(accessTokenStore, accountId);
		copy(accessTokenStore, token);
		return accessTokenStore;
	}

	private void copy(AccessTokenStore accessTokenStore, AccessToken token) {
		accessTokenStore.setAccess_token(token.getAccess_token());
		accessTokenStore.setExpires_in(token.getExpires_in());
		accessTokenStore.setRefreshTime(token.getRefreshTime());
	}

	private void copy(AccessTokenStore accessTokenStore, AccountId accountId) {
		accessTokenStore.setAccountType(accountId.getAccountType());
		accessTokenStore.setId(accountId.getId());
		if (accountId instanceof CompanyAccountId) {
			accessTokenStore.setAgentId(((CompanyAccountId) accountId).getAgentId());
		}
	}

	private CompanyAccessTokenStore wrap(final CompanyAccountId accountId, final AccessToken token) {
		AccessTokenStore accessTokenStore = new AccessTokenStore();
		copy(accessTokenStore, accountId);
		copy(accessTokenStore, token);
		return accessTokenStore;
	}

	private AccessToken getRemoteToken(AccountId accountId) throws AccessTokenException {
		WechatConfig config = configService.getWechatConfig(accountId);
		if (config == null) {
			throw new AccessTokenException("no proper config for account" + accountId);
		}
		// failure seldom happens ,without fail retry
		int count = 0;
		AccessToken token = null;
		do {
			try {
				AccessTokenResp tokenResp = accessTokenClient.getAccessToken(config);
				if (tokenResp.getErrcode() == 0 || tokenResp.getErrcode() == null) {
					token = tokenResp.toToken();
					break;
				} else {
					logger.error("request wechat remote access token error:" + tokenResp);
				}
			} catch (RemoteException e) {
				if (count == refreshConfig.getRetryTimes() - 1) {
					throw new AccessTokenException("call wechat server meets error.", e);
				} else {
					logger.error("request wechat remote access token error", e);
				}
			}

		} while (count++ < refreshConfig.getRetryTimes());
		if (token == null) {
			throw new AccessTokenException("call wechat server meets error,please view previous logs.");
		}
		return token;
	}

	// 当access_token不合法时,都需要强制阻塞更新
	private boolean requireHoldon(AccessToken accessToken) {
		boolean requireHoldon = accessToken == null || accessToken.getRefreshTime() == null
				|| accessToken.getExpires_in() <= 0 || StringUtils.isBlank(accessToken.getAccess_token())
				// 以下为自定义配置临界条件:Token刷新时间
				|| ((System.currentTimeMillis() - accessToken.getRefreshTime().getTime()) > (accessToken.getExpires_in()
						- refreshConfig.getHoldonThreshold()) * 1000);
		if (requireHoldon) {
			logger.warn("access-token is expired." + JSON.toJSONString(accessToken));
		}
		return requireHoldon;
	}

	// (当前时间 - 开始时间) ms < (过期时长 -安全阈值)s*1000
	private boolean isSafe(AccessToken accessToken) {
		return (accessToken != null && accessToken.getRefreshTime() != null && accessToken.getExpires_in() > 0)
				// 时间在缓存安全阈值范围内
				&& (System.currentTimeMillis() - accessToken.getRefreshTime().getTime()) < (accessToken.getExpires_in()
						- refreshConfig.getAsyncRefreshThreshold()) * 1000;
	}
}
