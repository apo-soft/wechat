/**
 * 
 */
package cn.aposoft.wechat.message.remote;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;
import cn.aposoft.wechat.mp.message.remote.MessageManagementClient;

/**
 * 消息管理客户端
 * 
 * @author Jann Liu
 *
 */
public class MessageManagementClientTest {
	static MessageManagementClient client = new MessageManagementClient();
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException, AccessTokenException {
		accessTokenService = AccessTokenServiceFactory.getAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		accessTokenService.close();
		client.close();
	}

	@Ignore
	@Test
	public void testGetAutoReply() throws RemoteException, AccessTokenException {
		System.out.println(
				JSON.toJSONString(client.getAutoReplyRule(accessTokenService.getAccessToken().getAccess_token())));
	}
}
