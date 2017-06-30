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

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;

/**
 * @author Jann Liu
 *
 */
public class UserClientTest {
	static UserClient userClient;
	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException, AccessTokenException {
		userClient = new UserClient();
		accessTokenService = AccessTokenServiceFactory.getAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		accessTokenService.close();
		userClient.close();
	}

	@Ignore
	@Test
	public void testListUser() throws RemoteException, AccessTokenException {
		UserResp resp = userClient.getUser(accessTokenService.getAccessToken().getAccess_token());
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testListUserFromNextOpenId() throws RemoteException, AccessTokenException {
		UserResp resp = userClient.getUser(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxEdSITLJbC1kdDbVpKj5UEw");
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testListUserFromLastNextOpenId() throws RemoteException, AccessTokenException {
		UserResp resp = userClient.getUser(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testGetUserInfo() throws RemoteException, AccessTokenException {
		UserInfoResp resp = userClient.getUserInfo(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM");
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testGetUserInfoList() throws RemoteException, AccessTokenException {
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
	public void testSetUserRemark() throws RemoteException, AccessTokenException {

		UserInfoListResp resp = userClient.setUserRemark(accessTokenService.getAccessToken().getAccess_token(),
				new UserRemarkReq("ojqOLxHt-0dhb5oAOLMK-zhY9uwQ", "pangzi"));
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testGetUserInfoForRemark() throws RemoteException, AccessTokenException {
		UserInfoResp resp = userClient.getUserInfo(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testGetUserBlackList() throws RemoteException, AccessTokenException {
		BlackListResp resp = userClient.getUserBlackList(accessTokenService.getAccessToken().getAccess_token(), "");
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testGetUserBlackListSeq() throws RemoteException, AccessTokenException {
		BlackListResp resp = userClient.getUserBlackList(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testSetUserBlackList() throws RemoteException, AccessTokenException {
		BatchBlackReq blackReq = new BatchBlackReq();
		List<String> openid_list = Arrays.asList("ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		blackReq.setOpenid_list(openid_list);

		WechatResp resp = userClient.setUserBlack(accessTokenService.getAccessToken().getAccess_token(), blackReq);
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testRemoveUserBlackList() throws RemoteException, AccessTokenException {
		BatchBlackReq blackReq = new BatchBlackReq();
		List<String> openid_list = Arrays.asList("ojqOLxHt-0dhb5oAOLMK-zhY9uwQ");
		blackReq.setOpenid_list(openid_list);

		WechatResp resp = userClient.removeUserFromBlacklist(accessTokenService.getAccessToken().getAccess_token(),
				blackReq);
		System.out.println(JSON.toJSONString(resp));
	}
}
