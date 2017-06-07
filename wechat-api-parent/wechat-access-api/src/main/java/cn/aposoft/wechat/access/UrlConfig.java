/**
 * 
 */
package cn.aposoft.wechat.access;

/**
 * 访问Url配置项
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface UrlConfig {
	/**
	 * 
	 * @return 账户类型 {@link AccountType}
	 */
	AccountType getAccountType();

	/**
	 * 
	 * @return 业务编码
	 */
	String getBusiness();

	/**
	 * 
	 * @return Url地址
	 */
	String getUrl();
}
