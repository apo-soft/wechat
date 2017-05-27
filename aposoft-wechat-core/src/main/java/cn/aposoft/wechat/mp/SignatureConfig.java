/**
 * 
 */
package cn.aposoft.wechat.mp;

/**
 * 签名用配置项
 * 
 * @author Jann Liu
 *
 */
public interface SignatureConfig {

	String getAppId();

	String getToken();

	String getEncodingAESKey();

}
