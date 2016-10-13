/**
 *   Copyright  :  www.aposoft.cn
 */
package wx;

import java.io.IOException;
import java.nio.charset.Charset;

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

import cn.aposoft.wechat.mp.codec.aes.AesException;
import cn.aposoft.wechat.mp.codec.aes.WXBizMsgCrypt;
//import cn.aposoft.wechat.mp.config.WechatMpConfig;
//import cn.aposoft.wechat.mp.config.basic.WechatMpConfigFactory;
import cn.aposoft.wechat.mp.constant.Lexical;
import cn.aposoft.wechat.mp.message.MessageReplyService;
import cn.aposoft.wechat.mp.message.impl.NewsReplyService;
import cn.aposoft.wechat.mp.message.template.received.ReceivedMessage;
import cn.aposoft.wechat.mp.message.template.received.Text;
import cn.aposoft.wechat.mp.util.XmlUtils;

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

    private WXBizMsgCrypt crypt;
    private MessageReplyService messageService;

    @Override
    public void init(ServletConfig config) {
        // final WechatMpConfig wxConfig = WechatMpConfigFactory.getConfig();
        // try {
        // crypt = new WXBizMsgCrypt(wxConfig.getToken(), wxConfig.getAppId(),
        // wxConfig.getAppSecret());
        // } catch (AesException e) {
        // // this must not happen
        // logger.error("meets error while init crypt");
        // throw new Error("aes key initialize error", e);
        // }
        messageService = new NewsReplyService();

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
        try {

            ReceivedMessage receivedMessage = readMessage(request);
            String replyMsg = getRespMessage(receivedMessage);
            String timeStamp = String.valueOf(System.currentTimeMillis());
            String nonce = RandomStringUtils.randomNumeric(16);
            String encryptMsg = replyMsg;
            if (crypt != null) {
                encryptMsg = crypt.encryptMsg(replyMsg, timeStamp, nonce);
            }
            response.setCharacterEncoding(Lexical.UTF8);
            response.setContentType("text/xml");
            response.getWriter().write(encryptMsg);
        } catch (AesException | JAXBException e) {
            logger.error("read message error.", e);
        }
    }

    // 读取默认的返回值消息
    private String getRespMessage(ReceivedMessage receivedMessage) {
        return messageService.getDefaultReplyMessage(receivedMessage.getFromUser()).toString();
    }

    // 读取用户发送的消息
    private ReceivedMessage readMessage(HttpServletRequest request) throws IOException, AesException, JAXBException {
        logger.debug(request.getContentType());
        String signature = request.getParameter("signature");
        // msg_signature
        String msgSignature = request.getParameter("msg_signature");
        // timestamp = data.timestamp
        String timeStamp = request.getParameter("timestamp");
        // nonce = data.nonce
        String nonce = request.getParameter("nonce");

        logger.info("params:" + signature + "," + msgSignature + "," + timeStamp + "," + nonce);

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String requestXml = IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8"));
            messageLogger.info(requestXml);
            String origin = requestXml;
            if (crypt != null)
                crypt.decryptMsg(msgSignature, timeStamp, nonce, requestXml);
            messageLogger.info(origin);
            ReceivedMessage receivedMessage = XmlUtils.xml2Object(origin, Text.class);
            return receivedMessage;
        }

        return null;
    }
}
