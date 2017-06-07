/**
 * 
 */
package cn.aposoft.wechat.mp.access;

import cn.aposoft.wechat.access.AccessTokenConfig;
import cn.aposoft.wechat.access.AccountConfig;

/**
 * 生成AccessTokenConfig的工厂类
 * 
 * @author Jann Liu
 *
 */
public interface AccessConfigFactory {
	/**
	 * 
	 * @return
	 */
	AccessTokenConfig getAccessTokenConfig();

	/**
	 * 
	 * @return
	 */
	AccountConfig getAccessConfig();
}
