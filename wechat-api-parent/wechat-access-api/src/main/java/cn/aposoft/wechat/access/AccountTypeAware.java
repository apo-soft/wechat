/**
 * 
 */
package cn.aposoft.wechat.access;

/**
 * 账户类型读取接口
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface AccountTypeAware {
	/**
	 * 
	 * @return {@code AccountType}
	 */
	AccountType getAccountType();
}
