package cn.aposoft.wechat.access;

/**
 * 设置及更新公众号和企业号的AccessToken的本地存储
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface AccessTokenManagement extends AccessTokenAccess {

	/**
	 * 
	 * @param token
	 *            公众号,服务号Token
	 */
	void setAccessToken(MpAccessTokenStore token);
}
