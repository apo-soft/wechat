/**
 * 
 */
package cn.aposoft.wechat.company.common;

import java.io.Serializable;

import cn.aposoft.wechat.mp.access.AccessTokenConfig;
import cn.aposoft.wechat.mp.access.AccountType;

/**
 * 企业号配置信息
 * 
 * @author Jann Liu
 * @version 1.0
 */
public class WechatCompanyConfig implements Serializable {
	private static final long serialVersionUID = 6960974749855213481L;
	private String corpId;
	private String corpSecret;
	private Integer agentId;

	/**
	 * @return the corpId
	 */
	public String getCorpId() {
		return corpId;
	}

	/**
	 * @param corpId
	 *            the corpId to set
	 */
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	/**
	 * @return the corpSecret
	 */
	public String getCorpSecret() {
		return corpSecret;
	}

	/**
	 * @param corpSecret
	 *            the corpSecret to set
	 */
	public void setCorpSecret(String corpSecret) {
		this.corpSecret = corpSecret;
	}

	public AccessTokenConfig toAccessTokenConfig() {
		return new AccessTokenConfig() {

			@Override
			public String getId() {
				return corpId;
			}

			@Override
			public String getSecret() {
				return corpSecret;
			}

			@Override
			public AccountType getAccountType() {
				return AccountType.CORP;
			}

		};
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
