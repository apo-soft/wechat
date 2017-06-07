/**
 * 
 */
package cn.aposoft.wechat.mp.message.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.mp.message.CsaMessageService;
import cn.aposoft.wechat.mp.message.remote.CsaMessageClient;
import cn.aposoft.wechat.mp.message.template.Article;
import cn.aposoft.wechat.mp.message.template.Music;
import cn.aposoft.wechat.mp.message.template.Video;

/**
 * 客服发送消息的实现
 * 
 * @author Jann Liu
 *
 */
public class AposoftCsaMessageService implements CsaMessageService {
	private CsaMessageClient client = new CsaMessageClient();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.mp.message.CsaMessageService#sendCard(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public WechatResp sendCard(String accessToken, String openId, String cardId, String account)
			throws RemoteException {
		JSONObject jobj = new JSONObject();
		jobj.put("touser", openId);
		jobj.put("msgtype", "wxcard");
		jobj.put("wxcard", new JSONObject().fluentPut("card_id", cardId));
		if (!StringUtil.isBlank(account)) {
			jobj.put("customservice", new JSONObject().fluentPut("kf_account", account));
		}
		return client.send(accessToken, jobj.toJSONString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.mp.message.CsaMessageService#sendMpNews(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public WechatResp sendMpNews(String accessToken, String openId, String mediaId, String account)
			throws RemoteException {
		JSONObject jobj = new JSONObject();
		jobj.put("touser", openId);
		jobj.put("msgtype", "mpnews");
		jobj.put("mpnews", new JSONObject().fluentPut("media_id", mediaId));
		if (!StringUtil.isBlank(account)) {
			jobj.put("customservice", new JSONObject().fluentPut("kf_account", account));
		}
		return client.send(accessToken, jobj.toJSONString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.mp.message.CsaMessageService#sendNews(java.lang.String,
	 * java.util.List)
	 */
	@Override
	public WechatResp sendNews(String accessToken, String openId, List<Article> articles, String account)
			throws RemoteException {
		JSONObject jobj = new JSONObject();
		jobj.put("touser", openId);
		jobj.put("msgtype", "news");
		jobj.put("news", new JSONObject().fluentPut("articles", articles));
		if (!StringUtil.isBlank(account)) {
			jobj.put("customservice", new JSONObject().fluentPut("kf_account", account));
		}
		return client.send(accessToken, jobj.toJSONString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.mp.message.CsaMessageService#sendMusic(java.lang.
	 * String, cn.aposoft.wechat.mp.message.template.reply.Music)
	 */
	@Override
	public WechatResp sendMusic(String accessToken, String openId, Music music, String account) throws RemoteException {
		JSONObject jobj = new JSONObject();
		jobj.put("touser", openId);
		jobj.put("msgtype", "music");
		jobj.put("music", music);
		if (!StringUtil.isBlank(account)) {
			jobj.put("customservice", new JSONObject().fluentPut("kf_account", account));
		}
		return client.send(accessToken, jobj.toJSONString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.mp.message.CsaMessageService#sendVedio(java.lang.
	 * String, cn.aposoft.wechat.mp.message.template.reply.Vedio)
	 */
	@Override
	public WechatResp sendVedio(String accessToken, String openId, Video vedio, String account) throws RemoteException {
		JSONObject jobj = new JSONObject();
		jobj.put("touser", openId);
		jobj.put("msgtype", "video");
		jobj.put("video", vedio);
		if (!StringUtil.isBlank(account)) {
			jobj.put("customservice", new JSONObject().fluentPut("kf_account", account));
		}
		return client.send(accessToken, jobj.toJSONString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.mp.message.CsaMessageService#sendVoice(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public WechatResp sendVoice(String accessToken, String openId, String mediaId, String account)
			throws RemoteException {
		JSONObject jobj = new JSONObject();
		jobj.put("touser", openId);
		jobj.put("msgtype", "voice");
		jobj.put("voice", new JSONObject().fluentPut("media_id", mediaId));
		if (!StringUtil.isBlank(account)) {
			jobj.put("customservice", new JSONObject().fluentPut("kf_account", account));
		}
		return client.send(accessToken, jobj.toJSONString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.mp.message.CsaMessageService#sendImage(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public WechatResp sendImage(String accessToken, String openId, String mediaId, String account)
			throws RemoteException {
		JSONObject jobj = new JSONObject();
		jobj.put("touser", openId);
		jobj.put("msgtype", "image");

		jobj.put("image", new JSONObject().fluentPut("media_id", mediaId));
		if (!StringUtil.isBlank(account)) {
			jobj.put("customservice", new JSONObject().fluentPut("kf_account", account));
		}
		return client.send(accessToken, jobj.toJSONString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.mp.message.CsaMessageService#sendText(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public WechatResp sendText(String accessToken, String openId, String content, String account)
			throws RemoteException {
		JSONObject jobj = new JSONObject();
		jobj.put("touser", openId);
		jobj.put("msgtype", "text");
		jobj.put("text", new JSONObject().fluentPut("content", content));
		if (!StringUtil.isBlank(account)) {
			jobj.put("customservice", new JSONObject().fluentPut("kf_account", account));
		}

		return client.send(accessToken, jobj.toJSONString());
	}

	@Override
	public WechatResp sendCard(String accessToken, String openId, String cardId) throws RemoteException {
		return sendCard(accessToken, openId, cardId, null);
	}

	@Override
	public WechatResp sendMpNews(String accessToken, String openId, String mediaId) throws RemoteException {
		return sendMpNews(accessToken, openId, mediaId, null);
	}

	@Override
	public WechatResp sendNews(String accessToken, String openId, List<Article> articles) throws RemoteException {
		return sendNews(accessToken, openId, articles, null);
	}

	@Override
	public WechatResp sendMusic(String accessToken, String openId, Music music) throws RemoteException {
		return sendMusic(accessToken, openId, music, null);
	}

	@Override
	public WechatResp sendVedio(String accessToken, String openId, Video vedio) throws RemoteException {
		return sendVedio(accessToken, openId, vedio, null);
	}

	@Override
	public WechatResp sendVoice(String accessToken, String openId, String mediaId) throws RemoteException {
		return sendVoice(accessToken, openId, mediaId, null);
	}

	@Override
	public WechatResp sendImage(String accessToken, String openId, String mediaId) throws RemoteException {
		return sendImage(accessToken, openId, mediaId, null);
	}

	@Override
	public WechatResp sendText(String accessToken, String openId, String content) throws RemoteException {
		return sendText(accessToken, openId, content, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.aposoft.wechat.mp.message.CsaMessageService#close()
	 */
	@Override
	public void close() {
		client.close();
	}

}
