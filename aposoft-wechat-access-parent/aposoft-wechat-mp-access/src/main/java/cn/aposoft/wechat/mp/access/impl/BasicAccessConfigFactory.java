/**
 * 
 */
package cn.aposoft.wechat.mp.access.impl;

import cn.aposoft.wechat.mp.access.AccessConfig;
import cn.aposoft.wechat.mp.access.AccessConfigFactory;
import cn.aposoft.wechat.mp.access.AccessTokenConfig;
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
		factory.config = new AccessConfig() {
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
		};
		return factory;
	}

	private volatile AccessConfig config;

	/**
	 * 读取AccessTokenConfig
	 */
	@Override
	public AccessTokenConfig getAccessTokenConfig() {
		return config;
	}

	@Override
	public AccessConfig getAccessConfig() {
		return config;
	}

}
