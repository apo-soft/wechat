/**
 * 
 */
package cn.aposoft.wechat.access.db;

import cn.aposoft.wechat.AccountType;
import cn.aposoft.wechat.access.impl.BasicAccessToken;
import cn.aposoft.wechat.config.AccountConfig;

/**
 * Db访问的AccessToken对象
 * 
 * @author Jann Liu
 *
 */
public class DbAccessToken extends BasicAccessToken implements AccountConfig {
	private static final long serialVersionUID = 6589711703134602935L;

	private AccountType accountType;
	private String id;
	private String secret;

	/**
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param secret
	 *            the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public AccountType getAccountType() {
		return accountType;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getSecret() {
		return secret;
	}

}
