/**
 * 
 */
package cn.aposoft.wechat.access.impl;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.RefreshConfig;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.access.remote.AccessTokenResp;
import cn.aposoft.wechat.config.AccountConfig;

/**
 * AccessToken管理基类服务
 * 
 * @author Jann Liu
 * @version 1.0
 */
public abstract class AbstractAccessTokenService implements AccessTokenService {
	private static final Logger logger = LoggerFactory.getLogger(AbstractAccessTokenService.class);
	private final AccessTokenClient client;
	private final AccountConfig accoutConfig;
	private final RefreshConfig refreshConfig;
	protected volatile AccessToken accessToken;
	private int retryTimes = 3;
	/**
	 * 缓存从DB的刷新时间 ms 默认5000
	 */
	private RefreshWorker refreshWorker = new RefreshWorker();

	final ExecutorService executor = Executors.newSingleThreadExecutor();

	public AbstractAccessTokenService(AccessTokenClient client, AccountConfig config, RefreshConfig refreshConfig) {
		this.client = client;
		this.accoutConfig = config;
		this.refreshConfig = refreshConfig;
	}

	/**
	 * 读取AccessToken的抽象方法
	 */
	@Override
	public AccessToken getAccessToken() throws AccessTokenException {
		AccessToken accessToken = get();
		if (requireHoldonRefresh()) {
			accessToken = refresh();
		} else if (requireAsyncRefresh()) {
			asyncRefresh();
		}
		return accessToken;
	}

	@Override
	public void close() {
		client.close();
		if (!executor.isShutdown())
			executor.shutdownNow();
	}

	/**
	 * 是否临近过期
	 * 
	 * @param accessToken
	 * @return 等同于是否需要异步刷新
	 */
	protected boolean isNearlyExpired(AccessToken accessToken) {
		if (accessToken == null || accessToken.getRefreshTime() == null) {
			return true;
		}
		long curr = System.currentTimeMillis();
		long refreshTime = accessToken.getRefreshTime().getTime();
		if (accessToken.getExpires_in() - (curr - refreshTime) / 1000 < refreshConfig.getExpiredThreshold()) {
			if (logger.isDebugEnabled()) {
				logger.debug("remain time:" + (curr - refreshTime) / 1000 + "s.");
			}
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return 返回是否需要阻塞等待刷新
	 */
	protected boolean requireHoldonRefresh() {
		long curr = System.currentTimeMillis();
		if (accessToken == null || accessToken.getRefreshTime() == null) {
			return true;
		}
		long refreshTime = accessToken.getRefreshTime().getTime();
		return (accessToken.getExpires_in() - (curr - refreshTime) / 1000 < refreshConfig.getHoldonThreshold());
	}

	/**
	 * @return 是否需要调用异步刷新
	 */
	protected boolean requireAsyncRefresh() {
		long curr = System.currentTimeMillis();
		long refreshTime = accessToken.getRefreshTime().getTime();
		return accessToken == null
				|| accessToken.getExpires_in() - (curr - refreshTime) / 1000 < refreshConfig.getExpiredThreshold();
	}

	/**
	 * 需要根据具体实现重写此方法,默认返回本地token是否需要异步刷新需求
	 * 
	 * @param currTimestamp
	 *            当前时间戳
	 * @return 本地缓存是否超时
	 */
	protected boolean isLocalCacheTimeout(long currTimestamp) {
		return requireAsyncRefresh();
	}

	/**
	 * 提供了基础的AccessToken的实现 在添加缓存的分布式管理的系统中,需要重写此实现
	 * 
	 * @throws AccessTokenException
	 */
	protected synchronized AccessToken refresh() throws AccessTokenException {
		AccessToken accessToken = get();
		if (accessToken == null || isNearlyExpired(accessToken)) {
			// may throw AccessTokenException
			accessToken = acquireAccessToken();
			set(accessToken);
		}
		return accessToken;
	}

	/**
	 * 从本地或自定义缓存重新加载AccessToken
	 * 
	 * @return 返回当前的本地AccessToken对象
	 * 
	 * @throws IOException
	 */
	protected AccessToken get() {
		return accessToken;
	}

	/**
	 * 实现对AccessToken存储的管理
	 * 
	 * @param accessToken
	 *            访问授权码对象
	 * @throws AccessTokenException
	 */
	protected void set(AccessToken accessToken) throws AccessTokenException {
		this.accessToken = accessToken;
	}

	// 后台读取微信服务器的AccessToken
	/**
	 * 此方法仅实现基于但服务实例的访问一致性管理
	 * 
	 * @return 从微信服务器读取的访问授权码对象
	 * @throws AccessTokenException
	 */
	protected AccessToken acquireAccessToken() throws AccessTokenException {
		AccessToken accessToken = null;
		// 正确读取TOKEN则返回,否则重试3次
		RemoteException ex = null;
		for (int i = 0; i < retryTimes; i++) {
			try {
				Date refreshTime = new Date();
				AccessTokenResp resp = client.getAccessToken(accoutConfig);
				if (resp != null) {
					if (StringUtils.isNotBlank(resp.getAccess_token()) && resp.getExpires_in() != null) {
						BasicAccessToken token = new BasicAccessToken();
						token.setAccess_token(resp.getAccess_token());
						token.setExpires_in(resp.getExpires_in());
						token.setRefreshTime(refreshTime);
						accessToken = token;
						break;
					} else {
						logger.error("wechat access_token, the response is error. code:" + resp.getErrcode()
								+ ",message:" + resp.getErrmsg());
					}
				}
			} catch (RemoteException e) {
				ex = e;
			}
		}
		if (accessToken == null) {
			if (ex != null) {
				throw new AccessTokenException("Can not get wechat access_token from remote server!", ex);
			} else {
				throw new AccessTokenException("Can not get wechat access_token from remote server!");
			}
		} else {
			return accessToken;
		}
	}

	private void asyncRefresh() {
		executor.execute(refreshWorker);
	}

	class RefreshWorker implements Runnable {
		@Override
		public void run() {
			requireAsyncRefresh();
		}
	}

}
