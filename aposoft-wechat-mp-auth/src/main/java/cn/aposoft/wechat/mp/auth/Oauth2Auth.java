/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth;

import java.io.Serializable;

/**
 * @author Jann Liu
 * @date 2016年10月15日
 * 
 */
public interface Oauth2Auth extends Serializable {

    public Integer getErrcode();

    public String getErrmsg();
}
