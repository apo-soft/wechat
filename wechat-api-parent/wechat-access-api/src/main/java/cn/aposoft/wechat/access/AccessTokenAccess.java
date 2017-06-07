/**
 * 
 */
package cn.aposoft.wechat.access;

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
	 * @param accessId
	 *            accessToken对应微信公众号,服务号
	 * @return 访问授权码
	 */
	AccessToken getAccessToken(AccessId accessId);

}
