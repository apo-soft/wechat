/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.config;

/**
 * @author LiuJian
 * @date 2016年10月13日
 * 
 */
public class UrlConstant {
    private UrlConstant() {
    }

    /**
     * 微信ACCESS_TOKEN读取URL
     * 
     * {@link https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&lang=zh_CN}
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?";
    /**
     * 
     * 访问请求标准URL及参数
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
     * 第一步：用户同意授权，获取code
     * {@link http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html}
     * 
     */
    public static final String AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?";

    public static final String OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?";

}
