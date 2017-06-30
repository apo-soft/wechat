/**
 * 
 */
package cn.aposoft.framework.concurrent;

/**
 * 刷新作业实例
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface RefreshWorker {

	/**
	 * 根据上下文定制刷新服务
	 * 
	 * @param context
	 *            刷新内容上下文
	 */
	void refresh(Object context);
}
