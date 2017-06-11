package cn.aposoft.wechat.config;

import cn.aposoft.wechat.AccountType;
import cn.aposoft.wechat.config.WechatMpConfig;

/**
 * 简单的Wechat 配置项管理结构
 * 
 * @see WechatMpConfig
 * @author Jann Liu
 * @since 1.0
 */
public class BasicWechatMpConfig implements WechatMpConfig {
	private static final long serialVersionUID = 1L;
	/**
	 * 账户类型
	 */
	private AccountType accountType = AccountType.MP;
	/**
	 * 用户ID,一般不需要使用,可空,企业号无此项
	 */
	private String userId = "gh_0f504b63df22";
	/**
	 * 公众号
	 */
	private String appId = "wx31659662068251dc";
	private String appSecret = "9cf9858af4718fde40d67968b5de3967";
	private String token = "AposoftBugs";

	/**
	 * AES加密KEY
	 */
	private String encodingAESKey = "rqWzZv5rjyBwIRmociz7978G2O1D8sjxlsypVIU4SmY";

	/**
	 * 读取用户ID
	 */
	@Override
	public String getUserId() {
		return userId;
	}

	/**
	 * 当距离过期时间只剩10秒时,请求accessToken将Holdon
	 */

	/**
	 * 
	 * @return {@code AccountType#MP}
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	@Override
	public String getId() {
		return appId;
	}

	@Override
	public String getSecret() {
		return appSecret;
	}

	@Override
	public String getToken() {
		return token;
	}

	// not used for test account
	@Override
	public String getEncodingAESKey() {
		return encodingAESKey;
	}

}
