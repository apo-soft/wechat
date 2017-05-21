/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;

/**
 * @author Jann Liu
 *
 */
public class UserClientTest {
	static UserClient userClient;
	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		userClient = new UserClient();
		accessTokenClient = new AccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient);
		accessToken = accessTokenService.getAccessToken();
		System.out.println(JSON.toJSONString(accessToken));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		userClient.close();
	}

	@Test
	public void testListUser() throws RemoteException {
		UserResp resp = userClient.getUser(accessTokenService.getAccessToken().getAccess_token());
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testListUserFromNextOpenId() throws RemoteException {
		UserResp resp = userClient.getUser(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxEdSITLJbC1kdDbVpKj5UEw");
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testListUserFromLastNextOpenId() throws RemoteException {
		UserResp resp = userClient.getUser(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testGetUserInfo() throws RemoteException {
		UserInfoResp resp = userClient.getUserInfo(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM");
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testGetUserInfoList() throws RemoteException {
		List<UserInfoReq> userInfoList = new ArrayList<>();
		userInfoList.add(new UserInfoReq("ojqOLxEdSITLJbC1kdDbVpKj5UEw"));
		userInfoList.add(new UserInfoReq("ojqOLxHt-0dhb5oAOLMK-zhY9uwQ"));
		userInfoList.add(new UserInfoReq("ojqOLxLh0480oz5gqHqLgzRgCLHM"));
		UserInfoListResp resp = userClient.getUserInfoList(accessTokenService.getAccessToken().getAccess_token(),
				userInfoList);
		System.out.println(JSON.toJSONString(resp));
	}

}
