/**
 * 
 */
package cn.aposoft.wechat.access.address;

import cn.aposoft.wechat.AccountType;

/**
 * 访问Url配置项
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface UrlConfig {
	/**
	 * 请求方式定义
	 * 
	 * @author Jann Liu
	 * @since 1.0
	 */
	public static enum Method {
		GET, POST
	}

	/**
	 * 
	 * @return 账户类型 {@link AccountType}
	 */
	AccountType getAccountType();

	/**
	 * OPTIONAL
	 * 
	 * @return 业务编码
	 */
	String getBusiness();

	/**
	 * @return {@code GET} or {@code POST}
	 */
	Method getMethod();

	/**
	 * 
	 * @return Url地址
	 */
	String getUrl();
}
