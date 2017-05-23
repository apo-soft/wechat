/**
 * 
 */
package cn.aposoft.wechat.message.remote;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.message.remote.MassMessageClient;

/**
 * 批量发送客户端测试
 * 
 * @author Jann Liu
 *
 */
public class MassMessageClientTest {
	static MassMessageClient client = new MassMessageClient();
	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		accessTokenClient = new AccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient);
		accessToken = accessTokenService.getAccessToken();
		System.out.println(JSON.toJSONString(accessToken));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		client.close();
	}
}
