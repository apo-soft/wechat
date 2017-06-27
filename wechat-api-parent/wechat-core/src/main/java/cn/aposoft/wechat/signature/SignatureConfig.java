/**
 * 
 */
package cn.aposoft.wechat.signature;

import cn.aposoft.wechat.AccountId;

/**
 * 签名配置项
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface SignatureConfig extends AccountId {

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
