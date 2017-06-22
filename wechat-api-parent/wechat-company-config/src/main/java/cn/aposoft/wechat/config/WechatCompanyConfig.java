/**
 * 
 */
package cn.aposoft.wechat.config;

import java.io.Serializable;

import cn.aposoft.wechat.AccountTypeAware;
import cn.aposoft.wechat.signature.SignatureConfig;

/**
 * 企业号配置信息
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface WechatCompanyConfig extends AccountTypeAware, SignatureConfig, CompanyAccountConfig, Serializable {

}
