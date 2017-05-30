/**
 * 
 */
package org.aposoft.wechat.company.managemnt.department;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.aposoft.wechat.company.managemnt.department.remote.DepartmentManagementClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.company.common.CompanyAccessTokenClient;
import cn.aposoft.wechat.company.common.WechatCompanyAccessConfig;
import cn.aposoft.wechat.mp.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.mp.remote.WechatResponse;

/**
 * 部门管理客户端测试
 * 
 * @author Jann Liu
 *
 */
public class DepartmentManagementClientTest {
	static final DepartmentManagementClient service = new DepartmentManagementClient();
	static final CompanyAccessTokenClient accessTokenClient = new CompanyAccessTokenClient();
	static FilePathAccessTokenService accessTokenService;

	@BeforeClass
	public static void init() throws IOException {
		HttpClient.setLogEnabled(true);
		WechatCompanyAccessConfig config = JSON.parseObject(
				IOUtils.toString(new FileInputStream("../config/gome-ops-key.txt"), StandardCharsets.UTF_8),
				WechatCompanyAccessConfig.class);
		accessTokenService = new FilePathAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH,
				accessTokenClient, config);
	}

	@AfterClass
	public static void dispose() {
		service.close();
		accessTokenClient.close();
	}

	/**
	 * 1: {"errcode":60011,"errmsg":"no privilege to access/modify
	 * contact/party/agent "} 2:
	 * {"department":[{"id":2,"name":"金控运维","order":200,"parentid":1}],"errcode":0,"errmsg":"ok"}
	 * 
	 * @throws RemoteException
	 */
	@Ignore
	@Test
	public void testListDepartment() throws RemoteException {
		DepartmentListResp resp = service.list(accessTokenService.getAccessToken().getAccess_token(), 2);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"created","id":10}
	 * 
	 * @throws RemoteException
	 */
	@Ignore
	@Test
	public void testCreateDepartment() throws RemoteException {
		Department department = new Department();
		department.setId(10);
		department.setParentid(2);
		department.setName("运维开发测试组");
		department.setOrder(10);
		DepartmentResp resp = service.create(accessTokenService.getAccessToken().getAccess_token(), department);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"updated"}
	 * 
	 * @throws RemoteException
	 */
	@Ignore
	@Test
	public void testUpdateDepartment() throws RemoteException {
		Department department = new Department();
		department.setId(10);
		department.setParentid(2);
		department.setName("运维开发测试分部");
		department.setOrder(10);
		DepartmentResp resp = service.update(accessTokenService.getAccessToken().getAccess_token(), department);
		System.out.println(JSON.toJSONString(resp));
	}

	/**
	 * {"errcode":0,"errmsg":"deleted"}
	 * 
	 * @throws RemoteException
	 */
	@Ignore
	@Test
	public void testdeleteDepartment() throws RemoteException {

		WechatResponse resp = service.delete(accessTokenService.getAccessToken().getAccess_token(), "10");
		System.out.println(JSON.toJSONString(resp));
	}
}
