/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.config;

/**
 * @author Jann Liu
 * @date 2016年10月13日
 * @since 1.0
 */
public class WechatMpConfigFactory {
	private static WechatMpConfig config = new BasicWechatMpConfig();

	/**
	 * 微信公众号配置信息
	 * 
	 * @return 微信公众号配置信息
	 */
	public static WechatMpConfig getConfig() {
		return config;
	}

}
