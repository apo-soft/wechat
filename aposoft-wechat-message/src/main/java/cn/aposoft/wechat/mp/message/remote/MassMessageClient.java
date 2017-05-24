/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import java.io.Closeable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.mp.message.MsgType;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 群发消息客户端
 * 
 * @author Jann Liu
 *
 */
public class MassMessageClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	static final String MASS_SENDALL_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=";

	static final String MASS_GET_STATUS_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=";

	static final String MASS_OPENID_SENT_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=";

	static final String MASS_DELETE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=";

	static final String MASS_PREVIEW_URL = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 发送微信新闻
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param filter
	 *            过滤器
	 * @param media
	 *            素材
	 * @param configs
	 *            配置项
	 * @return 消息发送结果
	 * @throws RemoteException
	 */
	public MessageResp sendMpnews(final String accessToken, final Filter filter, final MediaIdHolder media,
			Map<String, Object> configs) throws RemoteException {
		return send(accessToken, filter, MsgType.mpnews, media, configs);
	}

	/**
	 * 
	 * @param accessToken
	 * @param touser
	 * @param media
	 * @param configs
	 * @return {"errcode":0,"errmsg":"send job submission
	 *         success","msg_id":3147483655,"msg_data_id":2247483663}
	 * 
	 *         <pre>
	 *         	参数		说明
				type	媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb），图文消息为news
				errcode	错误码
				errmsg	错误信息
				msg_id	消息发送任务的ID
				msg_data_id	消息的数据ID，该字段只有在群发图文消息时，才会出现。
							可以用于在图文分析数据接口中，获取到对应的图文消息的数据，
							是图文分析数据接口中的msgid字段中的前半部分，
							详见图文分析数据接口中的msgid字段的介绍。
	 *         </pre>
	 * 
	 * @throws RemoteException
	 */
	public Object sendMpnews(String accessToken, List<String> touser, MediaIdHolder media, Map<String, Object> configs)
			throws RemoteException {
		return send(accessToken, touser, MsgType.mpnews, media, configs);
	}

	/**
	 * 发送微信新闻
	 * 
	 * 
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param filter
	 *            过滤器
	 * @param media
	 *            素材
	 * @param configs
	 *            配置项
	 * @return 消息发送结果 *
	 * 
	 *         <pre>
	 *  {"errcode":0,"errmsg":"send job submission success","msgid":1000000001}
	 *  {"errcode":45065,"errmsg":"clientmsgid exist","msgid":1000000001}
	 *  <P>
	 *  success:
	 *  {"errcode":0,"errmsg":"send job submission success","msgid":1000000002}
	 *  <p>
	 *  {"errcode":45028,"errmsg":"has no masssend quota hint: [5zSqvA0950ge21]"}
	 *         </pre>
	 * 
	 * @throws RemoteException
	 */
	public MessageResp sendText(final String accessToken, final Filter filter, final String content,
			Map<String, Object> configs) throws RemoteException {
		Map<String, String> map = new HashMap<>();
		map.put("content", content);
		return send(accessToken, filter, MsgType.text, map, configs);
	}

	/**
	 * 发送公共文本微信消息
	 * 
	 * 
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param touser
	 *            接收用户，最少2人
	 * @param content
	 *            文本内容
	 * @param configs
	 *            配置项
	 * @return 消息发送结果 *
	 * 
	 *         <pre>
	 *  {"errcode":0,"errmsg":"send job submission success","msgid":1000000001}
	 *  {"errcode":45065,"errmsg":"clientmsgid exist","msgid":1000000001}
	 *  <P>
	 *  success:
	 *  {"errcode":0,"errmsg":"send job submission success","msgid":1000000002}
	 *  <p>
	 *  {"errcode":45028,"errmsg":"has no masssend quota hint: [5zSqvA0950ge21]"}
	 *         </pre>
	 * 
	 * @throws RemoteException
	 */
	public MessageResp sendText(final String accessToken, final List<String> touser, final String content,
			Map<String, Object> configs) throws RemoteException {
		Map<String, String> map = new HashMap<>();
		map.put("content", content);
		return send(accessToken, touser, MsgType.text, map, configs);
	}

	/**
	 * 发送微信新闻
	 * 
	 * 
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @param filter
	 *            过滤器
	 * @param media
	 *            素材
	 * @param configs
	 *            配置项
	 * @return 消息发送结果 *
	 * 
	 *         <pre>
	 *  {"errcode":0,"errmsg":"send job submission success","msgid":1000000001}
	 *  {"errcode":45065,"errmsg":"clientmsgid exist","msgid":1000000001}
	 *  <P>
	 *  success:
	 *  {"errcode":0,"errmsg":"send job submission success","msgid":1000000002}
	 *  <p>
	 *  {"errcode":45028,"errmsg":"has no masssend quota hint: [5zSqvA0950ge21]"}
	 *         </pre>
	 * 
	 * @throws RemoteException
	 */
	public MessageResp sendImage(String accessToken, Filter filter, MediaIdHolder media, Map<String, Object> configs)
			throws RemoteException {
		return send(accessToken, filter, MsgType.image, media, configs);
	}

	/**
	 * 
	 * @param accessToken
	 * @param touser
	 * @param media
	 * @param configs
	 * 
	 *            <pre>
	 * 			返回码		结果
				45065		相同 clientmsgid 已存在群发记录，返回数据中带有已存在的群发任务的 msgid
				45066   	相同 clientmsgid 重试速度过快，请间隔1分钟重试
				45067   	clientmsgid 长度超过限制
	 *            </pre>
	 * 
	 * @return {"errcode":40152,"errmsg":"invalid group id hint:
	 *         [6AnvkA0640ge20]"}
	 *         <p>
	 *         {"errcode":40130,"errmsg":"invalid openid list size, at least two
	 *         openid hint: [FF5eUa0821ge25]"}
	 * @throws RemoteException
	 */
	public MessageResp sendImage(String accessToken, List<String> touser, MediaIdHolder media,
			Map<String, Object> configs) throws RemoteException {
		return send(accessToken, touser, MsgType.image, media, configs);
	}

	/**
	 * 读取消息发送状态
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param msgId
	 *            消息ID
	 * @return 发送结果
	 * @throws RemoteException
	 */
	public MessageStatusResp getMessageStatus(final String accessToken, final String msgId) throws RemoteException {
		if (StringUtil.isBlank(accessToken, msgId)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.execute(HttpClient.jsonPost(getMessageStatusUrl(accessToken),
				new JSONObject().fluentPut("msg_id", msgId)), MessageStatusResp.class, httpClient);
	}

	/**
	 * 读取消息发送状态
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param msgId
	 *            消息ID
	 * @return 发送结果
	 * @throws RemoteException
	 */
	public WechatResp deleteMassMessage(final String accessToken, final String msgId) throws RemoteException {
		return deleteMassMessage(accessToken, msgId, null);
	}

	/**
	 * 读取消息发送状态
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param msgId
	 *            消息ID
	 * @param articleIndex
	 *            要删除的文章在图文消息中的位置，第一篇编号为1，该字段不填或填0会删除全部文章
	 * @return 删除结果
	 *         <p>
	 *         {"errcode":40008,"errmsg":"invalid message type hint:
	 *         [mksv5a0914ge20]"} for text
	 * 
	 * @throws RemoteException
	 */
	public WechatResp deleteMassMessage(final String accessToken, final String msgId, Integer articleIndex)
			throws RemoteException {
		if (StringUtil.isBlank(accessToken, msgId)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		JSONObject jobj = new JSONObject().fluentPut("msg_id", msgId);
		if (articleIndex != null) {
			jobj.put("article_idx", articleIndex);

		}
		return HttpClient.executeWechat(HttpClient.jsonPost(getDeleteMassMessageUrl(accessToken), jobj),
				httpClient);
	}

	/**
	 * 读取消息发送状态
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param msgId
	 *            消息ID
	 * @param msgType
	 *            消息类型
	 * @param touser
	 *            预览接收人
	 * @return 删除结果
	 *         <p>
	 *         {"errcode":40008,"errmsg":"invalid message type hint:
	 *         [mksv5a0914ge20]"} for text
	 * 
	 * @throws RemoteException
	 */
	public WechatResp preview(final String accessToken, final String touser, final MsgType msgType,
			final MediaIdHolder media) throws RemoteException {
		if (StringUtil.isBlank(accessToken, touser, msgType, media)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		JSONObject jobj = new JSONObject().fluentPut("touser", touser).fluentPut("msgtype", msgType.name())
				.fluentPut(msgType.name(), media);
		String joString = JSON.toJSONString(jobj);
		System.out.println(joString);
		return HttpClient.executeWechat(HttpClient.jsonPost(getMassPreviewUrl(accessToken), jobj),
				httpClient);
	}

	/**
	 * 读取消息发送状态
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param msgId
	 *            消息ID
	 * @param msgType
	 *            消息类型
	 * @param touser
	 *            预览接收人
	 * @return 删除结果
	 *         <p>
	 *         {"errcode":40008,"errmsg":"invalid message type hint:
	 *         [mksv5a0914ge20]"} for text
	 * 
	 * @throws RemoteException
	 */
	public WechatResp preview(final String accessToken, final String touser, final String content)
			throws RemoteException {
		if (StringUtil.isBlank(accessToken, touser, content)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		JSONObject jobj = new JSONObject().fluentPut("touser", touser).fluentPut("msgtype", MsgType.text.name())
				.fluentPut(MsgType.text.name(), new JSONObject().fluentPut("content", content));
		String joString = JSON.toJSONString(jobj);
		System.out.println(joString);
		return HttpClient.executeWechat(HttpClient.jsonPost(getMassPreviewUrl(accessToken), jobj),
				httpClient);
	}

	private String getMassPreviewUrl(String accessToken) {
		return MASS_PREVIEW_URL + accessToken;
	}

	private String getDeleteMassMessageUrl(String accessToken) {
		return MASS_DELETE_MESSAGE_URL + accessToken;
	}

	private String getMessageStatusUrl(String accessToken) {
		return MASS_GET_STATUS_URL + accessToken;
	}

	private String getMassOpenidSendUrl(String accessToken) {
		return MASS_OPENID_SENT_URL + accessToken;
	}

	private String getMassSendUrl(String accessToken) {
		return MASS_SENDALL_URL + accessToken;
	}

	// 群发消息基础方法
	protected MessageResp send(final String accessToken, final Filter filter, MsgType msgType, final Object media,
			Map<String, Object> configs) throws RemoteException {
		JSONObject jobj = new JSONObject().fluentPut("filter", filter).fluentPut("msgtype", msgType.name())
				.fluentPut(msgType.name(), media).fluentPutAll(configs);
		String joString = JSON.toJSONString(jobj);
		System.out.println(joString);
		return HttpClient.execute(HttpClient.jsonPost(getMassSendUrl(accessToken), jobj), MessageResp.class,
				httpClient);
	}

	// 群发消息基础方法
	protected MessageResp send(final String accessToken, final List<String> touser, MsgType msgType, final Object media,
			Map<String, Object> configs) throws RemoteException {
		JSONObject jobj = new JSONObject().fluentPut("touser", touser).fluentPut("msgtype", msgType.name())
				.fluentPut(msgType.name(), media).fluentPutAll(configs);
		String joString = JSON.toJSONString(jobj);
		System.out.println(joString);
		return HttpClient.execute(HttpClient.jsonPost(getMassOpenidSendUrl(accessToken), jobj),
				MessageResp.class, httpClient);
	}

}
