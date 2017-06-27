/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.AccountId;
import cn.aposoft.wechat.CompanyAccountId;
import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.CompanyAccessTokenManagement;
import cn.aposoft.wechat.access.CompanyAccessTokenStore;
import cn.aposoft.wechat.access.MpAccessTokenStore;

/**
 * 使用Database完成accessToken的缓存
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DbAccessTokenManagement implements CompanyAccessTokenManagement {

	@Override
	public void close() {

	}

	@Override
	public void setAccessToken(MpAccessTokenStore token) {

	}

	@Override
	public AccessToken getAccessToken(AccountId accountId) {
		return null;
	}

	@Override
	public AccessToken getAccessToken(CompanyAccountId accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAccessToken(CompanyAccessTokenStore token) {
		// TODO Auto-generated method stub

	}

}
