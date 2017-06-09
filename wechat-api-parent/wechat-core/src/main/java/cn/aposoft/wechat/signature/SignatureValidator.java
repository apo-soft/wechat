package cn.aposoft.wechat.signature;

/**
 * 签名验证功能
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface SignatureValidator {
	/**
	 * 设置签名验证的配置项
	 * 
	 * @param config
	 *            {@link SignatureConfig}
	 */
	void setSignatureConfig(SignatureConfig config);

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
	boolean validate(String signature, String timestamp, String nonce);

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
	boolean validate(SignatureAttributes signatureAttributes);

}