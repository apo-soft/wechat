/**
 * 
 */
package cn.aposoft.wechat.mp.access;

/**
 * 多AccessToken管理服务
 * 
 * @author Jann Liu
 *
 */
public interface AccessTokenManagement {
	/**
	 * 获取公众号,服务号API访问授权码
	 * 
	 * @param accessId
	 *            accessToken对应微信公众号,服务号
	 * @return 访问授权码
	 */
	AccessToken getAccessToken(AccessId accessId);



}
