/**
 * 
 */
package cn.aposoft.wechat.access.address;

/**
 * 访问参数名称配置
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface ParamConfig {
	/**
	 * @return 编程内部占位符
	 */
	String getCode();

	/**
	 * @return 参数名称
	 */
	String getName();
}
