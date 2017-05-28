/**
 * 
 */
package cn.aposoft.wechat.company.common;

import cn.aposoft.wechat.mp.access.AccessConfig;

/**
 * @author Jann Liu
 *
 */
public class WechatCompanyAccessConfig extends WechatCompanyConfig implements AccessConfig {

	private int expiredThreshold = 500;

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

}
