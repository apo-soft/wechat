/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.CompanyAccountId;

/**
 * 企业访问授权码管理
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface CompanyAccessTokenAccess extends AccessTokenAccess {
	/**
	 * 获取企业API访问授权码
	 * 
	 * @param accessId
	 *            accessToken对应微信企业号应用ID
	 * @return 访问授权码
	 */
	AccessToken getAccessToken(CompanyAccountId accountId);
}
