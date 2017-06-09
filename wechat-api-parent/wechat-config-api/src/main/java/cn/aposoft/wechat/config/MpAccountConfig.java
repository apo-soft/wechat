/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.config;

import java.io.Serializable;

import cn.aposoft.wechat.AccountTypeAware;
import cn.aposoft.wechat.signature.SignatureConfig;

/**
 * 微信公众号配置
 * 
 * @author Jann Liu
 * @date 2016年10月12日
 * @since 1.0
 */
public interface MpAccountConfig extends AccountTypeAware, SignatureConfig, AccountConfig, Serializable {
	/**
	 * 
	 * @return 微信公众号的userId,企业号无此项
	 */
	String getUserId();
}
