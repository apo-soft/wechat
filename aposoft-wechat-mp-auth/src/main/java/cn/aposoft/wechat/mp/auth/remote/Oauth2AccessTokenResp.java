/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth.remote;

import java.util.Date;

import cn.aposoft.wechat.mp.WechatResp;
import cn.aposoft.wechat.mp.auth.Oauth2Token;

/**
 * 第二步：通过code换取网页授权access_token
 * http://mp.weixin.qq.com/wiki/17/c0f37d5704f0b64713d5d2c37b468d75.html
 * 
 * <pre>
 * {
       "access_token":"ACCESS_TOKEN",
       "expires_in":7200,
       "refresh_token":"REFRESH_TOKEN",
       "openid":"OPENID",
       "scope":"SCOPE",
       "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
    }
    
    {"errcode":40029,"errmsg":"invalid code"}
 * </pre>
 * 
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public class Oauth2AccessTokenResp extends WechatResp implements Oauth2Token {
    private static final long serialVersionUID = 6050279488862268646L;

    private String access_token;
    private Integer expires_in;
    private String refresh_token;
    private String openid;
    private String scope;
    private String unionid;
    private Date refreshTime;

    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.aposoft.wechat.mp.auth.Oauth2Token#getAccess_token()
     */
    @Override
    public String getAccess_token() {
        return access_token;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.aposoft.wechat.mp.auth.Oauth2Token#getRefresh_token()
     */
    @Override
    public String getRefresh_token() {
        return refresh_token;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.aposoft.wechat.mp.auth.Oauth2Token#getExpires_in()
     */
    @Override
    public Integer getExpires_in() {
        return expires_in;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.aposoft.wechat.mp.auth.Oauth2Token#getOpenid()
     */
    @Override
    public String getOpenid() {
        return openid;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.aposoft.wechat.mp.auth.Oauth2Token#getScope()
     */
    @Override
    public String getScope() {
        return scope;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cn.aposoft.wechat.mp.auth.Oauth2Token#getUnionid()
     */
    @Override
    public String getUnionid() {
        return unionid;
    }

    @Override
    public Date getRefreshTime() {
        return refreshTime;
    }

}
