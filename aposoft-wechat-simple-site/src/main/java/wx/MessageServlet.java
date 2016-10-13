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

import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;

import cn.aposoft.wechat.mp.codec.aes.AesException;
import cn.aposoft.wechat.mp.codec.aes.WXBizMsgCrypt;
import cn.aposoft.wechat.mp.config.WechatMpConfig;
import cn.aposoft.wechat.mp.config.basic.WechatMpConfigFactory;

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
    private static final org.slf4j.Logger messageLogger = LoggerFactory.getLogger("wx.message");

    private WXBizMsgCrypt crypt;

    @Override
    public void init(ServletConfig config) {
        final WechatMpConfig wxConfig = WechatMpConfigFactory.getConfig();
        try {
            crypt = new WXBizMsgCrypt(wxConfig.getToken(), wxConfig.getAppId(), wxConfig.getAppSecret());
        } catch (AesException e) {
            // this must not happen
            throw new Error("aes key initialize error", e);
        }
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
        
    }

    // 读取用户发送的消息
    private void readMessage(HttpServletRequest request, HttpServletResponse response) throws IOException, AesException {

        if ("text/xml".equals(request.getContentType())) {
            // msg_signature
            String msgSignature = request.getParameter("msg_signature");
            // timestamp = data.timestamp
            String timeStamp = request.getParameter("timestamp");
            // nonce = data.nonce
            String nonce = request.getParameter("nonce");
            String requestXml = IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8"));
            messageLogger.info(requestXml);
            String origin = crypt.decryptMsg(msgSignature, timeStamp, nonce, requestXml);
            messageLogger.info(origin);

        }
    }
}
