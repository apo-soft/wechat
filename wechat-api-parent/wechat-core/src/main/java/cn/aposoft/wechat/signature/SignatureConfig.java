/**
 * 
 */
package cn.aposoft.wechat.signature;

/**
 * 签名配置项
 * 
 * @author Jann Liu
 *
 */
public interface SignatureConfig {

	String getAppId();

	String getToken();

	String getEncodingAESKey();

}
