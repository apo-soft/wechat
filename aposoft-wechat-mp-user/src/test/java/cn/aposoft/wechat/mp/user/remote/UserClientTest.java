/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.access.remote.AposoftMpAccessTokenClient;
import cn.aposoft.wechat.mp.config.testaccount.WechatMpConfigFactory;
import cn.aposoft.wechat.mp.remote.WechatResp;

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
		accessTokenClient = new AposoftMpAccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient, WechatMpConfigFactory.getConfig());
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

	@Ignore
	@Test
	public void testSetUserRemark() throws RemoteException {

		UserInfoListResp resp = userClient.setUserRemark(accessTokenService.getAccessToken().getAccess_token(),
				new UserRemarkReq("ojqOLxHt-0dhb5oAOLMK-zhY9uwQ", "pangzi"));
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testGetUserInfoForRemark() throws RemoteException {
		UserInfoResp resp = userClient.getUserInfo(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testGetUserBlackList() throws RemoteException {
		BlackListResp resp = userClient.getUserBlackList(accessTokenService.getAccessToken().getAccess_token(), "");
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testGetUserBlackListSeq() throws RemoteException {
		BlackListResp resp = userClient.getUserBlackList(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testSetUserBlackList() throws RemoteException {
		BatchBlackReq blackReq = new BatchBlackReq();
		List<String> openid_list = Arrays.asList("ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		blackReq.setOpenid_list(openid_list);

		WechatResp resp = userClient.setUserBlack(accessTokenService.getAccessToken().getAccess_token(), blackReq);
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testRemoveUserBlackList() throws RemoteException {
		BatchBlackReq blackReq = new BatchBlackReq();
		List<String> openid_list = Arrays.asList("ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		blackReq.setOpenid_list(openid_list);

		WechatResp resp = userClient.removeUserFromBlacklist(accessTokenService.getAccessToken().getAccess_token(),
				blackReq);
		System.out.println(JSON.toJSONString(resp));
	}
}
