/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenAccess;

/**
 * 企业访问授权码管理
 * 
 * @author Jann Liu
 *
 */
public interface CompanyAccessTokenAccess extends AccessTokenAccess {
	/**
	 * 获取企业API访问授权码
	 * 
	 * @param accessId
	 *            accessToken对应微信企业号应用ID
	 * @return 访问授权码
	 */
	AccessToken getAccessToken(CompanyAccessId companyAccessId);
}
