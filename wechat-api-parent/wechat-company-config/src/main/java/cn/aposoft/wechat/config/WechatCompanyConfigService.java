/**
 * 
 */
package cn.aposoft.wechat.config;

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
	WechatCompanyConfig getWechatMpConfig(String id, Integer agentId);

	/**
	 * 保存企业微信号配置信息
	 * 
	 * @param config
	 *            需要保存的config信息
	 * 
	 */
	void setWechatMpConfig(WechatCompanyConfig config);
}
