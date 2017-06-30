/**
 * 
 */
package cn.aposoft.wechat.account;

import java.io.Serializable;

/**
 * 访问ID
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface AccountId extends AccountTypeAware, Serializable {

	/**
	 * @return appId or corpId (according to accountType)
	 */
	public String getId();
}
