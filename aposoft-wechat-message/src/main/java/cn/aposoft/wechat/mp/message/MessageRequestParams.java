/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message;

import java.io.Serializable;

import cn.aposoft.wechat.mp.validate.SignatureParams;
import cn.aposoft.wechat.mp.validate.ValidateParams;

/**
 * 微信服务器转发消息参数集合
 * 
 * @author Jann Liu
 * @date 2016年10月16日
 * 
 */
public class MessageRequestParams implements ValidateParams, SignatureParams, Serializable {
    private static final long serialVersionUID = 3076379283072980675L;
    /**
     * 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     */
    private String signature;
    /**
     * 时间戳
     */
    private String timestamp;
    /**
     * 随机数
     */
    private String nonce;
    /**
     * 随机字符串
     */
    private String echostr;

    /**
     * 加密类型
     */
    private String encrypt_type;

    /**
     * 加密消息签名
     */
    private String msg_signature;
    /**
     * opendid from user
     */
    private String openid;

    public String getSignature() {
        return signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    /**
     * @return the encrypt_type
     */
    public String getEncrypt_type() {
        return encrypt_type;
    }

    /**
     * @param encrypt_type
     *            the encrypt_type to set
     */
    public void setEncrypt_type(String encrypt_type) {
        this.encrypt_type = encrypt_type;
    }

    /**
     * @return the msg_signature
     */
    public String getMsg_signature() {
        return msg_signature;
    }

    /**
     * @param msg_signature
     *            the msg_signature to set
     */
    public void setMsg_signature(String msg_signature) {
        this.msg_signature = msg_signature;
    }

    /**
     * @return the openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid
     *            the openid to set
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

}
