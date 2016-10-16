/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.validate;

import cn.aposoft.wechat.mp.config.basic.WechatMpConfigFactory;

/**
 * 微信服务器签名有效性验证
 * 
 * @author LiuJian
 * @date 2016年10月16日
 * 
 */
public class SignatureValidator {
    /**
     * 验证消息真实性
     * 
     * @param signature
     *            消息签名
     * @param timestamp
     *            时间戳
     * @param nonce
     *            随机字符串
     * @return 验证结果
     */
    public static boolean validate(String signature, String timestamp, String nonce) {
        // 官方标准的 服务器认证返回码
        String hashCode = cn.aposoft.wechat.mp.codec.digest.DigestUtils.sha1Hex(nonce, timestamp, WechatMpConfigFactory.getConfig().getToken());
        return signature != null && signature.equals(hashCode);
    }
}
