/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth.remote;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.mp.WechatResp;
import cn.aposoft.wechat.mp.auth.Oauth2Auth;

/**
 * @author Jann Liu
 * @date 2016年10月15日
 * 
 */
public class Oauth2AuthResp extends WechatResp implements Oauth2Auth {
    private static final long serialVersionUID = 3739616617334404603L;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
