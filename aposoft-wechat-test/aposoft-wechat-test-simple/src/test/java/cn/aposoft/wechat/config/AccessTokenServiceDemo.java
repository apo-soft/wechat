package cn.aposoft.wechat.config;
/**
 *   Copyright  :  www.aposoft.cn
 */

import java.io.IOException;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenClient;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.BasicAccessTokenService;
import cn.aposoft.wechat.access.DefaultAccessTokenClient;
import cn.aposoft.wechat.access.DemoAccountConfigFactory;

/**
 * Access_Token Client 测试用例
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class AccessTokenServiceDemo {

	/**
	 * AccessTokenServiceDemo 测试
	 * 
	 * @param args
	 * @throws AccessTokenException
	 * @throws IOException
	 */
	public static void main(String[] args) throws AccessTokenException, IOException {
		AccessTokenClient client = new DefaultAccessTokenClient();

		try (AccessTokenService accessTokenService = new BasicAccessTokenService(client,
				DemoAccountConfigFactory.factory().getAccountConfig(), RefreshConfigFactory.getRefreshConfig());) {
			for (int i = 0; i < 200; i++) {
				AccessToken accessToken = accessTokenService.getAccessToken();
				System.out.println(JSON.toJSONString(accessToken));
			}
		}
	}
}
