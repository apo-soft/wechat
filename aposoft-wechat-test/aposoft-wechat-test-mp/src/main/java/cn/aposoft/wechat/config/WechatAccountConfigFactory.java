/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.config;

import cn.aposoft.wechat.access.RefreshConfig;
import cn.aposoft.wechat.config.MpAccountConfig;

/**
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class WechatAccountConfigFactory {
	private static MpAccountConfig config = new BasicWechatMpConfig();

	/**
	 * 微信公众号配置信息
	 * 
	 * @return 微信公众号配置信息
	 */
	public static MpAccountConfig getConfig() {
		return config;
	}

	/**
	 * 
	 * @return 刷新Token的配置
	 */
	public static RefreshConfig getRefreshConfig() {
		return new RefreshConfig() {

			@Override
			public int getExpiredThreshold() {
				return 500;
			}

			@Override
			public int getHoldonThreshold() {
				return 10;
			}
		};
	}
}
