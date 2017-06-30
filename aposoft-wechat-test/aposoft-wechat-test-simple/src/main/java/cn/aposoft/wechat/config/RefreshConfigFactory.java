/**
 * 
 */
package cn.aposoft.wechat.config;

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
		return new BasicRefreshConfig();
	}
}
