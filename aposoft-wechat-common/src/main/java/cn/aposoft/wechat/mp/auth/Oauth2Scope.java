/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth;

/**
 * 授权作用域 枚举
 * 
 * 
 * @author LiuJian
 * @date 2016年10月16日
 * 
 */
public enum Oauth2Scope {
    /** 应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid） */
    snsapi_base("snsapi_base"),
    /**
     * 用户授权作用域 snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。
     * 并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     */
    snsapi_userinfo("snsapi_userinfo");

    private Oauth2Scope(String scope) {
        this.scope = scope;
    }

    private String scope;

    /**
     * @return 授权作用域字符串
     */
    public String getScope() {
        return scope;
    }
}
