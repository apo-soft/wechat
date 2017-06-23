/**
 * 
 */
package cn.aposoft.wechat.config;

import cn.aposoft.wechat.AccountType;

/**
 * Db形式的Config存储
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class AposoftWechatDbConfig implements WechatRepoConfig {
	private static final long serialVersionUID = -2035651445386663585L;

	private String userId;
	private AccountType accountType;
	private String id;
	private String token;
	private String encodingAESKey;
	private String secret;
	private Integer agentId;

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
