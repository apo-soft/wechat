/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.validate;

/**
 * 
 * 验证消息真实性 文档
 * {@link http://mp.weixin.qq.com/wiki/4/2ccadaef44fe1e4b0322355c2312bfa8.html}
 * 
 * @author LiuJian
 * @date 2016年10月18日
 * 
 */
public interface ValidateParams extends SignatureParams {
    /**
     * 随机字符串
     */
    public String getEchostr();
}
