/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth;

import java.util.Date;

/**
 * 微信用户获取用户授权信息的Oauth2协议的AccessToken
 * 
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public interface Oauth2Token {
    /**
     * 访问Token
     */
    String getAccess_token();

    /**
     * 刷新Token
     */
    String getRefresh_token();

    /**
     * 过期时间
     * 
     */
    Integer getExpires_in();

    /**
     * 用户公众号OPENID
     */
    String getOpenid();

    /**
     * 授权范围
     */
    String getScope();

    /**
     * 联合ID
     */
    String getUnionid();

    /**
     * 刷新openId时间
     * 
     * @return 刷新的时间
     */
    Date getRefreshTime();
}
