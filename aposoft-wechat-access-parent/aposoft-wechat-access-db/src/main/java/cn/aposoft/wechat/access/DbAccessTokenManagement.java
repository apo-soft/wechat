/**
 * 
 */
package cn.aposoft.wechat.access;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.aposoft.wechat.AccountId;
import cn.aposoft.wechat.AccountType;
import cn.aposoft.wechat.CompanyAccountId;
import cn.aposoft.wechat.PersistentErrorException;
import cn.aposoft.wechat.access.repo.DbAccessToken;
import cn.aposoft.wechat.access.repo.DbAccessTokenExample;
import cn.aposoft.wechat.access.repo.DbAccessTokenMapper;

/**
 * 使用Database完成accessToken的缓存
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DbAccessTokenManagement implements CompanyAccessTokenManagement {
	final static Logger logger = LoggerFactory.getLogger(DbAccessTokenManagement.class);
	private DbAccessTokenMapper dbAccessTokenMapper;

	public DbAccessTokenManagement() {
	}

	public DbAccessTokenManagement(DbAccessTokenMapper dbAccessTokenMapper) {
		this.dbAccessTokenMapper = dbAccessTokenMapper;
	}

	private static AccessToken wrap(AccessToken accessToken) {
		return new AccessTokenWrapper(accessToken);
	}

	private static void checkCount(int count) {
		if (count <= 0) {
			logger.error("failed to store access token to database.");
			throw new PersistentErrorException("failed to store access token to database.");
		}
	}

	/**
	 * 设置AccessToken,公众号行为
	 */
	@Override
	public void setAccessToken(MpAccessTokenStore token) {
		int count = this.dbAccessTokenMapper.setMpAccessToken(token);
		checkCount(count);
	}

	/**
	 * 综合处理一般性MpAccountId 和 CompanyAccountId
	 */
	@Override
	public AccessToken getAccessToken(final AccountId accountId) {
		return getAccessToken(accountId, false);
	}

	/**
	 * 综合处理一般性MpAccountId 和 CompanyAccountId
	 */
	@Override
	public AccessToken getAccessToken(AccountId accountId, boolean forUpdate) {
		if (accountId == null) {
			return null;
		} else if ((accountId instanceof CompanyAccountId) && ((CompanyAccountId) accountId).getAgentId() != null) {
			return getAccessToken((CompanyAccountId) accountId);
		} else {
			DbAccessTokenExample example = new DbAccessTokenExample().setForUpdate(forUpdate);
			example.createCriteria().andAccountTypeEqualTo(AccountType.MP.name()).andIdEqualTo(accountId.getId());
			List<DbAccessToken> accessTokens = dbAccessTokenMapper.selectByExample(example);
			if (accessTokens != null && !accessTokens.isEmpty()) {
				return wrap(accessTokens.get(0));
			} else {
				return null;
			}
		}
	}

	/**
	 * 读取 AccessToken
	 */
	@Override
	public AccessToken getAccessToken(final CompanyAccountId accountId) {
		return getAccessToken(accountId, false);
	}

	/**
	 * 读取 AccessToken
	 */
	@Override
	public AccessToken getAccessToken(final CompanyAccountId accountId, final boolean forUpdate) {
		if (accountId == null) {
			return null;
		} else {
			DbAccessTokenExample example = new DbAccessTokenExample().setForUpdate(forUpdate);
			example.createCriteria().andAccountTypeEqualTo(AccountType.CORP.name()).andIdEqualTo(accountId.getId())
					.andAgentIdEqualTo(accountId.getAgentId());
			List<DbAccessToken> accessTokens = dbAccessTokenMapper.selectByExample(example);
			if (accessTokens != null && !accessTokens.isEmpty()) {
				return wrap(accessTokens.get(0));
			} else {
				return null;
			}
		}
	}

	/**
	 * 设置企业的Token缓存信息
	 */
	@Override
	public void setAccessToken(CompanyAccessTokenStore token) {
		int count = this.dbAccessTokenMapper.setCompanyAccessToken(token);
		checkCount(count);
	}

	/**
	 * @param dbAccessTokenMapper
	 *            the dbAccessTokenMapper to set
	 */
	public void setDbAccessTokenMapper(DbAccessTokenMapper dbAccessTokenMapper) {
		this.dbAccessTokenMapper = dbAccessTokenMapper;
	}

	static class AccessTokenWrapper extends BasicAccessToken implements AccessToken {
		private static final long serialVersionUID = 1381546217931851968L;

		AccessTokenWrapper(AccessToken accessToken) {
			this.setAccess_token(accessToken.getAccess_token());
			this.setExpires_in(accessToken.getExpires_in());
			this.setRefreshTime(accessToken.getRefreshTime());
		}
	}

}
