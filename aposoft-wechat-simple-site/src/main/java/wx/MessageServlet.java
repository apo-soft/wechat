/**
 *   Copyright  :  www.aposoft.cn
 */
package wx;

import java.io.IOException;

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

import cn.aposoft.wechat.mp.codec.EncryptType;
import cn.aposoft.wechat.mp.codec.aes.AesException;
//import cn.aposoft.wechat.mp.config.WechatMpConfig;
//import cn.aposoft.wechat.mp.config.basic.WechatMpConfigFactory;
import cn.aposoft.wechat.mp.constant.Lexical;
import cn.aposoft.wechat.mp.crypt.CryptService;
import cn.aposoft.wechat.mp.crypt.impl.BasicCryptService;
import cn.aposoft.wechat.mp.message.MessageParams;
import cn.aposoft.wechat.mp.message.MessageReplyService;
import cn.aposoft.wechat.mp.message.impl.AposoftIntegratedMessage;
import cn.aposoft.wechat.mp.message.impl.AposoftReceivedMessage;
import cn.aposoft.wechat.mp.message.impl.NewsReplyService;
import cn.aposoft.wechat.mp.util.XmlUtils;
import cn.aposoft.wechat.mp.validate.ServerValidateService;
import cn.aposoft.wechat.mp.validate.impl.BasicServerValidateService;

/**
 * 接收消息的Servlet
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/")
public class MessageServlet extends HttpServlet {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MessageServlet.class);
    private static final org.slf4j.Logger messageLogger = LoggerFactory.getLogger("wx.message");

    private CryptService crypt;
    private MessageReplyService messageService;
    private ServerValidateService serverValidateService;

    @Override
    public void init(ServletConfig config) {
        try {
            crypt = new BasicCryptService();
        } catch (AesException e) {
            // this must not happen
            logger.error("meets error while init crypt", e);
            throw new Error("aes key initialize error", e);
        }
        messageService = new NewsReplyService();
        serverValidateService = new BasicServerValidateService();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpUtils.printHeaders(request);
        HttpUtils.printParams(request);

        MessageParams messageParams = getMessageParams(request);

        try {
            // 判定是否是服务器验证逻辑
            if (isVerifyRequest(messageParams)) {
                String echostr = serverValidateService.echostr(messageParams.getSignature(), messageParams.getTimestamp(), messageParams.getNonce(),
                        messageParams.getEchostr());
                if (echostr != null) {
                    response.getWriter().print(echostr);
                    return;
                }
            }
            String origin = null;
            // 读取传入消息
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String postData = IOUtils.toString(request.getInputStream(), Lexical.UTF8_CHARSET);
                // 解密
                origin = getPostText(messageParams, postData);

            }
            // Mapping
            AposoftReceivedMessage receivedMessage = XmlUtils.xml2Object(origin, AposoftIntegratedMessage.class);
            // 读取返回消息
            String replyMsg = getRespMessage(receivedMessage);
            // 条件性加密
            replyMsg = getResponseText(messageParams, replyMsg);
            // 输出返回值
            response.setCharacterEncoding(Lexical.UTF8);
            response.setContentType("text/xml");
            response.getWriter().print(replyMsg);
        } catch (AesException | JAXBException e) {
            logger.error("read message error.", e);
        } catch (Exception e) {
            logger.error("unexpected error:", e);

        }
    }

    private String getResponseText(final MessageParams messageParams, final String plainResponseText) throws AesException {
        String replyMsg = plainResponseText;
        messageLogger.info(replyMsg);
        // 条件加密
        if (EncryptType.AES.getType().equals(messageParams.getEncrypt_type())) {
            // 返回的约束
            String timeStamp = String.valueOf(System.currentTimeMillis());
            String nonce = RandomStringUtils.randomNumeric(16);
            replyMsg = crypt.encryptMsg(replyMsg, timeStamp, nonce);
            messageLogger.info(replyMsg);
        }
        return replyMsg;
    }

    // optional decrypt the request text
    private String getPostText(MessageParams messageParams, String postData) throws AesException {
        String origin = postData;
        messageLogger.info(origin);
        if (EncryptType.AES.getType().equals(messageParams.getEncrypt_type())) {
            origin = crypt.decryptMsg(messageParams.getMsg_signature(), messageParams.getTimestamp(), messageParams.getNonce(), postData);
            messageLogger.info(origin);
        }
        return origin;
    }

    private MessageParams getMessageParams(HttpServletRequest request) {
        MessageParams params = new MessageParams();
        params.setEchostr(request.getParameter("echostr"));
        params.setEncrypt_type(request.getParameter("encrypt_type"));
        params.setMsg_signature(request.getParameter("msg_signature"));
        params.setNonce(request.getParameter("nonce"));
        params.setOpenid(request.getParameter("openid"));
        params.setSignature(request.getParameter("signature"));
        params.setTimestamp(request.getParameter("timestamp"));
        return params;
    }

    private boolean isVerifyRequest(MessageParams messageParams) {
        if (messageParams.getSignature() != null && messageParams.getTimestamp() != null && messageParams.getNonce() != null
                && messageParams.getEchostr() != null) {
            return true;
        }
        return false;
    }

    // 读取默认的返回值消息
    private String getRespMessage(AposoftReceivedMessage receivedMessage) {
        if (receivedMessage == null) {
            return null;
        }
        String respMessage = messageService.getReplyMessage(receivedMessage).toString();
        return respMessage;
    }
}
