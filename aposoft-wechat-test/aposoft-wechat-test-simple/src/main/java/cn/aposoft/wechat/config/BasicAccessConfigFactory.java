/**
 * 
 */
package cn.aposoft.wechat.config;

import cn.aposoft.wechat.AccountType;
import cn.aposoft.wechat.access.AccessConfigFactory;
import cn.aposoft.wechat.config.AccountConfig;
import cn.aposoft.wechat.config.WechatMpConfig;

/**
 * AccessTokenConfigFactory 默认实现
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class BasicAccessConfigFactory implements AccessConfigFactory {

	private volatile AccountConfig config;

	public BasicAccessConfigFactory() {
	}

	public static AccessConfigFactory getInstance(final WechatMpConfig config) {
		BasicAccessConfigFactory factory = new BasicAccessConfigFactory();
		factory.config = new AccountConfig() {
			private static final long serialVersionUID = 2455287796630853368L;
			private final String id = config.getId();
			private final String secret = config.getSecret();

			@Override
			public String getId() {
				return id;
			}

			@Override
			public String getSecret() {
				return secret;
			}

			@Override
			public AccountType getAccountType() {
				return AccountType.MP;
			}

		};
		return factory;
	}

	@Override
	public AccountConfig getAccessConfig() {
		return config;
	}

}
