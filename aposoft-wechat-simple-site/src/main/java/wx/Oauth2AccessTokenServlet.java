/**
 *   Copyright  :  www.aposoft.cn
 */
package wx;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * 获取用户OPENID和授权AccessToken的Servlet
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/oauth2/authorize")
public class Oauth2AccessTokenServlet extends HttpServlet {

}
