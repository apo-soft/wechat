/**
 * 
 */
package cn.aposoft.wechat.config;

import cn.aposoft.wechat.account.AccountType;

/**
 * Db形式的Config存储
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class AposoftWechatDbConfig implements WechatConfig {
	private static final long serialVersionUID = -2035651445386663585L;

	private String id;
	private AccountType accountType;
	private Integer agentId;
	private String secret;
	private String encodingAESKey;
	private String userId;
	private String token;

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

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
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @param encodingAESKey
	 *            the encodingAESKey to set
	 */
	public void setEncodingAESKey(String encodingAESKey) {
		this.encodingAESKey = encodingAESKey;
	}

	/**
	 * @param secret
	 *            the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @param agentId
	 *            the agentId to set
	 */
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.config.WechatMpConfig#getUserId()
	 */
	@Override
	public String getUserId() {
		return userId;
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
	 * @see cn.aposoft.wechat.signature.SignatureConfig#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.signature.SignatureConfig#getToken()
	 */
	@Override
	public String getToken() {
		return token;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.signature.SignatureConfig#getEncodingAESKey()
	 */
	@Override
	public String getEncodingAESKey() {
		return encodingAESKey;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.CompanyAccountId#getAgentId()
	 */
	@Override
	public Integer getAgentId() {
		return agentId;
	}

}
