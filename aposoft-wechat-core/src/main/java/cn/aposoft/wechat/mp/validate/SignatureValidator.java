/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.validate;

import org.apache.commons.lang.StringUtils;

import cn.aposoft.wechat.mp.config.WechatMpConfig;

/**
 * 微信服务器签名有效性验证
 * 
 * @author Jann Liu
 * @date 2016年10月16日
 * 
 */
public class SignatureValidator {

	WechatMpConfig config;

	public SignatureValidator(WechatMpConfig config) {
		this.config = config;
	}

	/**
	 * 验证消息真实性
	 * 
	 * @param signature
	 *            消息签名
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机字符串
	 * @return 验证结果
	 */
	public boolean validate(String signature, String timestamp, String nonce) {
		// 官方标准的 服务器认证返回码
		String hashCode = cn.aposoft.wechat.mp.codec.digest.DigestUtils.sha1Hex(nonce, timestamp, config.getToken());
		return signature != null && signature.equals(hashCode);
	}

	/**
	 * 验证消息真实性
	 * 
	 * @param signature
	 *            消息签名
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机字符串
	 * @return 验证结果
	 */
	public boolean validate(SignatureParams signatureParams) {
		if (!isSignatureValid(signatureParams)) {
			return false;
		}
		return validate(signatureParams.getSignature(), signatureParams.getTimestamp(), signatureParams.getNonce());
	}

	/**
	 * 验证消息真实性
	 * 
	 * @param signature
	 *            消息签名
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机字符串
	 * @return 验证结果
	 */
	public static boolean isSignatureValid(SignatureParams signatureParams) {
		return StringUtils.isNotBlank(signatureParams.getSignature())
				&& StringUtils.isNotBlank(signatureParams.getTimestamp())
				&& StringUtils.isNotBlank(signatureParams.getNonce());
	}

	public static boolean hasEchostr(ValidateParams validateParams) {
		if (validateParams == null)
			return false;
		return StringUtils.isNotBlank(validateParams.getEchostr());
	}
}
