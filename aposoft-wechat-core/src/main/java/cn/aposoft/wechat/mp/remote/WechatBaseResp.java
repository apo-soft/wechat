/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.remote;

/**
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public class WechatBaseResp {
    private String errcode;
    private String errmsg;

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }
}
