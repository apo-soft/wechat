/**
 * 
 */
package cn.aposoft.framework.concurrent;

/**
 * 异步刷新服务实现
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface RefreshAware {
	void setRefreshService(AsyncRefreshService service);
}
