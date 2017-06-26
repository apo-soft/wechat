/**
 * 
 */
package cn.aposoft.wechat.config;

/**
 * 微信公众号/服务号配置信息读取服务
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface WechatMpConfigService {

	/**
	 * 
	 * @param id
	 *            mp应用id
	 * 
	 * @return 根据MPid读取MP的配置信息
	 */
	WechatMpConfig getWechatMpConfig(String id);

	/**
	 * 
	 * @param config
	 *            需要保存的config信息
	 * 
	 */
	void setWechatMpConfig(WechatMpConfig config);
}
