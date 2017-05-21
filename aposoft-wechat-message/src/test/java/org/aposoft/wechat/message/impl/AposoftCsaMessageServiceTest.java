/**
 * 
 */
package org.aposoft.wechat.message.impl;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.message.impl.AposoftCsaMessageService;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 
 * @author Jann Liu
 *
 */
public class AposoftCsaMessageServiceTest {
	static AposoftCsaMessageService messageService;
	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		messageService = new AposoftCsaMessageService();
		accessTokenClient = new AccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient);
		accessToken = accessTokenService.getAccessToken();
		System.out.println(JSON.toJSONString(accessToken));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		messageService.close();
	}

	@Test
	public void sendTextMessage() throws RemoteException {
		WechatResp resp = messageService.sendText(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM", "测试客服消息.");
		System.out.println(JSON.toJSONString(resp));

	}

}
