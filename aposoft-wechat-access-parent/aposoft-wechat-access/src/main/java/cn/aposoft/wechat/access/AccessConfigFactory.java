/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.access.AccessTokenConfig;
import cn.aposoft.wechat.access.AccountConfig;

/**
 * 生成AccessTokenConfig的工厂类
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface AccessConfigFactory {
	/**
	 * @return AccessToken 读取配置项
	 */
	AccessTokenConfig getAccessTokenConfig();

	/**
	 * @return 授权码访问控制配置项
	 */
	AccountConfig getAccessConfig();
}
