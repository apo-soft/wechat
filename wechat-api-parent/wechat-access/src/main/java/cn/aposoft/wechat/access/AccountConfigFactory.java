/**
 * 
 */
package cn.aposoft.wechat.access;

import cn.aposoft.wechat.config.AccountConfig;

/**
 * 生成AccessTokenConfig的工厂类
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface AccountConfigFactory {

	/**
	 * @return 授权码访问控制配置项
	 */
	AccountConfig getAccountConfig();
}
