/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.CompanyAccountId;

/**
 * 企业访问授权码管理
 * <p>
 * 为保持最大兼容性,企业授权码管理服务的实现将同时保留对一般授权码的管理实现
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
	 * @throws AccessTokenException
	 */
	AccessToken getAccessToken(final CompanyAccountId accountId) throws AccessTokenException;

	/**
	 * 获取企业API访问授权码
	 * 
	 * @param accessId
	 *            accessToken对应微信企业号应用ID
	 * @param forUpdate
	 *            是否锁定授权码，为后续使用
	 * @return 访问授权码
	 */
	AccessToken getAccessToken(final CompanyAccountId accountId, boolean forUpdate) throws AccessTokenException;
}
