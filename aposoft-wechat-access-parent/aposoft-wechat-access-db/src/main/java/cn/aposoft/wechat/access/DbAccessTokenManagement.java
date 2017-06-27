/**
 * 
 */
package cn.aposoft.wechat.access;

import java.util.List;

import cn.aposoft.wechat.AccountId;
import cn.aposoft.wechat.AccountType;
import cn.aposoft.wechat.CompanyAccountId;
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

	private DbAccessTokenMapper dbAccessTokenMapper;

	private static AccessToken wrap(AccessToken accessToken) {
		return new AccessTokenWrapper(accessToken);
	}

	public DbAccessTokenManagement() {
	}

	public DbAccessTokenManagement(DbAccessTokenMapper dbAccessTokenMapper) {
		this.dbAccessTokenMapper = dbAccessTokenMapper;
	}

	@Override
	public void setAccessToken(MpAccessTokenStore token) {

	}

	/**
	 * 综合处理一般性MpAccountId 和CompanyAccountId
	 */
	@Override
	public AccessToken getAccessToken(AccountId accountId) {
		if (accountId == null) {
			return null;
		} else if ((accountId instanceof CompanyAccountId) && ((CompanyAccountId) accountId).getAgentId() != null) {
			return getAccessToken((CompanyAccountId) accountId);
		} else {
			DbAccessTokenExample example = new DbAccessTokenExample();
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
	public AccessToken getAccessToken(CompanyAccountId accountId) {
		if (accountId == null) {
			return null;
		} else {
			DbAccessTokenExample example = new DbAccessTokenExample();
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
	 * 
	 */
	@Override
	public void setAccessToken(CompanyAccessTokenStore token) {

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
