package org.aposoft.wechat.company.managemnt.user.remote;

import java.io.Closeable;
import java.util.List;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.aposoft.wechat.company.managemnt.user.User;
import org.aposoft.wechat.company.managemnt.user.UserListResp;
import org.aposoft.wechat.company.managemnt.user.UserResp;

import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.mp.WechatResp;

public class UserManagementClient implements Closeable {
	static final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	//
	static final String COMPANY_USER_CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=";
	static final String COMPANY_USER_UPDATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=";
	static final String COMPANY_USER_DELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=";
	static final String COMPANY_USER_GET_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=";
	static final String COMPANY_USERID_PARAM_URL = "&userid=";

	static final String COMPANY_USER_DELETE_BATCH_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=";

	//
	static final String COMPANY_GET_DEPARTMENT_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token=";
	static final String COMPANY_GET_DEPARTMENT_USER_DEPARTMENTID_PARAM_URL = "&department_id=";
	static final String COMPANY_GET_DEPARTMENT_USER_FETCH_CHILD_PARAM_URL = "&fetch_child=";
	static final String COMPANY_GET_DEPARTMENT_USER_STATUS_PARAM_URL = "&status=";
	//
	static final String COMPANY_GET_DEPARTMENT_USER_DETAIL_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 创建用户
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param user
	 *            创建用户信息
	 * @return 转换结果
	 * @throws RemoteException
	 */
	public WechatResp create(final String accessToken, final User user) throws RemoteException {
		if (StringUtil.isBlank(accessToken, user)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.executeWechat(HttpClient.jsonPost(getUserCreateUrl(accessToken), user), httpClient);
	}

	private String getUserCreateUrl(String accessToken) {
		return COMPANY_USER_CREATE_URL + accessToken;
	}

	/**
	 * 更新用户
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param user
	 *            更新用户信息
	 * @return 转换结果
	 * @throws RemoteException
	 */
	public WechatResp update(final String accessToken, final User user) throws RemoteException {
		if (StringUtil.isBlank(accessToken, user)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.executeWechat(HttpClient.jsonPost(getUserUpdateUrl(accessToken), user), httpClient);
	}

	private String getUserUpdateUrl(String accessToken) {
		return COMPANY_USER_UPDATE_URL + accessToken;
	}

	/**
	 * 删除用户
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param userid
	 *            企业用户id
	 * @return 转换结果
	 * @throws RemoteException
	 */
	public WechatResp delete(final String accessToken, final String userid) throws RemoteException {
		if (StringUtil.isBlank(accessToken, userid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.executeWechat(HttpClient.get(getUserDeleteUrl(accessToken, userid)), httpClient);
	}

	private String getUserDeleteUrl(String accessToken, String userid) {
		return COMPANY_USER_DELETE_URL + accessToken + COMPANY_USERID_PARAM_URL + userid;
	}

	/**
	 * 删除用户
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param userid
	 *            企业用户id
	 * @return 转换结果
	 * @throws RemoteException
	 */
	public WechatResp delete(final String accessToken, final List<String> userid) throws RemoteException {
		if (StringUtil.isBlank(accessToken, userid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.executeWechat(
				HttpClient.jsonPost(getUserDeleteUrl(accessToken), new JSONObject().fluentPut("useridlist", userid)),
				httpClient);
	}

	private String getUserDeleteUrl(String accessToken) {
		return COMPANY_USER_DELETE_BATCH_URL + accessToken;
	}

	/**
	 * 创建用户
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param agentid
	 *            企业应用id
	 * @return 转换结果
	 * @throws RemoteException
	 */
	public UserResp get(final String accessToken, final String userid) throws RemoteException {
		if (StringUtil.isBlank(accessToken, userid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.execute(HttpClient.get(getUserUrl(accessToken, userid)), UserResp.class, httpClient);
	}

	private String getUserUrl(String accessToken, String userid) {
		return COMPANY_USER_GET_URL + accessToken + COMPANY_USERID_PARAM_URL + userid;
	}

	/**
	 * 批量读取部门成员简要信息列表
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param departmentId
	 *            部门id
	 * @param fetchChild
	 *            是否读取子部门
	 * @param status
	 *            状态
	 * @return 成员列表 [
	 *         0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加,未填写则默认为4]
	 * @throws RemoteException
	 */
	public UserListResp get(String accessToken, int departmentId, int fetchChild, int status) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.execute(HttpClient.get(getUserUrl(accessToken, departmentId, fetchChild, status)),
				UserListResp.class, httpClient);
	}

	private String getUserUrl(String accessToken, int departmentId, int fetchChild, int status) {
		return COMPANY_GET_DEPARTMENT_USER_URL + accessToken + COMPANY_GET_DEPARTMENT_USER_DEPARTMENTID_PARAM_URL
				+ departmentId + COMPANY_GET_DEPARTMENT_USER_FETCH_CHILD_PARAM_URL + fetchChild
				+ COMPANY_GET_DEPARTMENT_USER_STATUS_PARAM_URL + status;
	}

	/**
	 * 批量读取部门成员详细信息列表
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param departmentId
	 *            部门id
	 * @param fetchChild
	 *            是否读取子部门
	 * @param status
	 *            状态
	 * @return 成员列表 [
	 *         0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加,未填写则默认为4]
	 * @throws RemoteException
	 */
	public UserListResp getDetail(String accessToken, int departmentId, int fetchChild, int status)
			throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.execute(HttpClient.get(getUserDetailUrl(accessToken, departmentId, fetchChild, status)),
				UserListResp.class, httpClient);
	}

	private String getUserDetailUrl(String accessToken, int departmentId, int fetchChild, int status) {
		return COMPANY_GET_DEPARTMENT_USER_DETAIL_URL + accessToken + COMPANY_GET_DEPARTMENT_USER_DEPARTMENTID_PARAM_URL
				+ departmentId + COMPANY_GET_DEPARTMENT_USER_FETCH_CHILD_PARAM_URL + fetchChild
				+ COMPANY_GET_DEPARTMENT_USER_STATUS_PARAM_URL + status;
	}

}
