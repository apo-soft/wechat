/**
 * 
 */
package cn.aposoft.wechat.config;

import cn.aposoft.wechat.AccountType;

/**
 * 简单的AccountConfig实现
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class BasicAccountConfig implements AccountConfig {
	private static final long serialVersionUID = -8192610750114129389L;
	private String id;
	private String secret;
	private AccountType accountType;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.AccountId#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.AccountTypeAware#getAccountType()
	 */
	@Override
	public AccountType getAccountType() {
		return accountType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.access.AccessSecret#getSecret()
	 */
	@Override
	public String getSecret() {
		return secret;
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

	/**
	 * @param accountType
	 *            the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
