/**
 * 
 */
package org.aposoft.wechat.company.managemnt.department.remote;

import java.io.Closeable;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.aposoft.wechat.company.managemnt.department.Department;
import org.aposoft.wechat.company.managemnt.department.DepartmentListResp;
import org.aposoft.wechat.company.managemnt.department.DepartmentResp;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.mp.remote.WechatResponse;

/**
 * 部门管理调用客户端
 * 
 * @author Jann Liu
 *
 */
public class DepartmentManagementClient implements Closeable {
	static final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	//
	static final String COMPANY_DEPARTMENT_CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=";

	static final String COMPANY_DEPARTMENT_UPDATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=";

	static final String COMPANY_DEPARTMENT_DELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=";
	static final String COMPANY_DEPARTMENT_DELETE_ID_PARAM_URL = "&id=";

	static final String COMPANY_DEPARTMENT_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 添加标签
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param tag
	 *            标签
	 * @return 添加结果
	 * @throws RemoteException
	 */
	public DepartmentResp create(final String accessToken, final Department department) throws RemoteException {
		if (StringUtil.isBlank(accessToken, department)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.jsonPost(getCreateDepartmentUrl(accessToken), department),
				DepartmentResp.class, httpClient);
	}

	private String getCreateDepartmentUrl(String accessToken) {
		return COMPANY_DEPARTMENT_CREATE_URL + accessToken;
	}

	/**
	 * 更新标签
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param tag
	 *            标签
	 * @return 添加结果
	 * @throws RemoteException
	 */
	public DepartmentResp update(final String accessToken, final Department department) throws RemoteException {
		if (StringUtil.isBlank(accessToken, department)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.jsonPost(getUpdateDepartmentUrl(accessToken), department),
				DepartmentResp.class, httpClient);
	}

	private String getUpdateDepartmentUrl(String accessToken) {
		return COMPANY_DEPARTMENT_UPDATE_URL + accessToken;
	}

	/**
	 * 删除标签
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param tagid
	 *            标签
	 * @return 删除结果
	 * @throws RemoteException
	 */
	public WechatResponse delete(final String accessToken, final String id) throws RemoteException {
		if (StringUtil.isBlank(accessToken, id)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.executeWechat(HttpClient.get(getDeleteTagUrl(accessToken, id)), httpClient);
	}

	private String getDeleteTagUrl(String accessToken, String id) {
		return COMPANY_DEPARTMENT_DELETE_URL + accessToken + COMPANY_DEPARTMENT_DELETE_ID_PARAM_URL + id;
	}

	/**
	 * 列表标签
	 * 
	 * @param accessToken
	 *            访问授权码
	 * 
	 * @return 标签列表相应
	 * @throws RemoteException
	 */
	public DepartmentListResp list(final String accessToken, final Integer id) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.get(getListTagUrl(accessToken, id)), DepartmentListResp.class, httpClient);
	}

	private String getListTagUrl(String accessToken, Integer id) {
		return COMPANY_DEPARTMENT_LIST_URL + accessToken
				+ (id == null ? "" : COMPANY_DEPARTMENT_DELETE_ID_PARAM_URL + id);
	}

}
