/**
 * 
 */
package cn.aposoft.wechat.signature;

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
