/**
 * 
 */
package org.aposoft.wechat.company.managemnt.tag.remote;

import java.io.Closeable;
import java.util.List;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.aposoft.wechat.company.managemnt.tag.Tag;
import org.aposoft.wechat.company.managemnt.tag.TagListResp;
import org.aposoft.wechat.company.managemnt.tag.TagResp;
import org.aposoft.wechat.company.managemnt.tag.TagUserResp;

import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.AposoftAssert;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.WechatResult;

/**
 * 标签管理客户端
 * 
 * @author Jann Liu
 *
 */
public class TagManagementClient implements Closeable {
	static final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	//
	static final String COMPANY_TAG_CREATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=";

	static final String COMPANY_TAG_UPDATE_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=";

	static final String COMPANY_TAG_DELETE_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=";
	static final String COMPANY_TAG_DELETE_TAGID_PARAM_URL = "&tagid=";
	static final String COMPANY_TAG_USER_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=";

	static final String COMPANY_TAG_LIST_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=";

	static final String COMPANY_TAG_ADD_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=";
	static final String COMPANY_TAG_DELETE_USER_URL = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=";

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
	public TagResp create(final String accessToken, final Tag tag) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, tag)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.jsonPost(getCreateTagUrl(accessToken), tag), TagResp.class, httpClient);
	}

	private String getCreateTagUrl(String accessToken) {
		return COMPANY_TAG_CREATE_URL + accessToken;
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
	public TagResp update(final String accessToken, final Tag tag) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, tag)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.jsonPost(getUpdateTagUrl(accessToken), tag), TagResp.class, httpClient);
	}

	private String getUpdateTagUrl(String accessToken) {
		return COMPANY_TAG_UPDATE_URL + accessToken;
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
	public WechatResult delete(final String accessToken, final String tagid) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, tagid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.executeWechat(HttpClient.get(getDeleteTagUrl(accessToken, tagid)), httpClient);
	}

	private String getDeleteTagUrl(String accessToken, String tagid) {
		return COMPANY_TAG_DELETE_URL + accessToken + COMPANY_TAG_DELETE_TAGID_PARAM_URL + tagid;
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
	public TagListResp list(final String accessToken) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.get(getListTagUrl(accessToken)), TagListResp.class, httpClient);
	}

	private String getListTagUrl(String accessToken) {
		return COMPANY_TAG_LIST_URL + accessToken;
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
	public WechatResult addTagUser(final String accessToken, final Integer tagid, final List<String> user,
			final List<String> party) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, tagid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		Object userObj = new JSONObject().fluentPut("tagid", tagid).fluentPut("userlist", user).fluentPut("partylist",
				party);
		return HttpClient.executeWechat(HttpClient.jsonPost(getAddTagUserUrl(accessToken), userObj), httpClient);
	}

	private String getAddTagUserUrl(String accessToken) {
		return COMPANY_TAG_ADD_USER_URL + accessToken;
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
	public WechatResult deleteTagUser(final String accessToken, final Integer tagid, final List<String> user,
			final List<String> party) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, tagid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		Object userObj = new JSONObject().fluentPut("tagid", tagid).fluentPut("userlist", user).fluentPut("partylist",
				party);
		return HttpClient.executeWechat(HttpClient.jsonPost(getDeleteTagUserUrl(accessToken), userObj), httpClient);
	}

	private String getDeleteTagUserUrl(String accessToken) {
		return COMPANY_TAG_DELETE_USER_URL + accessToken;
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
	public TagUserResp getTagUser(final String accessToken, final String tagid) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, tagid)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.get(getTagUserUrl(accessToken, tagid)), TagUserResp.class, httpClient);
	}

	private String getTagUserUrl(String accessToken, String tagid) {
		return COMPANY_TAG_USER_LIST_URL + accessToken + COMPANY_TAG_DELETE_TAGID_PARAM_URL + tagid;
	}
}
