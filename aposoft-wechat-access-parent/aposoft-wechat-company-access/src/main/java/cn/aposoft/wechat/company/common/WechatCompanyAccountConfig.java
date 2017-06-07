/**
 * 
 */
package cn.aposoft.wechat.company.common;

import cn.aposoft.wechat.access.AccountType;
import cn.aposoft.wechat.access.CompanyAccountConfig;

/**
 * 企业访问控制配置项
 * 
 * @author Jann Liu
 *
 */
public class WechatCompanyAccountConfig extends WechatCompanyConfig implements CompanyAccountConfig {

	private static final long serialVersionUID = -5745480805157943359L;

	private int expiredThreshold = 500;

	private int holdonThreshold = 10;

	public void setExpiredThreshold(Integer expiredThreshold) {
		this.expiredThreshold = expiredThreshold;
	}

	public int getExpiredThreshold() {
		return expiredThreshold;
	}

	@Override
	public String getId() {
		return getCorpId();
	}

	@Override
	public String getSecret() {
		return getCorpSecret();
	}

	@Override
	public AccountType getAccountType() {
		return AccountType.CORP;
	}

	/**
	 * @return holdonThreshold, default to 10 (s)
	 */
	@Override
	public int getHoldonThreshold() {
		return holdonThreshold;
	}

	/**
	 * @param holdonThreshold
	 *            the holdonThreshold to set
	 */
	public void setHoldonThreshold(int holdonThreshold) {
		this.holdonThreshold = holdonThreshold;
	}

}
