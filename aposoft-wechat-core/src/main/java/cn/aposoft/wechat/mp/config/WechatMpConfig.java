/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.config;

/**
 * 微信公众号配置
 * 
 * @author Jann Liu
 * @date 2016年10月12日
 * 
 */
public interface WechatMpConfig {
	/**
	 * 用户ID:开发者微信ID <br/>
	 * gh_0f504b63df22
	 */
	String getUserId();

	/**
	 * 微信公众号APPID <br/>
	 * wx31659662068251dc
	 */
	String getAppId();

	/**
	 * 微信AppSecret <br/>
	 * 9cf9858af4718fde40d67968b5de3967
	 */
	String getAppSecret();

	/**
	 * Token 自定义的 Token AposoftBugs
	 */
	String getToken();

	/**
	 * EncodingAESKey (消息加解密密钥) 43位
	 */
	String getEncodingAESKey();

	/**
	 * 
	 * @return 会话过期时间保护
	 */
	int getExpiredThreshold();
}
