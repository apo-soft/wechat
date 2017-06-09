/**
 * 
 */
package cn.aposoft.wechat.mp.user.remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenClientFactory;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.mp.access.impl.BasicAccessConfigFactory;
import cn.aposoft.wechat.mp.config.testaccount.WechatAccountConfigFactory;
import cn.aposoft.wechat.mp.user.tag.UserTag;
import cn.aposoft.wechat.mp.user.tag.remote.BatchTaggingReq;
import cn.aposoft.wechat.mp.user.tag.remote.UserTagClient;
import cn.aposoft.wechat.mp.user.tag.remote.UserTagsIdListResp;

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
	public static void init() throws IOException, AccessTokenException {
		userTagClient = new UserTagClient();
		accessTokenClient = AccessTokenClientFactory.getAccessTokenClient();
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient,
				BasicAccessConfigFactory.getInstance(WechatAccountConfigFactory.getConfig()).getAccessConfig(),
				WechatAccountConfigFactory.getRefreshConfig());
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
	public void testAddTag() throws RemoteException, AccessTokenException {
		WechatResp resp = userTagClient.create(//
				accessTokenService.getAccessToken().getAccess_token(), //
				"老婆");
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testListTags() throws RemoteException, AccessTokenException {
		WechatResp resp = userTagClient.list(//
				accessTokenService.getAccessToken().getAccess_token());
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testDeleteSysTag() throws RemoteException, AccessTokenException {
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
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testDeleteTag() throws RemoteException, AccessTokenException {
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
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testUpdateTag() throws RemoteException, AccessTokenException {
		UserTag tag = new UserTag();
		tag.setId(101);
		tag.setName("老师");
		WechatResp resp = userTagClient.update(//
				accessTokenService.getAccessToken().getAccess_token(), tag);
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testBatchTagging() throws RemoteException, AccessTokenException {
		List<String> userInfoList = new ArrayList<>();
		userInfoList.add(new String("ojqOLxEdSITLJbC1kdDbVpKj5UEw"));
		userInfoList.add(new String("ojqOLxHt-0dhb5oAOLMK-zhY9uwQ"));
		userInfoList.add(new String("ojqOLxLh0480oz5gqHqLgzRgCLHM"));
		BatchTaggingReq req = new BatchTaggingReq();
		req.setOpenid_list(userInfoList);
		req.setTagid(100);
		WechatResp resp = userTagClient.batchTagging(accessTokenService.getAccessToken().getAccess_token(), req);
		System.out.println(JSON.toJSONString(resp));
	}

	@Ignore
	@Test
	public void testBatchTaggingSelf() throws RemoteException, AccessTokenException {
		List<String> userInfoList = new ArrayList<>();

		userInfoList.add(new String("ojqOLxLh0480oz5gqHqLgzRgCLHM"));
		BatchTaggingReq req = new BatchTaggingReq();
		req.setOpenid_list(userInfoList);
		req.setTagid(2);
		WechatResp resp = userTagClient.batchTagging(accessTokenService.getAccessToken().getAccess_token(), req);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testBatchRemoveTags() throws RemoteException, AccessTokenException {
		List<String> userInfoList = new ArrayList<>();
		userInfoList.add(new String("ojqOLxEdSITLJbC1kdDbVpKj5UEw"));
		userInfoList.add(new String("ojqOLxHt-0dhb5oAOLMK-zhY9uwQ"));
		userInfoList.add(new String("ojqOLxLh0480oz5gqHqLgzRgCLHM"));
		BatchTaggingReq req = new BatchTaggingReq();
		req.setOpenid_list(userInfoList);
		req.setTagid(100);
		WechatResp resp = userTagClient.batchRemoveTags(accessTokenService.getAccessToken().getAccess_token(), req);
		System.out.println(JSON.toJSONString(resp));
	}
	// listUserTags

	/**
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testListUserTags() throws RemoteException, AccessTokenException {
		UserTagsIdListResp resp = userTagClient.listUserTags(accessTokenService.getAccessToken().getAccess_token(),
				"ojqOLxLh0480oz5gqHqLgzRgCLHM");
		System.out.println(JSON.toJSONString(resp));
	}
}
