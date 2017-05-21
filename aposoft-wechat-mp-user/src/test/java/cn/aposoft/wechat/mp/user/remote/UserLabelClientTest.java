/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * @author liuya
 *
 */
public class UserLabelClientTest {
	static UserLabelClient userLabelClient;
	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		userLabelClient = new UserLabelClient();
		accessTokenClient = new AccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient);
		accessToken = accessTokenService.getAccessToken();
		System.out.println(JSON.toJSONString(accessToken));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		userLabelClient.close();
	}

	@Test
	public void testAddLabel() throws RemoteException {
		WechatResp resp = userLabelClient.create(//
				accessTokenService.getAccessToken().getAccess_token(), //
				"亲属");
		System.out.println(JSON.toJSONString(resp));
	}
}
