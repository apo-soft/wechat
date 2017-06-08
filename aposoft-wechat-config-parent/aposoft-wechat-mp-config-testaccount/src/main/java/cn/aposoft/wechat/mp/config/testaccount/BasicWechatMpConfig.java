package cn.aposoft.wechat.mp.config.testaccount;

import cn.aposoft.wechat.access.AccessTokenConfig;
import cn.aposoft.wechat.access.AccountConfig;
import cn.aposoft.wechat.access.AccountType;
import cn.aposoft.wechat.access.RefreshConfig;
import cn.aposoft.wechat.mp.config.WechatMpConfig;
import cn.aposoft.wechat.signature.SignatureConfig;

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
	 * 过期刷新阈值,表示距离过期剩余秒数
	 * <p>
	 * Token 超时时间，500秒
	 */
	private int expiredThreshold = 500;
	/**
	 * AES加密KEY
	 */
	private String encodingAESKey = "rqWzZv5rjyBwIRmociz7978G2O1D8sjxlsypVIU4SmY";
	/**
	 * 当距离过期时间只剩10秒时,请求accessToken将Holdon
	 */
	private int holdonThreshold = 10;

	/**
	 * 
	 * @return {@code AccountType#MP}
	 */
	public AccountType getAccountType() {
		return accountType;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public String getAppId() {
		return appId;
	}

	@Override
	public String getAppSecret() {
		return appSecret;
	}

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public int getExpiredThreshold() {
		// Token 超时时间，500秒
		return expiredThreshold;
	}

	// not used for test account
	@Override
	public String getEncodingAESKey() {
		return encodingAESKey;
	}

	@Override
	public int getHoldonThreshold() {
		return holdonThreshold;
	}

	@Override
	public AccountConfig toAccountConfig() {
		return new AccountConfig() {
			private static final long serialVersionUID = 1152935627588703972L;

			@Override
			public AccountType getAccountType() {
				return AccountType.MP;
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
			public int getExpiredThreshold() {
				return BasicWechatMpConfig.this.getExpiredThreshold();
			}

			@Override
			public int getHoldonThreshold() {
				return BasicWechatMpConfig.this.getHoldonThreshold();
			}

		};
	}

	@Override
	public SignatureConfig toSignatureConfig() {
		return new SignatureConfig() {
			@Override
			public String getAppId() {
				return BasicWechatMpConfig.this.getAppId();
			}

			@Override
			public String getToken() {
				return BasicWechatMpConfig.this.getToken();
			}

			@Override
			public String getEncodingAESKey() {
				return BasicWechatMpConfig.this.getEncodingAESKey();
			}

		};
	}

	@Override
	public AccessTokenConfig toAccessTokenConfig() {
		return toAccountConfig();
	}

	@Override
	public RefreshConfig toRefreshConfig() {
		return toAccountConfig();
	}

}
