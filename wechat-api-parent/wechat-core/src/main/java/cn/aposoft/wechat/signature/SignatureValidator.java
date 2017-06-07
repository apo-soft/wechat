package cn.aposoft.wechat.signature;

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

	/**
	 * 签名有效性验证方法
	 * 
	 * @param signatureAttributes
	 * @return 签名有效性验证判断结果 true/false
	 * 
	 */
	boolean isSignatureValid(SignatureAttributes signatureAttributes);

}