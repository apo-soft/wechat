/**
 * 
 */
package cn.aposoft.wechat.config;

import java.io.Serializable;

/**
 * Token刷新控制配置
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface RefreshConfig extends Serializable {
	/**
	 * 
	 * @return 会话过期时间保护,可以使用异步进行Token刷新 (s)
	 */
	int getAsyncRefreshThreshold();

	/**
	 * @return 距离服务端返回的时间,绝对锁定等待远程token刷新时间间隔 (s)
	 */
	int getHoldonThreshold();

	/**
	 * 
	 * @return 远程访问错误重试次数
	 */
	int getRetryTimes();

}
