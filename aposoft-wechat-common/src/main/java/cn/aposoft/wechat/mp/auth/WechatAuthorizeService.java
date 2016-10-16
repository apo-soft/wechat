/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth;

/**
 * @author LiuJian
 * @date 2016年10月13日
 * 
 */
public interface WechatAuthorizeService {

    /**
     * 读取授权重定向URL
     * http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
     * 
     * @param redirectUri
     *            授权后重定向的回调链接地址，请使用urlencode对链接进行处理
     * @param scope
     *            应用授权作用域，snsapi_base
     *            （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo
     *            （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     * @return 授权请求URL
     */
    String getRedirectUrl(String redirectUri, String scope);

    /**
     * 读取授权TOKEN
     * 
     * @param code
     *            微信返回的授权code
     * @param state
     *            请求授权时发出的随机码
     * @return 用户OPENID 及对应的访问授权信息
     */
    Oauth2Token getOauth2Token(String code, String state);

    /**
     * 读取用户信息
     * 
     * @param accessToken
     *            访问token
     * @param openId
     *            用户id
     * @return 用户信息
     */
    WechatUserInfo getUserInfo(String accessToken, String openId);

    /**
     * 验证授权是否有效
     * 
     * @param accessToken
     *            授权访问id
     * @param openId
     *            用户id
     * @return 验证结果
     */
    Oauth2Auth auth(String accessToken, String openId);
}
