/**
 * 
 */
package cn.aposoft.wechat.company.common;

import cn.aposoft.wechat.mp.access.AccessTokenConfig;

/**
 * 企业号配置信息
 * 
 * @author Jann Liu
 * @version 1.0
 */
public class WechatCompanyConfig {
	private String corpId;
	private String corpSecret;

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

		};
	}
}
