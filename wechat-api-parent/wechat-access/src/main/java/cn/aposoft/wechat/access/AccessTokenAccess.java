/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.account.AccountId;

/**
 * 多公众号,服务号AccessToken管理服务
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface AccessTokenAccess {
	/**
	 * 获取公众号,服务号API访问授权码
	 * 
	 * @param accountId
	 *            accessToken对应微信公众号,服务号,企业号
	 * @return 访问授权码
	 */
	AccessToken getAccessToken(final AccountId accountId) throws AccessTokenException;

	/**
	 * 获取公众号,服务号API访问授权码
	 * 
	 * @param accountId
	 *            accessToken对应微信公众号,服务号,企业号
	 * @param forUpdate
	 *            标识查询时需要锁定数据，避免数据争用
	 * @return 访问授权码
	 */
	AccessToken getAccessToken(final AccountId accountId, final boolean forUpdate) throws AccessTokenException;
}
