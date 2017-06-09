/**
 * 
 */
package cn.aposoft.wechat.access.address;

import java.util.List;

import cn.aposoft.wechat.AccountType;

/**
 * 地址配置信息
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface AddressConfig {

	/**
	 * 
	 * @return Url地址配置
	 */
	UrlConfig getUrlConfig(AccountType accountType);

	/**
	 * 
	 * @return Url地址对应参数配置(仅限于对于不同类型的地址,参数不同的情况)
	 */
	List<ParamConfig> getParamConfig(AccountType accountType);

}
