/**
 * 
 */
package cn.aposoft.wechat.access;

import java.io.Serializable;

/**
 * 访问ID
 * 
 * @author Jann Liu
 *
 */
public interface AccountId extends Serializable {
	/**
	 * @return AccountType {@link AccountType}
	 */
	public AccountType getAccountType();

	/**
	 * @return appId or corpId (according to accountType)
	 */
	public String getId();
}
