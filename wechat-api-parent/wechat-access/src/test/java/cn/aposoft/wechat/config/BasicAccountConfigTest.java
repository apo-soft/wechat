/**
 * 
 */
package cn.aposoft.wechat.config;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.account.AccountType;

/**
 * @author Jann Liu
 * @since 1.0
 */
public class BasicAccountConfigTest {

	public static void main(String[] args) {
		System.out.println(JSON.toJSONString(new BasicAccountConfig() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getId() {
				return "wx31659******";
			}

			@Override
			public AccountType getAccountType() {
				return AccountType.MP;
			}

			@Override
			public String getSecret() {
				return "9cf985&********68b5de3967";
			}
		}));
	}
}
