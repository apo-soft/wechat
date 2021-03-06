/**
 * 
 */
package org.aposoft.wechat.company.managemnt.tag;

import java.io.IOException;
import java.util.Arrays;

import org.aposoft.wechat.company.managemnt.tag.impl.BasicTag;
import org.aposoft.wechat.company.managemnt.tag.remote.TagManagementClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.HttpClient;
import cn.aposoft.wechat.WechatResult;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.AccessTokenServiceFactory;

/**
 * @author Jann Liu
 *
 */
public class TagManagementTest {
	static final TagManagementClient service = new TagManagementClient();

	static AccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		HttpClient.setLogEnabled(true);
		accessTokenService = AccessTokenServiceFactory.getCompanyAccessTokenService();
	}

	@AfterClass
	public static void dispose() {
		service.close();
		accessTokenService.close();
	}

	/**
	 * {"errcode":0,"errmsg":"created","tagid":100}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testCreateTag() throws RemoteException, AccessTokenException {
		BasicTag tag = new BasicTag();
		tag.setTagid(100);
		tag.setTagname("simple-test tag");
		TagResp resp = service.create(accessTokenService.getAccessToken().getAccess_token(), tag);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * "报警平台组":{"errcode":0,"errmsg":"created","tagid":1}
	 * 
	 * @throws RemoteException
	 */
	@Ignore
	@Test
	public void testCreateTag1() throws RemoteException, AccessTokenException {
		BasicTag tag = new BasicTag();
		tag.setTagid(1);
		tag.setTagname("报警平台组");
		TagResp resp = service.create(accessTokenService.getAccessToken().getAccess_token(), tag);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 
	 * {"errcode":0,"errmsg":"updated"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testUpdateTag() throws RemoteException, AccessTokenException {
		BasicTag tag = new BasicTag();
		tag.setTagid(100);
		tag.setTagname("美借监控组");
		TagResp resp = service.update(accessTokenService.getAccessToken().getAccess_token(), tag);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 
	 * {"errcode":0,"errmsg":"deleted"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testDeleteTag() throws RemoteException, AccessTokenException {
		WechatResult resp = service.delete(accessTokenService.getAccessToken().getAccess_token(), "100");
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"ok","taglist":[{"tagid":100,"tagname":"simple-test
	 * tag"}]}
	 * <p>
	 * {"errcode":0,"errmsg":"ok","taglist":[{"tagid":100,"tagname":"美借监控组"}]}
	 * <p>
	 * {"errcode":0,"errmsg":"ok","taglist":[{"tagid":1,"tagname":"报警平台组"},{"tagid":100,"tagname":"美借监控组"}]}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testListTags() throws RemoteException, AccessTokenException {
		TagListResp resp = service.list(accessTokenService.getAccessToken().getAccess_token());
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"ok"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testAddTagUser() throws RemoteException, AccessTokenException {
		WechatResult resp = service.addTagUser(accessTokenService.getAccessToken().getAccess_token(), 1,
				Arrays.asList("liujian"), null);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"ok"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testDeleteTagUser() throws RemoteException, AccessTokenException {
		WechatResult resp = service.deleteTagUser(accessTokenService.getAccessToken().getAccess_token(), 1,
				Arrays.asList("liujian"), null);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"ok","partylist":[],"userlist":[]}
	 * <p>
	 * {"errcode":0,"errmsg":"ok","partylist":[],"userlist":[{"department":[],"name":"刘健","userid":"liujian"}]}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testGetTagUser() throws RemoteException, AccessTokenException {
		TagUserResp resp = service.getTagUser(accessTokenService.getAccessToken().getAccess_token(), "1");
		System.out.println(JSON.toJSONString(resp));
	}
}
