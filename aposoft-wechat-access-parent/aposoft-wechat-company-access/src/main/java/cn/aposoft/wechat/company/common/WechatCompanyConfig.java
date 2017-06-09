/**
 * 
 */
package cn.aposoft.wechat.company.common;

import java.io.Serializable;

import cn.aposoft.wechat.AccountType;
import cn.aposoft.wechat.config.CompanyAccountConfig;

/**
 * 企业号配置信息
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class WechatCompanyConfig implements CompanyAccountConfig, Serializable {
	private static final long serialVersionUID = 6960974749855213481L;
	private String id;
	private String secret;
	private Integer agentId;

	@Override
	public AccountType getAccountType() {
		return AccountType.CORP;
	}

	/**
	 * @return the corpId
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param corpId
	 *            the corpId to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the Secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret
	 *            the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @return the agentId
	 */
	public Integer getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId
	 *            the agentId to set
	 */
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

}
