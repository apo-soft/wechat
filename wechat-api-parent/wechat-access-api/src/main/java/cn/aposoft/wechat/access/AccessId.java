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
public interface AccessId extends Serializable {
	public AccountType getAccountType();

	public String getId();
}
