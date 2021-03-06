/**
 *   Copyright  :  www.aposoft.cn
 */
package wx;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.constant.Lexical;
import cn.aposoft.util.XmlUtils;
import cn.aposoft.wechat.codec.CodecException;
import cn.aposoft.wechat.codec.CryptService;
import cn.aposoft.wechat.codec.EncryptType;
import cn.aposoft.wechat.codec.aes.AesException;
import cn.aposoft.wechat.config.WechatMpConfigFactory;
import cn.aposoft.wechat.crypt.BasicCryptService;
import cn.aposoft.wechat.echo.EchoValidator;
import cn.aposoft.wechat.mp.message.MessageRequestParams;
import cn.aposoft.wechat.mp.message.MessageService;
import cn.aposoft.wechat.mp.message.impl.AposoftIntegratedMessage;
import cn.aposoft.wechat.mp.message.news.NewsService;
import cn.aposoft.wechat.mp.message.template.Message;
import cn.aposoft.wechat.signature.AposoftSignatureEchoValidator;

/**
 * 接收消息的Servlet
 * 
 * @author Jann Liu
 * @date 2016年10月14日
 * @since 1.0
 */
@SuppressWarnings("serial")
@WebServlet("/")
public class MessageServlet extends HttpServlet {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MessageServlet.class);
	private static final org.slf4j.Logger messageLogger = LoggerFactory.getLogger("wx.message");

	private CryptService crypt;
	private EchoValidator signature;
	private MessageService messageService;
	boolean forceValidate = false;

	@Override
	public void init(ServletConfig config) {
		try {
			signature = new AposoftSignatureEchoValidator(WechatMpConfigFactory.getConfig());
			crypt = new BasicCryptService(WechatMpConfigFactory.getConfig());
		} catch (AesException e) {
			// this must not happen
			logger.error("meets error while init crypt", e);
			throw new Error("aes key initialize error", e);
		}
		messageService = new NewsService(WechatMpConfigFactory.getConfig());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpUtils.printHeaders(request);
		HttpUtils.printParams(request);

		// 入参解析
		MessageRequestParams messageParams = parseRequestParams(request);

		// 通用验签
		boolean isSignatureValid = signature.validate(messageParams);

		if (!isSignatureValid) {
			if (forceValidate) {
				logger.error("signature is not valid" + JSON.toJSONString(messageParams));
				return;
			} else {
				if (signature.validate(messageParams)) {
					logger.warn("signature is empty" + JSON.toJSONString(messageParams));
				}
				logger.warn("signature is not valid" + JSON.toJSONString(messageParams));
			}
		}

		try {
			// 判定是否是服务器验证逻辑
			if (signature.hasEchostr(messageParams)) {
				if (isSignatureValid) {
					response.getWriter().print(messageParams.getEchostr());
				}
			}
			// 明文
			String plainPostData = null;
			// 读取传入消息
			if ("POST".equalsIgnoreCase(request.getMethod())) {
				String postData = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
				// 解密
				plainPostData = decode(messageParams, postData);
			}
			// Mapping
			AposoftIntegratedMessage requestMessage = XmlUtils.xml2Object(plainPostData,
					AposoftIntegratedMessage.class);
			// 读取返回消息
			String replyMsg = getRespMessage(requestMessage);

			// 输出返回值
			response.setCharacterEncoding(Lexical.UTF8);
			response.setContentType("text/xml");
			response.getWriter().print(encode(messageParams, replyMsg));
		} catch (AesException | JAXBException e) {
			logger.error("read message error.", e);
		} catch (Exception e) {
			logger.error("unexpected error:", e);

		}
	}

	/**
	 * 当入参使用加密时，返回值也需要加密
	 * 
	 * @param messageParams
	 *            消息参数
	 * @param plainResponseText
	 *            应答报文内容
	 * @return 编码后应答报文
	 * @throws AesException
	 *             加密失败抛出此异常
	 */
	private String encode(final MessageRequestParams messageParams, final String plainResponseText)
			throws CodecException {
		String replyMsg = plainResponseText;
		messageLogger.info(replyMsg);
		// 条件加密
		if (EncryptType.AES.getType().equals(messageParams.getEncrypt_type())) {
			// 返回的约束
			String timestamp = String.valueOf(System.currentTimeMillis());
			String nonce = RandomStringUtils.randomNumeric(16);
			replyMsg = crypt.encryptMsg(replyMsg, timestamp, nonce);
			messageLogger.info(replyMsg);
		}
		return replyMsg;
	}

	// optional decrypt the request text
	private String decode(MessageRequestParams messageParams, String postData) throws CodecException {
		String origin = postData;
		messageLogger.info(origin);
		if (EncryptType.AES.getType().equals(messageParams.getEncrypt_type())) {
			origin = crypt.decryptMsg(messageParams.getMsg_signature(), messageParams.getTimestamp(),
					messageParams.getNonce(), postData);
			messageLogger.info(origin);
		}
		return origin;
	}

	private MessageRequestParams parseRequestParams(HttpServletRequest request) {
		MessageRequestParams params = new MessageRequestParams();
		params.setEchostr(request.getParameter("echostr"));
		params.setEncrypt_type(request.getParameter("encrypt_type"));
		params.setMsg_signature(request.getParameter("msg_signature"));
		params.setNonce(request.getParameter("nonce"));
		params.setOpenid(request.getParameter("openid"));
		params.setSignature(request.getParameter("signature"));
		params.setTimestamp(request.getParameter("timestamp"));
		return params;
	}

	// 读取默认的返回值消息
	private String getRespMessage(Message requestMessage) {
		if (requestMessage == null) {
			return null;
		}
		String respMessage = messageService.getReplyMessage(requestMessage).toString();
		return respMessage;
	}
}
