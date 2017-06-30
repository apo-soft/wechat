/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user;

import java.io.IOException;
import java.util.Arrays;

import org.aposoft.wechat.company.managemnt.user.impl.AposoftUserManagementService;
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
 * 用户管理功能测试
 * 
 * @author Jann Liu
 *
 */
public class UserManagementTest {
	static final UserManagementService service = new AposoftUserManagementService();
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
	 * {"errcode":0,"errmsg":"created"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testCreateUser() throws RemoteException, AccessTokenException {
		User user = new User();
		user.setUserid("liujian_test_2");
		user.setName("刘健-测试");
		user.setDepartment(new int[] { 2 });
		user.setGender("1");
		user.setEmail("pleasantboy@163.com");
		WechatResult resp = service.create(accessTokenService.getAccessToken().getAccess_token(), user);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"updated"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testUpdateUser() throws RemoteException, AccessTokenException {
		User user = new User();
		user.setUserid("liujian_test");
		user.setName("刘健-测试");
		user.setDepartment(new int[] { 2 });
		user.setGender("1");
		user.setEmail("pleasantboy@qq.com");
		user.setPosition("开发工程师");
		WechatResult resp = service.update(accessTokenService.getAccessToken().getAccess_token(), user);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * <pre>
	 {"department":[2],"email":"pleasantboy@163.com","errcode":0,"errmsg":"ok","extattr":{"attrs":[]},"gender":"1","name":"刘健-测试","userid":"liujian_test_2"}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testGetUserLiuJianTest2() throws RemoteException, AccessTokenException {

		UserResp resp = service.get(accessTokenService.getAccessToken().getAccess_token(), "liujian_test_2");
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * <pre>
	 * {
			"department":[
			    2
			],
			"email":"pleasantboy@qq.com",
			"errcode":0,
			"errmsg":"ok",
			"extattr":{
			    "attrs":[
			
			    ]
			},
			"gender":"1",
			"name":"刘健-测试",
			"position":"开发工程师",
			"userid":"liujian_test"
		}
		
		{"errcode":60111,"errmsg":"userid not found"}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testGetUserLiuJianTest() throws RemoteException, AccessTokenException {
		User user = new User();
		user.setUserid("liujian_test");
		user.setName("刘健-测试");
		user.setDepartment(new int[] { 2 });
		user.setGender("1");
		user.setEmail("pleasantboy@qq.com");
		user.setPosition("开发工程师");
		UserResp resp = service.get(accessTokenService.getAccessToken().getAccess_token(), "liujian_test");
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * <pre>
	{"errcode":0,"errmsg":"deleted"}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testDeleteUserLiuJianTest2Batch() throws RemoteException, AccessTokenException {
		WechatResult resp = service.delete(accessTokenService.getAccessToken().getAccess_token(), "liujian_test");
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * <pre>
	{"errcode":0,"errmsg":"deleted"}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testDeleteUserLiuJianTest() throws RemoteException, AccessTokenException {

		WechatResult resp = service.delete(accessTokenService.getAccessToken().getAccess_token(), "liujian_test");
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"deleted"}
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testDeleteUserBatchTest() throws RemoteException, AccessTokenException {

		WechatResult resp = service.delete(accessTokenService.getAccessToken().getAccess_token(),
				Arrays.asList("liujian_test", "liujian_test_2"));
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * <pre>
	 * {
			"errcode":0,
			"errmsg":"ok",
			"userid":"liujian",
			"name":"刘健",
			"department":[2],
			"mobile":"18733549336",
			"gender":"1",
			"weixinid":"pipi668",
			"avatar":"http://shp.qpic.cn/bizmp/CjjInx7gdicXIPl7rhlzF1bRMRv99PkQXMRZEJbhUzlMapHNOskpgQw/",
			"status":1,
			"extattr":{
			    "attrs":[]
			}
		}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testGetUser() throws RemoteException, AccessTokenException {
		UserResp resp = service.get(accessTokenService.getAccessToken().getAccess_token(), "liujian");
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testGetUserInDepartment() throws RemoteException, AccessTokenException {
		UserListResp resp = service.get(accessTokenService.getAccessToken().getAccess_token(), 2, 1, 0);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * 
	 * 
	 * {"errcode":60011,"errmsg":"no privilege to access/modify
	 * contact/party/agent "}
	 * </pre>
	 * 
	 * @throws RemoteException
	 * @throws AccessTokenException
	 */
	@Ignore
	@Test
	public void testGetUserDetailInDepartment() throws RemoteException, AccessTokenException {
		UserListResp resp = service.getDetail(accessTokenService.getAccessToken().getAccess_token(), 2, 1, 0);
		System.out.println(JSON.toJSONString(resp));
	}
}
