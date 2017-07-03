/**
 * 
 */
package cn.aposoft.wechat.access.address;

import java.util.ArrayList;
import java.util.List;

import cn.aposoft.wechat.account.AccountType;

/**
 * 简单的访问授权码配置信息
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class SimpleAccessTokenAddressConfig implements AddressConfig {

	@Override
	public UrlConfig getUrlConfig(AccountType accountType) {
		if (AccountType.CORP.equals(accountType)) {
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
		} else {
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
	}

	@Override
	public List<ParamConfig> getParamConfig(AccountType accountType) {
		List<ParamConfig> paramConfig = new ArrayList<>();
		// 公众号
		if (AccountType.MP.equals(accountType)) {

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
		} else {// 企业号
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
		}

		return paramConfig;
	}

}
