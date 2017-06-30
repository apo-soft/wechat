/**
 * 
 */
package cn.aposoft.wechat.config;

import cn.aposoft.wechat.CompanyAccountId;

/**
 * 微信企业配置信息管理服务
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface WechatCompanyConfigService {
	/**
	 * 根据企业号,服务号读取配置信息
	 * 
	 * @param id
	 *            企业号id
	 * @param agentId
	 *            应用id
	 * @return 根据MPid读取MP的配置信息
	 */
	WechatCompanyConfig getWechatCompanyConfig(String id, Integer agentId);

	/**
	 * 根据企业号,服务号读取配置信息
	 * 
	 * @param accountId
	 *            企业号账号信息
	 * @return 根据MPid读取MP的配置信息
	 */
	WechatCompanyConfig getWechatCompanyConfig(CompanyAccountId accountId);

	/**
	 * 保存企业微信号配置信息
	 * 
	 * @param config
	 *            需要保存的config信息
	 * 
	 */
	void setWechatCompanyConfig(WechatCompanyConfig config);
}
