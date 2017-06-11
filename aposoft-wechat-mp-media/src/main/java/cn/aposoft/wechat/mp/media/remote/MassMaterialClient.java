/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.meidia.MediaEntity;
import cn.aposoft.wechat.mp.media.news.NewsItem;

/**
 * @author Jann Liu
 *
 */
public class MassMaterialClient extends MediaClient {
	// 群发素材管理
	// 群发新闻素材URL
	static final String UPLOAD_NEWS_THUMB_URL = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=";
	static final String UPLOAD_NEWS_THUMB_TYPE = "&type=thumb";

	// 上传新闻素材：用于群发消息
	static final String UPLOAD_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=";

	private String getUploadNewsThumbUrl(String accessToken) {
		return UPLOAD_NEWS_THUMB_URL + accessToken + UPLOAD_NEWS_THUMB_TYPE;
	}

	private String getUploadNewsUrl(String accessToken) {
		return UPLOAD_NEWS_URL + accessToken;
	}

	/**
	 * 上传图文素材使用图片
	 * 
	 * @param accessToken
	 *            授权码
	 * @return 素材数量
	 *         <p>
	 * 		{"created_at":1495548585,"thumb_media_id":"iEhKvMtP5yXO8HVayUXqHr4wvGYWXKozjeyPKqV3Ar0kPxW-XUsj_7CP6cwtQ_s7","type":"thumb"}
	 *         <p>
	 *         { "url":
	 *         "http://mmbiz.qpic.cn/mmbiz/gLO17UPS6FS2xsypf378iaNhWacZ1G1UplZYWEYfwvuU6Ont96b1roYs
	 *         CNFwaRrSaKTPCUdBK9DgEHicsKwWCBRQ/0" }
	 *         <p>
	 *         {"errcode":40007,"errmsg":"invalid media_id hint:
	 *         [OJiIRA0621e604]"}
	 *         <p>
	 *         {"errcode":40006,"errmsg":"invalid meida size hint:
	 *         [rvOA60472e298]"}
	 * @throws RemoteException
	 */
	public MediaResp uploadNewsThumb(String accessToken, MediaEntity media) throws RemoteException {
		if (media == null || media.getEntity() == null || media.getEntity().length == 0) {
			throw new IllegalArgumentException("media is null or empty.");
		}

		if (StringUtil.isBlank(accessToken, media, media.getFilename(), media.getContentType())) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		final String requestUrl = getUploadNewsThumbUrl(accessToken);
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(MultipartEntityBuilder.create().addBinaryBody("media", media.getEntity(),
				ContentType.create(media.getContentType()), media.getFilename()).build());
		return HttpClient.execute(httpPost, MediaResp.class, httpClient);
	}

	/**
	 * 添加临时消息图文素材
	 * 
	 * @param accessToken
	 *            授权码
	 * @param news
	 * 
	 *            <pre>
	 * {
		"articles": [
			 {
		         "thumb_media_id":"qI6_Ze_6PtV7svjolgs-rN6stStuHIjs9_DidOHaj0Q-mwvBelOXCFZiq2OsIU-p",
		         "author":"xxx",
				 "title":"Happy Day",
				 "content_source_url":"www.qq.com",
				 "content":"content",
				 "digest":"digest",
		         "show_cover_pic":1
			 },
			 {
		         "thumb_media_id":"qI6_Ze_6PtV7svjolgs-rN6stStuHIjs9_DidOHaj0Q-mwvBelOXCFZiq2OsIU-p",
		         "author":"xxx",
				 "title":"Happy Day",
				 "content_source_url":"www.qq.com",
				 "content":"content",
				 "digest":"digest",
		         "show_cover_pic":0
			 }
		]
		}
	 *            </pre>
	 * 
	 *            <pre>
	 *            	参数					是否必须	说明
					title				是		标题
					thumb_media_id		是		图文消息的封面图片素材id（必须是永久mediaID）
					author				是		作者
					digest				是		图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
					show_cover_pic		是		是否显示封面，0为false，即不显示，1为true，即显示
					content				是	 	图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS,涉及图片url必须来源"上传图文消息内的图片获取URL"接口获取。外部图片url将被过滤。
					content_source_url	是		图文消息的原文地址，即点击“阅读原文”后的URL
	 *            </pre>
	 * 
	 * @return 素材ID
	 *         <p>
	 *         {"created_at":1495512291,"media_id":"-F2WFIAPH5e6NJeOVjfGdWL8gQN67snskg8oT8aLWlF777e-nPZ2rnH3n4z7Xdsk","type":"news"}
	 *         <p>
	 *         {"errcode":40007,"errmsg":"invalid media_id hint:
	 *         [CmFOJA0640e578]"}
	 * @throws RemoteException
	 */
	public MediaResp uploadNews(String accessToken, NewsItem... news) throws RemoteException {
		if (StringUtil.isBlank(accessToken, news)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.jsonPost(getUploadNewsUrl(accessToken),
				new JSONObject().fluentPut("articles", news)), MediaResp.class, httpClient);
	}
}
