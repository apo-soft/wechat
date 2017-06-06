package cn.aposoft.wechat.mp.config.testaccount;

import cn.aposoft.wechat.mp.access.AccountType;
import cn.aposoft.wechat.mp.config.WechatMpConfig;

public class BasicWechatMpConfig implements WechatMpConfig {

	@Override
	public String getUserId() {
		return "gh_0f504b63df22";
	}

	@Override
	public String getAppId() {
		return "wx31659662068251dc";
	}

	@Override
	public String getAppSecret() {
		return "9cf9858af4718fde40d67968b5de3967";
	}

	@Override
	public String getToken() {
		return "AposoftBugs";
	}

	@Override
	public int getExpiredThreshold() {
		// Token 超时时间，5分钟
		return 500;
	}

	// not used for test account
	@Override
	public String getEncodingAESKey() {
		return "rqWzZv5rjyBwIRmociz7978G2O1D8sjxlsypVIU4SmY";
	}

	@Override
	public String getId() {
		return getAppId();
	}

	@Override
	public String getSecret() {
		return getAppSecret();
	}

	@Override
	public AccountType getAccountType() {
		return AccountType.MP;
	}

	@Override
	public int getHoldonThreshold() {
		return 10;
	}

}
