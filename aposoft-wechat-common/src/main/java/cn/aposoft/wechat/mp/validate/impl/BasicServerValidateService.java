/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.validate.impl;

import cn.aposoft.wechat.mp.validate.ServerValidateService;
import cn.aposoft.wechat.mp.validate.SignatureValidator;

/**
 * @author LiuJian
 * @date 2016年10月16日
 * 
 */
public class BasicServerValidateService implements ServerValidateService {
    /*
     * 验证signature是否一致，如果一致，返回echostr，否则返回null
     * 
     * @see
     * cn.aposoft.wechat.mp.validate.ServerValidateService#echostr(java.lang.
     * String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String echostr(String signature, String timestamp, String nonce, String echostr) {
        {
            if (SignatureValidator.validate(signature, timestamp, nonce)) {
                return echostr;
            } else {
                return null;
            }
        }
    }

}
