/**
 * 
 */
package cn.aposoft.wechat.mp.media.remote;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.meidia.MediaEntity;
import cn.aposoft.wechat.meidia.MimeEntity;
import cn.aposoft.wechat.mp.media.news.NewsItem;

/**
 * @author Jann Liu
 *
 */
public class MaterialClient extends MediaClient {
	// 读取素材数量
	static final String MATERIAL_COUNT_URL = "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=";
	// 批量读取素材
	static final String MATERIAL_BATCH_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";

	// 新增永久素材
	static final String ADD_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=";
	static final String ADD_MATERIAL_TYPE_URL = "&type=";

	// 读取永久素材
	static final String GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=";
	// 添加图像
	static final String ADD_IMAGE_URL = "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=";

	// 添加新闻
	static final String ADD_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=";
	// 添加新闻
	static final String UPDATE_NEWS_URL = "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=";

	// 删除素材
	static final String DELETE_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=";

	private String getDeleteMaterialUrl(String accessToken) {
		return DELETE_MATERIAL_URL + accessToken;
	}

	private String getUpdateNewsUrl(String accessToken) {
		return UPDATE_NEWS_URL + accessToken;
	}

	private String getAddNewsUrl(String accessToken) {
		return ADD_NEWS_URL + accessToken;
	}

	private String getAddImageUrl(String accessToken) {
		return ADD_IMAGE_URL + accessToken;
	}

	private String getMaterialUrl(String accessToken) {
		return GET_MATERIAL_URL + accessToken;
	}

	private String getAddMaterialUrl(String accessToken, String type) {
		return ADD_MATERIAL_URL + accessToken + ADD_MATERIAL_TYPE_URL + type;
	}

	private String getMediaListUrl(String accessToken) {
		return MATERIAL_BATCH_URL + accessToken;
	}

	private String getMediaCountUrl(String accessToken) {
		return MATERIAL_COUNT_URL + accessToken;
	}

