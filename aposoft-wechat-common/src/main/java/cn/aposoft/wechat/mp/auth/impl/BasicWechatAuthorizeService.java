/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.mp.auth.Oauth2Token;
import cn.aposoft.wechat.mp.auth.WechatAuthorizeService;
import cn.aposoft.wechat.mp.auth.remote.Oauth2AccessTokenClient;
import cn.aposoft.wechat.mp.auth.remote.Oauth2AccessTokenResp;
import cn.aposoft.wechat.mp.config.UrlConstant;
import cn.aposoft.wechat.mp.config.basic.WechatMpConfigFactory;
import cn.aposoft.wechat.mp.util.RemoteException;
import cn.aposoft.wechat.mp.util.URLEncoder;

/**
 * 默认的微信授权请求服务类
 * 
 * @author LiuJian
 * @date 2016年10月13日
 * 
 */
public class BasicWechatAuthorizeService implements WechatAuthorizeService {
    private static final Logger logger = LoggerFactory.getLogger(BasicWechatAuthorizeService.class);
    // 随机字符串请求验证：验证通过后，应当从内容中删除
    // 机制不够完善，应当加入合理的超时机制
    private final ConcurrentMap<String, Object> stateSet = new ConcurrentHashMap<>();
    // Oauth2 客户端
    private Oauth2AccessTokenClient client;

    public String getRandomState() {
        boolean isSet = true;
        do {
            // 生成16位随机字符串
            String nonce = RandomStringUtils.randomNumeric(16);
            Object prevObj = stateSet.putIfAbsent(nonce, nonce);
            if (prevObj != null) {
                isSet = true;
            }
            return nonce;
        } while (isSet);
    }

    /**
     * 获取RedirectUrl 开发文档 :<br />
     * 
     * <pre>
     * <a href=
    'http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html'>第一步：用户同意授权，获取code</a>
     * </pre>
     * 
     * 标准模板url
     * 
     * <pre>
     * https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
     * </pre>
     */
    @Override
    public String getRedirectUrl(String redirectUri, String scope) {
        String appId = WechatMpConfigFactory.getConfig().getAppId();
        String encodedUrl = URLEncoder.encode(redirectUri);
        String resonseType = "code";
        // Random 字符考虑是否缓存,做后续校验
        String state = getRandomState();
        String wechatRedirectUrl = String
                .format("%s" + "appid=%s" + "&redirect_uri=%s" + "&response_type=%s" + "&scope=%s" + "&state=%s#wechat_redirect"//
                        , UrlConstant.AUTHORIZE_URL // 授权URL地址
                        , appId // 公众号ID
                        , encodedUrl // 重定向地址
                        , scope // 应用授权作用域，snsapi_base
                                // （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo
                                // （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
                        , resonseType// 固定为code
                        , state); // nonce 无意义随机字符串

        return wechatRedirectUrl;
    }

    /**
     * appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     * 
     * @param code
     *            code说明 ：
     *            code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
     * @param state
     *            要求用户授权时，传给微信服务器的state参数
     * @return 授权成功时,返回AccessToken,当state不存在时,返回null
     */
    @Override
    public Oauth2Token getOauth2Token(String code, String state) {
        // 校验state有效性 当前不做校验
        if (stateSet.containsKey(state)) {
            stateSet.remove(state);
        } else {
            return null;
        }

        // 执行code换取accessToken的远程请求
        return getOauth2Token(code);
    }

    /**
     * appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
     * 
     * @param code
     *            code说明 ：
     *            code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
     */
    public Oauth2Token getOauth2Token(String code) {
        Oauth2AccessTokenResp oauth2Token = null;
        try {
            oauth2Token = client.getOauth2Token(code, WechatMpConfigFactory.getConfig());
        } catch (RemoteException e) {
            logger.error("acquire OAuth2 Access Token error.", e);
            return null;
        }
        if (oauth2Token != null && StringUtils.isNotBlank(oauth2Token.getErrcode())) {
            logger.error("acquire OAuth2 Access Token error," + JSON.toJSONString(oauth2Token));
            return null;
        } else if (oauth2Token == null) {
            logger.error("acquire OAuth2 Access Token error return null.");
        }

        return oauth2Token;
    }

}
