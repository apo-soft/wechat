/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth.remote;

import java.util.List;

import cn.aposoft.wechat.mp.auth.WechatUserInfo;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 
 * <pre>
 * {
   "openid":" OPENID",
   " nickname": NICKNAME,
   "sex":"1",
   "province":"PROVINCE"
   "city":"CITY",
   "country":"COUNTRY",
    "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46", 
    "privilege":[
    "PRIVILEGE1"
    "PRIVILEGE2"
    ],
    "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
}
 * </pre>
 * 
 * @author Jann Liu
 * @date 2016年10月15日
 * 
 */
public class WechatUserInfoResp extends WechatResp implements WechatUserInfo {
    private static final long serialVersionUID = -259531452583431756L;
    private String openid;
    private String nickname;
    private Integer sex;
    private String province;

    private String city;
    private String country;
    private String headimgurl;
    private String unionid;
    private List<String> privilege;

    public String getOpenid() {
        return openid;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public String getUnionid() {
        return unionid;
    }

    public List<String> getPrivilege() {
        return privilege;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public void setPrivilege(List<String> privilege) {
        this.privilege = privilege;
    }

}
