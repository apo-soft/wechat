/**
 * 
 */
package cn.aposoft.wechat.access.address;

import cn.aposoft.wechat.account.AccountType;

/**
 * 地址工具
 * 
 * @author Jann Liu
 *
 */
public final class AddressUtil {
	private AddressUtil() {
	}

	/**
	 * 参数配置
	 * 
	 * @param code
	 *            编码
	 * @return 参数配置项
	 */
	public static ParamConfig getParamConfig(String code, AccountType accountType, AddressConfig addressConfig) {
		if (addressConfig == null || code == null || accountType == null) {
			return null;
		}
		if (addressConfig.getParamConfig(accountType) == null || addressConfig.getParamConfig(accountType).isEmpty()) {
			return null;
		}
		for (ParamConfig config : addressConfig.getParamConfig(accountType)) {
			if (code.equals(config.getCode())) {
				return config;
			}
		}
		return null;
	}
}
