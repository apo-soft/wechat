/**
 * 
 */
package cn.aposoft.wechat.message.remote;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.message.remote.MessageManagementClient;

/**
 * 消息管理客户端
 * 
 * @author Jann Liu
 *
 */
public class MessageManagementClientTest {
	static MessageManagementClient client = new MessageManagementClient();
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		accessTokenClient = new AccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient);
		System.out.println(JSON.toJSONString(accessTokenService.getAccessToken()));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		client.close();
	}

	@Test
	public void testGetAutoReply() throws RemoteException {
		System.out.println(
				JSON.toJSONString(client.getAutoReplyRule(accessTokenService.getAccessToken().getAccess_token())));
	}
}
