/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.access.impl;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.impl.BasicAccessTokenService;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.access.remote.DefaultAccessTokenClient;
import cn.aposoft.wechat.mp.config.testaccount.WechatAccountConfigFactory;

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
	 */
	public static void main(String[] args) throws AccessTokenException {
		AccessTokenClient client = new DefaultAccessTokenClient();
		
		try (AccessTokenService accessTokenService = new BasicAccessTokenService(client,
				BasicAccessConfigFactory.getInstance(WechatAccountConfigFactory.getConfig()).getAccessConfig());) {
			for (int i = 0; i < 200; i++) {
				AccessToken accessToken = accessTokenService.getAccessToken();
				System.out.println(JSON.toJSONString(accessToken));
			}
		}
	}
}
