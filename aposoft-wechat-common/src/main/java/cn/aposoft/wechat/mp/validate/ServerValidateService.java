/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.validate;

/**
 * 验证微信消息服务器有效性 *
 * 在开发者首次提交验证申请时，微信服务器将发送GET请求到填写的URL上，并且带上四个参数（signature、timestamp、nonce、echostr），开发者通过对签名（即signature）的效验，来判断此条消息的真实性。
 * 
 * 此后，每次开发者接收用户消息的时候，微信也都会带上前面三个参数（signature、timestamp、nonce）访问开发者设置的URL，开发者依然通过对签名的效验判断此条消息的真实性。效验方式与首次提交验证申请一致。
 * 
 * @author LiuJian
 * @date 2016年10月16日
 * 
 */
public interface ServerValidateService {
    /**
     * 参数 描述
     * 
     * @param signature
     *            微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     * @param timestamp
     *            时间戳
     * @param nonce
     *            随机数
     * @param echostr
     *            随机字符串
     * @return 随机字符串 ,失败返回null
     */
    public String echostr(String signature, String timestamp, String nonce, String echostr);

}
