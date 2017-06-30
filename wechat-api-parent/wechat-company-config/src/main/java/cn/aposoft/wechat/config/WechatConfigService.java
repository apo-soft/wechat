/**
 * 
 */
package cn.aposoft.wechat.config;

import cn.aposoft.wechat.account.AccountId;

/**
 * Wechat综合管理服务，可以通用管理公众号，企业号的配置信息
 * 
 * @author Jann Liu
 *
 */
public interface WechatConfigService extends WechatMpConfigService, WechatCompanyConfigService {

	/**
	 * 
	 * @param accountId
	 *            可以为公众号，或企业号id
	 * 
	 * @return 读取对应的配置信息
	 */
	WechatConfig getWechatConfig(AccountId accountId);
}
