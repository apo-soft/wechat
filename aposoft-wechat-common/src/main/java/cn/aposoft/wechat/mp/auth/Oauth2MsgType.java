/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth;

/**
 * Oauth2验证返回消息类型
 * 
 * @author LiuJian
 * @date 2016年10月16日
 * 
 */
public enum Oauth2MsgType {
    ACCESS_TOKEN("access_token"), USER_INFO("user_info"), AUTH("auth");
    private Oauth2MsgType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