	/**
	 * 读取素材数量
	 * 
	 * @param accessToken
	 *            授权码
	 * @return 素材数量
	 *         <p>
	 *         {"errcode":45009,"errmsg":"reach max api daily quota limit hint:
	 *         [JJ8hKA0553vr30!]"}
	 * @throws RemoteException
	 */
	public MaterialCountResp getMediaCount(String accessToken) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.execute(new HttpGet(getMediaCountUrl(accessToken)), MaterialCountResp.class, httpClient);
	}

	/**
	 * 读取素材数量
	 * https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=oxv_xbZv329RF1_eCYCE3PgWiiQhH4ECpfwcWq_JNxwsGQuQn1UyEmuLb9uzwWJfMD3mgOTFV9LEaBu0ZT2t1gCfv36pjX_Zyr5bpoz_cUQ9U3sJ64XyhbOJesqACpuJZXFfAIAFDL
	 * 
	 * @param accessToken
	 *            授权码
	 * @return 素材数量
	 *         <p>
	 *         {"errcode":45009,"errmsg":"reach max api daily quota limit hint:
	 *         [8.A1rA0201vr43!]"}
	 * 
	 *         <pre>
	 *         {
					"item":[
					    {
					        "media_id":"gbFT6slaM_0w2LBuG_B-WBRmwdhftRGrelZEFW47sZg",
					        "name":"diamond-404.jpg",
					        "update_time":1495466553,
					        "url":"http://mmbiz.qpic.cn/mmbiz_jpg/6gM6Q4IuDVhkUFNQxLm0pAVqSJSyZ5g9puFQCtHq6ngInOrPibVW8RKyrqiaKLB7vLfpicRQ5rKI3Ul3dibL7XshaQ/0?wx_fmt=jpeg"
					    }
					],
					"item_count":1,
					"total_count":1
				}
	 *         </pre>
	 * 
	 *         <pre>
	 * {
	"item":[
	    {
	        "media_id":"gbFT6slaM_0w2LBuG_B-WCZ3QPLdOneF-f1Dc7yV8zc",
	        "content":{
	            "news_item":[
	                {
	                    "title":"测试新闻",
	                    "author":"Jann",
	                    "digest":"测试新闻 摘要",
	                    "content":"测试新闻内容,这是一件重大的测试新闻.",
	                    "content_source_url":"https://www.aposoft.cn",
	                    "thumb_media_id":"gbFT6slaM_0w2LBuG_B-WBRmwdhftRGrelZEFW47sZg",
	                    "show_cover_pic":1,
	                    "url":"http://mp.weixin.qq.com/s?__biz=MzI5NzQ4NTcxMA==&mid=100000005&idx=1&sn=fb7dea6ed9d6444836b81321bb9c0dac&chksm=6cb515e45bc29cf263fba18e1d47751dbc620b425af92cdb1277babb150419aede261a33bc81#rd",
	                    "thumb_url":"http://mmbiz.qpic.cn/mmbiz_jpg/6gM6Q4IuDVhkUFNQxLm0pAVqSJSyZ5g9puFQCtHq6ngInOrPibVW8RKyrqiaKLB7vLfpicRQ5rKI3Ul3dibL7XshaQ/0?wx_fmt=jpeg",
	                    "need_open_comment":0,
	                    "only_fans_can_comment":0
	                }
	            ],
	            "create_time":1495479785,
	            "update_time":1495479785
	        },
	        "update_time":1495479785
	    },
	    {
	        "media_id":"gbFT6slaM_0w2LBuG_B-WMOTmnrnD3YlQ84dieFTLSo",
	        "content":{
	            "news_item":[
	                {
	                    "title":"测试新闻",
	                    "author":"Jann",
	                    "digest":"测试新闻 摘要",
	                    "content":"测试新闻内容,这是一件重大的测试新闻.",
	                    "content_source_url":"https://www.aposoft.cn",
	                    "thumb_media_id":"gbFT6slaM_0w2LBuG_B-WBRmwdhftRGrelZEFW47sZg",
	                    "show_cover_pic":1,
	                    "url":"http://mp.weixin.qq.com/s?__biz=MzI5NzQ4NTcxMA==&mid=100000003&idx=1&sn=92f3e9f96fba7a9d2c4a80d11c1f37db&chksm=6cb515e25bc29cf4808dc8e343771e34aa8e2de802d6c8065ffaee38b4856f04013713130a51#rd",
	                    "thumb_url":"http://mmbiz.qpic.cn/mmbiz_jpg/6gM6Q4IuDVhkUFNQxLm0pAVqSJSyZ5g9puFQCtHq6ngInOrPibVW8RKyrqiaKLB7vLfpicRQ5rKI3Ul3dibL7XshaQ/0?wx_fmt=jpeg",
	                    "need_open_comment":0,
	                    "only_fans_can_comment":0
	                }
	            ],
	            "create_time":1495479765,
	            "update_time":1495479765
	        },
	        "update_time":1495479765
	    }
	],
	"total_count":2,
	"item_count":2
	}
	 *         </pre>
	 * 
	 * @throws RemoteException
	 */
	public MaterialListResp getMediaList(String accessToken, MediaListReq req) throws RemoteException {
		if (StringUtil.isBlank(accessToken, req)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		return HttpClient.execute(HttpClient.jsonPost(getMediaListUrl(accessToken), req),
				MaterialListResp.class, httpClient);
	}

	/**
	 * 添加永久素材
	 * 
	 * <pre>
	 * 请注意：
			1、最近更新：永久图片素材新增后，将带有URL返回给开发者，开发者可以在腾讯系域名内使用（腾讯系域名外使用，图片将被屏蔽）。
			2、公众号的素材库保存总数量有上限：图文消息素材、图片素材上限为5000，其他类型为1000。
			3、素材的格式大小等要求与公众平台官网一致：
				图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
				语音（voice）：2M，播放长度不超过60s，mp3/wma/wav/amr格式
				视频（video）：10MB，支持MP4格式
				缩略图（thumb）：64KB，支持JPG格式
			4、图文消息的具体内容中，微信后台将过滤外部的图片链接，图片url需通过"上传图文消息内的图片获取URL"接口上传图片获取。
			5、"上传图文消息内的图片获取URL"接口所上传的图片，不占用公众号的素材库中图片数量的5000个的限制，图片仅支持jpg/png格式，大小必须在1MB以下。
	 * </pre>
	 * 
	 * @param accessToken
	 *            授权码
	 * @return 素材数量
	 *         <p>
	 *         {"created_at":0,"media_id":"gbFT6slaM_0w2LBuG_B-WBRmwdhftRGrelZEFW47sZg","url":"http://mmbiz.qpic.cn/mmbiz_jpg/6gM6Q4IuDVhkUFNQxLm0pAVqSJSyZ5g9puFQCtHq6ngInOrPibVW8RKyrqiaKLB7vLfpicRQ5rKI3Ul3dibL7XshaQ/0?wx_fmt=jpeg"}
	 * @throws RemoteException
	 */
	public MediaResp addMaterial(String accessToken, String type, MediaEntity media) throws RemoteException {
		if (media == null || media.getEntity() == null || media.getEntity().length == 0) {
			throw new IllegalArgumentException("media is null or empty.");
		}

		if (StringUtil.isBlank(accessToken, media, media.getFilename(), media.getContentType())) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		final String requestUrl = getAddMaterialUrl(accessToken, type);
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(MultipartEntityBuilder.create().addBinaryBody("media", media.getEntity(),
				ContentType.create(media.getContentType()), media.getFilename()).build());
		return HttpClient.execute(httpPost, MediaResp.class, httpClient);
	}

	/**
	 * 获取永久素材
	 * 
	 * @param accessToken
	 *            授权码
	 * @return 素材数量
	 *         <p>
	 *         {"errcode":45009,"errmsg":"reach max api daily quota limit hint:
	 *         [1SXMpA0952vr50!]"}
	 *         <p>
	 *         {"errcode":40007,"errmsg":"invalid media_id hint:
	 *         [OJiIRA0621e604]"}
	 * @throws RemoteException
	 */
	public MaterialResp getMaterial(String accessToken, String media_id) throws RemoteException {
		if (StringUtil.isBlank(accessToken, media_id)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		HttpPost post = HttpClient.jsonPost(getMaterialUrl(accessToken),
				new JSONObject().fluentPut("media_id", media_id));
		MimeEntity entity = HttpClient.executeEntity(post, httpClient);
		if (ContentType.APPLICATION_JSON.getMimeType().equals(entity.getMimeType())) {
			return JSON.parseObject(entity.getText(), MaterialResp.class);
		} else {
			MaterialResp resp = new MaterialResp();
			resp.setMediaEntity(entity.getMediaEntity());
			return resp;
		}
	}

	/**
	 * 上传图文素材使用图片
	 * 
	 * @param accessToken
	 *            授权码
	 * @return 素材数量
	 *         <p>
	 *         { "url":
	 *         "http://mmbiz.qpic.cn/mmbiz/gLO17UPS6FS2xsypf378iaNhWacZ1G1UplZYWEYfwvuU6Ont96b1roYs
	 *         CNFwaRrSaKTPCUdBK9DgEHicsKwWCBRQ/0" }
	 *         <p>
	 *         {"errcode":40007,"errmsg":"invalid media_id hint:
	 *         [OJiIRA0621e604]"}
	 * @throws RemoteException
	 */
	public MediaResp uploadImage(String accessToken, MediaEntity media) throws RemoteException {
		if (media == null || media.getEntity() == null || media.getEntity().length == 0) {
			throw new IllegalArgumentException("media is null or empty.");
		}

		if (StringUtil.isBlank(accessToken, media, media.getFilename(), media.getContentType())) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		final String requestUrl = getAddImageUrl(accessToken);
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(MultipartEntityBuilder.create().addBinaryBody("media", media.getEntity(),
				ContentType.create(media.getContentType()), media.getFilename()).build());
		return HttpClient.execute(httpPost, MediaResp.class, httpClient);
	}

	/**
	 * 添加永久图文素材
	 * 
	 * @param accessToken
	 *            授权码
	 * @param news
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
	 *         { "media_id":MEDIA_ID }
	 *         <p>
	 *         {"errcode":40007,"errmsg":"invalid media_id hint:
	 *         [OJiIRA0621e604]"}
	 * @throws RemoteException
	 */
	public MediaResp addNews(String accessToken, NewsItem... news) throws RemoteException {

		if (StringUtil.isBlank(accessToken, news)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(
				HttpClient.jsonPost(getAddNewsUrl(accessToken), new JSONObject().fluentPut("articles", news)),
				MediaResp.class, httpClient);
	}

	/**
	 * 上传图文素材使用图片
	 * 
	 * @param accessToken
	 *            授权码
	 * @param req
	 * 
	 *            <pre>
	 *            	参数					是否必须	说明
	 *            	media_id 			是		要修改的图文消息的id
					index				是		要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
					articles:-->		是		更新的图文内容(以下为articles内容)
					
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
	 *         {"errcode":0,"errmsg":"ok"}
	 *         <p>
	 *         {"errcode":40007,"errmsg":"invalid media_id hint:
	 *         [OJiIRA0621e604]"}
	 * @throws RemoteException
	 */
	public MediaResp updateNews(String accessToken, NewsReq req) throws RemoteException {

		if (StringUtil.isBlank(accessToken, req)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.jsonPost(getUpdateNewsUrl(accessToken), req), MediaResp.class,
				httpClient);
	}

	/**
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param mediaId
	 *            素材ID
	 * @return { "errcode":ERRCODE, "errmsg":ERRMSG }
	 *         <p>
	 *         {"errcode":0,"errmsg":"ok"}
	 *         <p>
	 *         {"errcode":44003,"errmsg":"empty news data hint:
	 *         [cwm9nA0124e421]"}
	 * @throws RemoteException
	 */
	public WechatResp deleteMaterial(String accessToken, String mediaId) throws RemoteException {

		if (StringUtil.isBlank(accessToken, mediaId)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}

		return HttpClient.execute(HttpClient.jsonPost(getDeleteMaterialUrl(accessToken),
				new JSONObject().fluentPut("media_id", mediaId)), WechatResp.class, httpClient);
	}

}
