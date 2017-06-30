/**
 * 
 */
package cn.aposoft.wechat.access;

import java.util.ArrayList;
import java.util.List;

import cn.aposoft.wechat.access.address.AddressConfig;
import cn.aposoft.wechat.access.address.ParamConfig;
import cn.aposoft.wechat.access.address.UrlConfig;
import cn.aposoft.wechat.account.AccountType;

/**
 * 地址配置工厂
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class AddressConfigFactory {
	/**
	 * @return 测试公众号配置
	 */
	public static final AddressConfig getMpAddressConfig() {
		return new AddressConfig() {

			@Override
			public UrlConfig getUrlConfig(AccountType accountType) {
				return new UrlConfig() {
					@Override
					public AccountType getAccountType() {
						return AccountType.MP;
					}

					@Override
					public String getBusiness() {
						return "ACCESS_TOKEN";
					}

					@Override
					public Method getMethod() {
						return Method.GET;
					}

					@Override
					public String getUrl() {
						return "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&";
					}
				};
			}

			@Override
			public List<ParamConfig> getParamConfig(AccountType accountType) {
				List<ParamConfig> paramConfig = new ArrayList<>();
				paramConfig.add(new ParamConfig() {

					@Override
					public String getCode() {
						return "access_token_access_id";
					}

					@Override
					public String getName() {
						return "appid";
					}

				});
				paramConfig.add(new ParamConfig() {
					@Override
					public String getCode() {
						return "access_token_access_secret";
					}

					@Override
					public String getName() {
						return "secret";
					}
				});
				return paramConfig;
			}

		};
	}

	/**
	 * @return 测试公众号配置
	 */
	public static final AddressConfig getCompanyAddressConfig() {
		return new AddressConfig() {

			@Override
			public UrlConfig getUrlConfig(AccountType accountType) {
				return new UrlConfig() {
					@Override
					public AccountType getAccountType() {
						return AccountType.CORP;
					}

					@Override
					public String getBusiness() {
						return "ACCESS_TOKEN";
					}

					@Override
					public Method getMethod() {
						return Method.GET;
					}

					@Override
					public String getUrl() {
						return "https://qyapi.weixin.qq.com/cgi-bin/gettoken?";
					}
				};
			}

			@Override
			public List<ParamConfig> getParamConfig(AccountType accountType) {
				List<ParamConfig> paramConfig = new ArrayList<>();
				paramConfig.add(new ParamConfig() {

					@Override
					public String getCode() {
						return "access_token_access_id";
					}

					@Override
					public String getName() {
						return "corpid";
					}

				});
				paramConfig.add(new ParamConfig() {
					@Override
					public String getCode() {
						return "access_token_access_secret";
					}

					@Override
					public String getName() {
						return "corpsecret";
					}
				});
				return paramConfig;
			}

		};

	}
}
