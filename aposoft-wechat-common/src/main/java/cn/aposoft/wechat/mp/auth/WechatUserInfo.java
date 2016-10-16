/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth;

import java.util.List;

/**
 * 微信返回用户信息
 * 
 * @author LiuJian
 * @date 2016年10月15日
 * 
 */
public interface WechatUserInfo {

    public String getOpenid();

    public String getNickname();

    public Integer getSex();

    public String getProvince();

    public String getCity();

    public String getCountry();

    public String getHeadimgurl();

    public String getUnionid();

    public List<String> getPrivilege();

}
