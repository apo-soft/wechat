/**
 * 
 */
package cn.aposoft.wechat.mp.access;

/**
 * 企业访问授权码管理
 * 
 * @author Jann Liu
 *
 */
public interface CompanyAccessTokenManagement extends AccessTokenManagement {
	/**
	 * 获取企业API访问授权码
	 * 
	 * @param accessId
	 *            accessToken对应微信企业号应用ID
	 * @return 访问授权码
	 */
	AccessToken getAccessToken(CompanyAccessId companyAccessId);
}
