/**
 * 
 */
package cn.aposoft.wechat.access;

/**
 * Token刷新控制配置
 * 
 * @author Jann Liu
 *
 */
public interface RefreshConfig {
	/**
	 * 
	 * @return 会话过期时间保护,可以使用异步进行Token刷新 (s)
	 */
	int getExpiredThreshold();

	/**
	 * @return 距离服务端返回的时间,绝对锁定等待远程token刷新时间间隔 (s)
	 */
	int getHoldonThreshold();

}
