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

import cn.aposoft.wechat.mp.auth.WechatAuthorizeService;
import cn.aposoft.wechat.mp.auth.impl.WechatAuthorizeServiceFactory;
import cn.aposoft.wechat.mp.auth.remote.Oauth2AccessTokenClient;

/**
 * 获取用户授权的Servlet /oauth2/authorize
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/oauth2/authorize")
public class Oauth2AuthorizeServlet extends HttpServlet {

    private WechatAuthorizeService service;

    @Override
    public void init(ServletConfig config) {
        if (!WechatAuthorizeServiceFactory.isInit()) {
            WechatAuthorizeServiceFactory.setClient(Oauth2AccessTokenClient.getInstance());
        }
        service = WechatAuthorizeServiceFactory.getService();
    }

    @Override
    public void destroy() {
        Oauth2AccessTokenClient.getInstance().close();
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
        String redirectUrl = service.getRedirectUrl("https://www.aposoft.cn/wx/oauth2/access_token", "snsapi_userinfo");
        response.sendRedirect(redirectUrl);
    }
}
