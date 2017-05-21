/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.remote.WechatResp;
import cn.aposoft.wechat.mp.user.tag.UserTag;
import cn.aposoft.wechat.mp.user.tag.remote.UserTagClient;

/**
 * @author liuya
 *
 */
public class UserTagClientTest {
	static UserTagClient userTagClient;
	static AccessToken accessToken;
	static AccessTokenClient accessTokenClient;
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		userTagClient = new UserTagClient();
		accessTokenClient = new AccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient);
		accessToken = accessTokenService.getAccessToken();
		System.out.println(JSON.toJSONString(accessToken));
	}

	@AfterClass
	public static void dispose() {
		accessTokenClient.close();
		userTagClient.close();
	}

	@Ignore
	@Test
	public void testAddTag() throws RemoteException {
		WechatResp resp = userTagClient.create(//
				accessTokenService.getAccessToken().getAccess_token(), //
				"老婆");
		System.out.println(JSON.toJSONString(resp));
	}

	@Test
	public void testListTags() throws RemoteException {
		WechatResp resp = userTagClient.list(//
				accessTokenService.getAccessToken().getAccess_token());
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testDeleteSysTag() throws RemoteException {
		WechatResp resp = userTagClient.delete(//
				accessTokenService.getAccessToken().getAccess_token(), 2);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * first time: {"errcode":0,"errmsg":"ok"}
	 * <p>
	 * second time: {"errcode":0,"errmsg":"ok"}
	 * 
	 * @throws RemoteException
	 */
	@Ignore
	@Test
	public void testDeleteTag() throws RemoteException {
		WechatResp resp = userTagClient.delete(//
				accessTokenService.getAccessToken().getAccess_token(), 102);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * first time: {"errcode":0,"errmsg":"ok"}
	 * <p>
	 * second time: {"errcode":0,"errmsg":"ok"}
	 * 
	 * @throws RemoteException
	 */
	@Test
	public void testUpdateTag() throws RemoteException {
		UserTag tag = new UserTag();
		tag.setId(101);
		tag.setName("老师");
		WechatResp resp = userTagClient.update(//
				accessTokenService.getAccessToken().getAccess_token(), tag);
		System.out.println(JSON.toJSONString(resp));
	}
}
