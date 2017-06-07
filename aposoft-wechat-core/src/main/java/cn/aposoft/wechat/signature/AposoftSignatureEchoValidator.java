/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.signature;

import org.apache.commons.lang.StringUtils;

import cn.aposoft.wechat.echo.EchoAttributes;
import cn.aposoft.wechat.echo.EchoValidator;

/**
 * 微信服务器签名有效性验证
 * 
 * @see EchoValidator
 * @see SignatureValidator
 * @author Jann Liu
 * @date 2016年10月16日
 * 
 */
public class AposoftSignatureEchoValidator implements SignatureValidator, EchoValidator {

	SignatureConfig config;

	public AposoftSignatureEchoValidator(SignatureConfig config) {
		this.config = config;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.mp.signature.SignatureValidator#validate(java.lang.
	 * String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validate(String signature, String timestamp, String nonce) {
		// 官方标准的 服务器认证返回码
		String hashCode = cn.aposoft.wechat.codec.digest.DigestUtils.sha1Hex(nonce, timestamp, config.getToken());
		return signature != null && signature.equals(hashCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.mp.signature.SignatureValidator#validate(cn.aposoft.
	 * wechat.mp.signature.SignatureParams)
	 */
	@Override
	public boolean validate(SignatureAttributes signatureAttributes) {
		if (!isSignatureValid(signatureAttributes)) {
			return false;
		}
		return validate(signatureAttributes.getSignature(), signatureAttributes.getTimestamp(),
				signatureAttributes.getNonce());
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
	public boolean isSignatureValid(SignatureAttributes signatureAttributes) {
		return StringUtils.isNotBlank(signatureAttributes.getSignature())
				&& StringUtils.isNotBlank(signatureAttributes.getTimestamp())
				&& StringUtils.isNotBlank(signatureAttributes.getNonce());
	}

	public boolean hasEchostr(EchoAttributes echoAttributes) {
		if (echoAttributes == null)
			return false;
		return StringUtils.isNotBlank(echoAttributes.getEchostr());
	}

	/**
	 * @see SignatureConfig
	 * @see
	 */
	@Override
	public void setSignatureConfig(SignatureConfig config) {
		if (config != null) {
			this.config = config;
		}
	}
}
