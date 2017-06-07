package cn.aposoft.wechat;

public interface CryptService {
	/**
	 * 将公众平台回复用户的消息加密打包.
	 * <ol>
	 * <li>对要发送的消息进行AES-CBC加密</li>
	 * <li>生成安全签名</li>
	 * <li>将消息密文和安全签名打包成xml格式</li>
	 * </ol>
	 * 
	 * @param replyMsg
	 *            公众平台待回复用户的消息，xml格式的字符串
	 * @param timestamp
	 *            时间戳，可以自己生成，也可以用URL参数的timestamp
	 * @param nonce
	 *            随机串，可以自己生成，也可以用URL参数的nonce
	 * 
	 * @return 加密后的可以直接回复用户的密文，包括msg_signature, timestamp, nonce,
	 *         encrypt的xml格式的字符串
	 * @throws CodecException
	 *             执行失败，请查看该异常的错误码和具体的错误信息
	 */
	public String encryptMsg(String replyMsg, String timestamp, String nonce) throws CodecException;

	/**
	 * 检验消息的真实性，并且获取解密后的明文.
	 * <ol>
	 * <li>利用收到的密文生成安全签名，进行签名验证</li>
	 * <li>若验证通过，则提取xml中的加密消息</li>
	 * <li>对消息进行解密</li>
	 * </ol>
	 * 
	 * @param msgSignature
	 *            签名串，对应URL参数的msg_signature
	 * @param timestamp
	 *            时间戳，对应URL参数的timestamp
	 * @param nonce
	 *            随机串，对应URL参数的nonce
	 * @param postData
	 *            密文，对应POST请求的数据
	 * 
	 * @return 解密后的原文
	 * @throws CodecException
	 *             执行失败，请查看该异常的错误码和具体的错误信息
	 */
	public String decryptMsg(String msgSignature, String timestamp, String nonce, String postData)
			throws CodecException;
}
