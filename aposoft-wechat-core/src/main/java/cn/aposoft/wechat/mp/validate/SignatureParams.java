/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.validate;

/**
 * 验证消息真实性
 * {@link http://mp.weixin.qq.com/wiki/4/2ccadaef44fe1e4b0322355c2312bfa8.html}
 * 
 * @author Jann Liu
 * @date 2016年10月18日
 * 
 */
public interface SignatureParams {
    /**
     * 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     */
    public String getSignature();

    /**
     * 时间戳
     */
    public String getTimestamp();

    /**
     * 随机数
     */
    public String getNonce();
}
