package cn.aposoft.wechat.mp.crypt.impl;

import cn.aposoft.wechat.mp.SignatureConfig;
import cn.aposoft.wechat.mp.codec.aes.AesException;
import cn.aposoft.wechat.mp.codec.aes.WXBizMsgCrypt;
import cn.aposoft.wechat.mp.crypt.CryptService;

public class BasicCryptService implements CryptService {

	private final WXBizMsgCrypt crypt;

	public BasicCryptService(SignatureConfig config) throws AesException {
		crypt = new WXBizMsgCrypt(config.getToken(), config.getEncodingAESKey(), config.getAppId());
	}

	/**
	 * 将公众平台回复用户的消息加密打包.
	 * <ol>
	 * 
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
	 * @throws AesException
	 *             执行失败，请查看该异常的错误码和具体的错误信息
	 */
	public String encryptMsg(String replyMsg, String timestamp, String nonce) throws AesException {
		return crypt.encryptMsg(replyMsg, timestamp, nonce);
	}

	@Override
	public String decryptMsg(String msgSignature, String timestamp, String nonce, String postData) throws AesException {
		return crypt.decryptMsg(msgSignature, timestamp, nonce, postData);
	}

}
