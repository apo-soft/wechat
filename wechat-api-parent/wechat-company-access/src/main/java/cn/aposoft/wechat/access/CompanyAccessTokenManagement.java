/**
 * 
 */
package cn.aposoft.wechat.access;

/**
 * @author Jann Liu
 * @since 1.0
 */
public interface CompanyAccessTokenManagement extends AccessTokenManagement, CompanyAccessTokenAccess {

	/**
	 * 
	 * @param token
	 *            企业号应用Token
	 */
	void setAccessToken(final CompanyAccessTokenStore token);

}
