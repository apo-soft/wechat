/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.config.testaccount;

import cn.aposoft.wechat.config.WechatAccountConfig;

/**
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class WechatAccountConfigFactory {
	private static WechatAccountConfig config = new BasicWechatMpConfig();

	/**
	 * 微信公众号配置信息
	 * 
	 * @return 微信公众号配置信息
	 */
	public static WechatAccountConfig getConfig() {
		return config;
	}
}
