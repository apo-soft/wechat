/**
 * 
 */
package cn.aposoft.wechat.mp.user.tag.remote;

import java.io.Closeable;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.mp.WechatResp;
import cn.aposoft.wechat.mp.user.tag.UserTag;

/**
 * 用户标签管理客户端
 * 
 * @author Jann Liu
 *
 */
public class UserTagClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	static final String USER_TAG_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=";

	static final String USER_TAG_LIST_URL = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=";

	static final String USER_TAG_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=";

	static final String USER_TAG_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=";

	// 批量为用户打标签
	static final String USER_TAG_BATCH_TAGGING_URL = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=";
	// 批量取消用户标签
	static final String USER_TAG_BATCH_REMOVE_TAGS_URL = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=";

	static final String USER_TAG_TAGLIST_FOR_USER_URL = "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=";

	/**
	 * 添加标签，重复提交相同标签，返回45157错误
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param name
	 *            新标签名称
	 * @return {"tag":{"id":101,"name":"亲属"}}
	 *         <p>
	 *         {"errcode":45157,"errmsg":"invalid tag name hint:
	 *         [rwL31a0162vr23]"}
	 * @throws RemoteException
	 */
	public UserTagResp create(final String accessToken, final String name) throws RemoteException {
		if (StringUtil.isBlank(accessToken, name)) {
			throw new IllegalArgumentException("access_token is empty.");
		}
		final String url = getTagCreateUrl(accessToken);
		HttpPost httpPost = new HttpPost(url);

		JSONObject jobj = new JSONObject().fluentPut("tag", //
				new JSONObject().fluentPut("name", name));
		httpPost.setEntity(EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON)//
				.setText(jobj.toJSONString()).build());

		final String respMsg = HttpClient.execute(httpPost, httpClient);

		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, UserTagResp.class);
	}

	/**
	 * 读取用户标签列表
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param name
	 *            新标签名称
	 * @return {"tag":{"id":101,"name":"亲属"}}
	 *         <p>
	 *         {"errcode":45157,"errmsg":"invalid tag name hint:
	 *         [rwL31a0162vr23]"}
	 * @throws RemoteException
	 */
	public UserTagListResp list(final String accessToken) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("access_token is empty.");
		}
		final String url = getTagListUrl(accessToken);
		HttpGet httpGet = new HttpGet(url);

		final String respMsg = HttpClient.execute(httpGet, httpClient);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, UserTagListResp.class);
	}

	/**
	 * 更新标签
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param tag
	 *            更新的标签定义 id，name 必填
	 * @return { "errcode":0, "errmsg":"ok" }
	 *         <p>
	 *         {"errcode":-1,"errmsg":"系统繁忙"}
	 *         <p>
	 *         {"errcode":45157,"errmsg":"标签名非法，请注意不能和其他标签重名"}
	 *         <p>
	 *         {"errcode":45158,"errmsg":"标签名长度超过30个字节"}
	 *         <p>
	 *         {"errcode":45058,"errmsg":"不能修改0/1/2这三个系统默认保留的标签"}
	 * @throws RemoteException
	 */
	public WechatResp update(final String accessToken, final UserTag tag) throws RemoteException {
		if (StringUtil.isBlank(accessToken, tag, tag.getName())) {
			throw new IllegalArgumentException("access_token or tag is not legal.");
		}
		final String url = getTagUpdateUrl(accessToken);
		HttpPost httpPost = new HttpPost(url);

		JSONObject jobj = new JSONObject().fluentPut("tag", //
				tag);
		String json = jobj.toJSONString();
		System.out.println(json);
		httpPost.setEntity(EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON)//
				.setText(json).build());

		final String respMsg = HttpClient.execute(httpPost, httpClient);

		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, WechatResp.class);
	}

	/**
	 * 删除标签
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param name
	 *            新标签名称
	 * @return { "errcode":0, "errmsg":"ok" }
	 *         <p>
	 *         {"errcode":-1,"errmsg":"系统繁忙"}
	 *         {"errcode":45057,"errmsg":"不能修改0/1/2这三个系统默认保留的标签"}
	 *         {"errcode":45058,"errmsg":"该标签下粉丝数超过10w，不允许直接删除"}
	 * @throws RemoteException
	 */
	public WechatResp delete(final String accessToken, final int id) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("access_token is empty.");
		}
		final String url = getTagDeleteUrl(accessToken);
		HttpPost httpPost = new HttpPost(url);
		JSONObject jobj = new JSONObject().fluentPut("tag", //
				new JSONObject().fluentPut("id", id));
		httpPost.setEntity(EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON)//
				.setText(jobj.toJSONString()).build());

		final String respMsg = HttpClient.execute(httpPost, httpClient);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, WechatResp.class);
	}

	/**
	 * 批量给用户打标签
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param taggingReq
	 *            批量添加对象
	 * @return { "errcode":0, "errmsg":"ok" }
	 * 
	 *         <pre>
	 * 			-1		系统繁忙
				40032	每次传入的openid列表个数不能超过50个
				45159	非法的标签
				45059	有粉丝身上的标签数已经超过限制，即超过20个
				40003	传入非法的openid
				49003	传入的openid不属于此AppID
	 *         </pre>
	 * 
	 * @throws RemoteException
	 */
	public WechatResp batchTagging(final String accessToken, final BatchTaggingReq taggingReq) throws RemoteException {
		if (StringUtil.isBlank(accessToken, taggingReq)) {
			throw new IllegalArgumentException("access_token or taggingReq is empty.");
		}
		final String url = getBatchTaggingUrl(accessToken);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON)//
				.setText(JSON.toJSONString(taggingReq)).build());

		final String respMsg = HttpClient.execute(httpPost, httpClient);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, WechatResp.class);
	}

	/**
	 * 批量给用户删除标签
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param taggingReq
	 *            批量添加对象
	 * @return { "errcode":0, "errmsg":"ok" }
	 * 
	 *         <pre>
	 * 			-1		系统繁忙
				40032	每次传入的openid列表个数不能超过50个
				45159	非法的标签
				40003	传入非法的openid
				49003	传入的openid不属于此AppID
	 *         </pre>
	 * 
	 * @throws RemoteException
	 */
	public WechatResp batchRemoveTags(final String accessToken, final BatchTaggingReq taggingReq)
			throws RemoteException {
		if (StringUtil.isBlank(accessToken, taggingReq)) {
			throw new IllegalArgumentException("access_token or taggingReq is empty.");
		}
		final String url = getBatchRemoveTagsUrl(accessToken);
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON)//
				.setText(JSON.toJSONString(taggingReq)).build());

		final String respMsg = HttpClient.execute(httpPost, httpClient);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, WechatResp.class);
	}

	/**
	 * 添加标签，重复提交相同标签，返回45157错误
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param name
	 *            新标签名称
	 * @return {@code {"tagid_list":[]} {"tagid_list":[100]}}
	 * 
	 *         <pre>
				 * -1	系统繁忙
				40003	传入非法的openid
				49003	传入的openid不属于此AppID
	 *         </pre>
	 * 
	 * @throws RemoteException
	 */
	public UserTagsIdListResp listUserTags(final String accessToken, final String openId) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("access_token is empty.");
		}
		final String url = getUserTagListUrl(accessToken);
		HttpPost httpPost = new HttpPost(url);
		JSONObject jobj = new JSONObject().fluentPut("openid", openId);
		httpPost.setEntity(EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON)//
				.setText(jobj.toJSONString()).build());
		final String respMsg = HttpClient.execute(httpPost, httpClient);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, UserTagsIdListResp.class);
	}

	private String getUserTagListUrl(String accessToken) {
		return USER_TAG_TAGLIST_FOR_USER_URL + accessToken;
	}

	private String getBatchRemoveTagsUrl(String accessToken) {
		return USER_TAG_BATCH_REMOVE_TAGS_URL + accessToken;
	}

	private String getBatchTaggingUrl(String accessToken) {
		return USER_TAG_BATCH_TAGGING_URL + accessToken;
	}

	private String getTagUpdateUrl(String accessToken) {
		return USER_TAG_UPDATE_URL + accessToken;
	}

	//
	private String getTagDeleteUrl(String accessToken) {
		return USER_TAG_DELETE_URL + accessToken;
	}

	// 创建访问Url
	private String getTagListUrl(final String accessToken) {
		return USER_TAG_LIST_URL + accessToken;
	}

	// 创建访问Url
	private String getTagCreateUrl(final String accessToken) {
		return USER_TAG_CREATE_URL + accessToken;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}
}
