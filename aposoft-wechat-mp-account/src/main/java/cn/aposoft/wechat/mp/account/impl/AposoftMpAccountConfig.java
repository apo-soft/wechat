/**
 * 
 */
package cn.aposoft.wechat.mp.account.impl;

import cn.aposoft.wechat.mp.account.AccountConfig;

/**
 * 默认的配置实现
 * 
 * @author Jann Liu
 *
 */
public class AposoftMpAccountConfig implements AccountConfig {
	@Override
	public int getDefaultExpireSecounds() {
		return 30;
	}

	@Override
	public int getMaxExpireSecounds() {
		return 2592000;
	}
}
