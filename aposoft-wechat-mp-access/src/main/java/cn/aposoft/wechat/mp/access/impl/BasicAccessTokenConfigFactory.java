/**
 * 
 */
package cn.aposoft.wechat.mp.access.impl;

import cn.aposoft.wechat.mp.access.AccessTokenConfig;
import cn.aposoft.wechat.mp.access.AccessTokenConfigFactory;
import cn.aposoft.wechat.mp.config.WechatMpConfig;

/**
 * AccessTokenConfigFactory 默认实现
 * 
 * @author Jann Liu
 *
 */
public class BasicAccessTokenConfigFactory implements AccessTokenConfigFactory {

	public BasicAccessTokenConfigFactory() {
	}

	public static AccessTokenConfigFactory getInstance(final WechatMpConfig config) {
		BasicAccessTokenConfigFactory factory = new BasicAccessTokenConfigFactory();
		factory.config = new AccessTokenConfig() {
			private final String id = config.getAppId();
			private final String secret = config.getAppSecret();

			@Override
			public String getId() {
				return id;
			}

			@Override
			public String getSecret() {
				return secret;
			}
		};
		return factory;
	}

	private volatile AccessTokenConfig config;

	/**
	 * 读取AccessTokenConfig
	 */
	@Override
	public AccessTokenConfig getAccessTokenConfig() {
		return config;
	}

}
