/**
 * 
 */
package cn.aposoft.wechat.message.impl;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;
import cn.aposoft.wechat.mp.message.impl.AposoftCsaMessageService;

/**
 * 
 * @author Jann Liu
 *
 */
public class AposoftCsaMessageServiceTest {
	static AposoftCsaMessageService messageService;
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException, AccessTokenException {
		messageService = new AposoftCsaMessageService();
		accessTokenService = AccessTokenServiceFactory.getAccessTokenService();

	}

	@AfterClass
	public static void dispose() {
		accessTokenService.close();
		messageService.close();
	}

	@Test
	public void sendTextMessage() throws RemoteException, AccessTokenException {
		WechatResp resp = messageService.sendText(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM", "测试客服消息.");
		System.out.println(JSON.toJSONString(resp));

	}

}
