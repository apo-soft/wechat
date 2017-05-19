/**
 * 
 */
package org.aposoft.wechat.message.remote;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.message.remote.IndustryConfigClient;

/**
 * @author LiuJian
 *
 */
public class AposoftIndustryConfigClientTest {
	static IndustryConfigClient client;
	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		client = new IndustryConfigClient();
		accessTokenClient = new AccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient);
		accessToken = accessTokenService.getAccessToken();
		System.out.println(JSON.toJSONString(accessToken));
	}

	@AfterClass
	public static void dispose() {
		client.close();
		accessTokenClient.close();

	}

	@Test
	public void testSetIndustry() throws RemoteException {
		client.setIndustryConfig(accessToken.getAccess_token(), "8", "2");
	}

	@Test
	public void testgetIndustry() throws RemoteException {
		System.out.println(client.getIndustry(accessToken.getAccess_token()));
	}

}
