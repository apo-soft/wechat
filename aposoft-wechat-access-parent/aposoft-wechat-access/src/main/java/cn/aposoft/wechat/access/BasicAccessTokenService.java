/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.aposoft.wechat.config.AccountConfig;
import cn.aposoft.wechat.config.RefreshConfig;

/**
 * AccessToken 默认访问服务
 * 
 * @author Jann Liu
 * @date 2016年10月12日
 */
public class BasicAccessTokenService extends AbstractAccessTokenService implements AccessTokenService {
	static final Logger logger = LoggerFactory.getLogger(BasicAccessTokenService.class);

	/**
	 * WARNING:本用例仅用于测试使用，具体实现需要重构此服务,保证对token访问的原子性和实时性
	 * 
	 * @param client
	 * @param configFactory
	 */
	public BasicAccessTokenService(AccessTokenClient client, AccountConfig accessConfig, RefreshConfig refreshConfig) {
		super(client, accessConfig, refreshConfig);
	}
}
