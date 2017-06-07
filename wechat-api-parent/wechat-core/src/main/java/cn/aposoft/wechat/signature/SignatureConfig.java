/**
 * 
 */
package cn.aposoft.wechat.signature;

/**
 * 签名配置项
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface SignatureConfig {
	/**
	 * 
	 * @return 公众号ID,服务号ID
	 */
	String getAppId();

	/**
	 * 
	 * @return 签名设置的token
	 */
	String getToken();

	/**
	 * 
	 * @return AES编码Key
	 */
	String getEncodingAESKey();

}