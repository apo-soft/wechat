/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.access.impl;

import java.io.Serializable;
import java.util.Date;

import cn.aposoft.wechat.access.AccessToken;

/**
 * 简单的AccessToken实现
 * 
 * @author Jann Liu
 * @date 2016年10月12日
 * 
 */
public class BasicAccessToken implements AccessToken, Serializable {
    private static final long serialVersionUID = 1208800353272982598L;
    private String access_token;
    private int expires_in;
    private Date refreshTime;

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
    }

    /**
     * @see AccessToken#getAccessToken()
     */
    @Override
    public String getAccess_token() {
        return access_token;
    }

    /**
     * @see AccessToken#getExpires_in()
     */
    @Override
    public int getExpires_in() {
        return expires_in;
    }

    /**
     * @see AccessToken#getRefreshTime()
     */
    @Override
    public Date getRefreshTime() {
        return refreshTime;
    }

}
