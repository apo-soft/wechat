/**
 * 
 */
package cn.aposoft.wechat.company.message.impl;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.company.message.CompanyMessageService;
import cn.aposoft.wechat.company.message.RequestConfig;
import cn.aposoft.wechat.company.message.remote.CompanyMessgeClient;
import cn.aposoft.wechat.company.message.remote.MessageResp;
import cn.aposoft.wechat.mp.media.news.NewsContent;
import cn.aposoft.wechat.mp.message.MsgType;
import cn.aposoft.wechat.mp.message.remote.MediaIdHolder;
import cn.aposoft.wechat.mp.message.template.News;
import cn.aposoft.wechat.mp.message.template.Video;

/**
 * 企业消息发送服务实现
 * 
 * @author Jann Liu
 *
 */
public class AposoftCompanyMessageService implements CompanyMessageService {
	final CompanyMessgeClient client = new CompanyMessgeClient();

	private String createJsonText(MsgType msgType, RequestConfig config, Object data) {
		JSONObject jobj = new JSONObject();
		if (config.getTouser() != null && config.getTouser().length > 0) {
			jobj.put("touser", StringUtils.join(config.getTouser(), "|"));
		}
		if (config.getToparty() != null && config.getToparty().length > 0) {
			jobj.put("toparty", StringUtils.join(config.getToparty(), "|"));
		}
		if (config.getTotag() != null && config.getToparty().length > 0) {
			jobj.put("totag", StringUtils.join(config.getTotag(), "|"));
		}
		jobj.put("msgtype", msgType.name());
		jobj.put("agentid", config.getAgentid());
		jobj.put(msgType.name(), data);
		jobj.put("safe", config.getSafe());
		return jobj.toJSONString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.company.message.CompanyMessageService#sendText(java.
	 * lang.String, cn.aposoft.wechat.company.message.RequestConfig,
	 * java.lang.String)
	 */
	@Override
	public MessageResp sendText(String accessToken, RequestConfig config, String content) throws RemoteException {
		String requestText = createJsonText(MsgType.text, config, new JSONObject().fluentPut("content", content));
		System.out.println(requestText);
		return client.send(accessToken, requestText);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.company.message.CompanyMessageService#sendImage(java.
	 * lang.String, cn.aposoft.wechat.company.message.RequestConfig,
	 * cn.aposoft.wechat.mp.message.remote.MediaIdHolder)
	 */
	@Override
	public MessageResp sendImage(String accessToken, RequestConfig config, MediaIdHolder media) throws RemoteException {
		String requestText = createJsonText(MsgType.image, config, media);
		return client.send(accessToken, requestText);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.company.message.CompanyMessageService#sendVoice(java.
	 * lang.String, cn.aposoft.wechat.company.message.RequestConfig,
	 * cn.aposoft.wechat.mp.message.remote.MediaIdHolder)
	 */
	@Override
	public MessageResp sendVoice(String accessToken, RequestConfig config, MediaIdHolder voice) throws RemoteException {
		String requestText = createJsonText(MsgType.voice, config, voice);
		return client.send(accessToken, requestText);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.company.message.CompanyMessageService#sendVideo(java.
	 * lang.String, cn.aposoft.wechat.company.message.RequestConfig,
	 * cn.aposoft.wechat.mp.message.template.Video)
	 */
	@Override
	public MessageResp sendVideo(String accessToken, RequestConfig config, Video video) throws RemoteException {
		String requestText = createJsonText(MsgType.video, config, video);
		return client.send(accessToken, requestText);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.company.message.CompanyMessageService#sendFile(java.
	 * lang.String, cn.aposoft.wechat.company.message.RequestConfig,
	 * cn.aposoft.wechat.mp.message.remote.MediaIdHolder)
	 */
	@Override
	public MessageResp sendFile(String accessToken, RequestConfig config, MediaIdHolder file) throws RemoteException {
		String requestText = createJsonText(MsgType.file, config, file);
		return client.send(accessToken, requestText);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.company.message.CompanyMessageService#sendNews(java.
	 * lang.String, cn.aposoft.wechat.company.message.RequestConfig,
	 * cn.aposoft.wechat.mp.message.template.News)
	 */
	@Override
	public MessageResp sendNews(String accessToken, RequestConfig config, News news) throws RemoteException {
		String requestText = createJsonText(MsgType.news, config, news);
		return client.send(accessToken, requestText);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.aposoft.wechat.company.message.CompanyMessageService#sendMpnews(java.
	 * lang.String, cn.aposoft.wechat.company.message.RequestConfig,
	 * cn.aposoft.wechat.mp.media.news.NewsContent)
	 */
	@Override
	public MessageResp sendMpnews(String accessToken, RequestConfig config, NewsContent mpnews) throws RemoteException {
		String requestText = createJsonText(MsgType.mpnews, config, mpnews);
		return client.send(accessToken, requestText);
	}

	@Override
	public void close() {
		client.close();
	}

}
