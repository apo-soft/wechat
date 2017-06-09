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
import cn.aposoft.wechat.access.AccessTokenClientFactory;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.access.impl.BasicAccessConfigFactory;
import cn.aposoft.wechat.mp.config.testaccount.WechatAccountConfigFactory;
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
	public static void init() throws IOException, AccessTokenException {
		accessTokenClient = AccessTokenClientFactory.getAccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient,
				BasicAccessConfigFactory.getInstance(WechatAccountConfigFactory.getConfig()).getAccessConfig(),
				WechatAccountConfigFactory.getRefreshConfig());
		System.out.println(JSON.toJSONString(accessTokenService.getAccessToken()));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		client.close();
	}

	@Ignore
	@Test
	public void testGetAutoReply() throws RemoteException, AccessTokenException {
		System.out.println(
				JSON.toJSONString(client.getAutoReplyRule(accessTokenService.getAccessToken().getAccess_token())));
	}
}
