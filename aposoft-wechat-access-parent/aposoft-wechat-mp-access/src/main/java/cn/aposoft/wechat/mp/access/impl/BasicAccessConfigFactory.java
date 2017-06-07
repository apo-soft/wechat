/**
 * 
 */
package cn.aposoft.wechat.mp.access.impl;

import cn.aposoft.wechat.access.AccessConfigFactory;
import cn.aposoft.wechat.access.AccessTokenConfig;
import cn.aposoft.wechat.access.AccountConfig;
import cn.aposoft.wechat.access.AccountType;
import cn.aposoft.wechat.mp.config.WechatMpConfig;

/**
 * AccessTokenConfigFactory 默认实现
 * 
 * @author Jann Liu
 *
 */
public class BasicAccessConfigFactory implements AccessConfigFactory {

	public BasicAccessConfigFactory() {
	}

	public static AccessConfigFactory getInstance(final WechatMpConfig config) {
		BasicAccessConfigFactory factory = new BasicAccessConfigFactory();
		factory.config = new AccountConfig() {
			private static final long serialVersionUID = 2455287796630853368L;
			private final String id = config.getAppId();
			private final String secret = config.getAppSecret();
			private final int expire = config.getExpiredThreshold();

			@Override
			public String getId() {
				return id;
			}

			@Override
			public String getSecret() {
				return secret;
			}

			@Override
			public int getExpiredThreshold() {
				return expire;
			}

			@Override
			public AccountType getAccountType() {
				return AccountType.MP;
			}

			@Override
			public int getHoldonThreshold() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		return factory;
	}

	private volatile AccountConfig config;

	/**
	 * 读取AccessTokenConfig
	 */
	@Override
	public AccessTokenConfig getAccessTokenConfig() {
		return config;
	}

	@Override
	public AccountConfig getAccessConfig() {
		return config;
	}

}
