/**
 * 
 */
package cn.aposoft.wechat.config;

import cn.aposoft.wechat.access.RefreshConfig;

/**
 * 刷新Token的默认配置
 * 
 * @author Jann Liu
 *
 */
public class RefreshConfigFactory {
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
