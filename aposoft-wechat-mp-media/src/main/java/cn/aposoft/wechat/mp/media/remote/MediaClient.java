package cn.aposoft.wechat.mp.media.remote;

import java.io.Closeable;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.AposoftHttpEntity;
import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.MediaEntity;
import cn.aposoft.util.RemoteException;
import cn.aposoft.util.StringUtil;

/**
 * 素材管理客户端
 * 
 * @author Jann Liu
 *
 */
public class MediaClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	// 上传素材URL
	static final String UPLOAD_MEIDA_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=";
	static final String UPLOAD_MEIDA_TYPE_URL = "&type=";
	// 读取素材URL
	static final String GET_MEIDA_URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=";
	static final String GET_MEIDA_ID_URL = "&media_id=";

	private String getMediaUrl(String accessToken, String mediaId) {
		return GET_MEIDA_URL + accessToken + GET_MEIDA_ID_URL + mediaId;
	}

	private String getUploadMediaUrl(String accessToken, String type) {
		return UPLOAD_MEIDA_URL + accessToken + UPLOAD_MEIDA_TYPE_URL + type;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	/**
	 * 添加临时素材
	 * 
	 * <pre>
	 *         	参数				是否必须	说明
				access_token	是		调用接口凭证
				type			是		媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
				media			是		form-data中媒体文件标识，有filename、filelength、content-type等信息
	 * </pre>
	 * 
	 * 返回值：
	 * 
	 * <pre>
	 *         	参数			描述
				type		媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
				media_id	媒体文件上传后，获取标识
				created_at	媒体文件上传时间戳
	 * </pre>
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param type
	 *            素材类型
	 * @param media
	 *            素材内容
	 * @return 处理结果
	 *         <p>
	 *         {"created_at":1495420514,"media_id":"w95CmShg2SjGVzKWDT3eA0EZLca1FdkUzG-5nJg3B2mu3QITlTY1VLmFl4q7pK4L","type":"image"}
	 *         <p>
	 *         {"created_at":0,"errcode":40004,"errmsg":"invalid media type
	 *         hint: [e5x5NA0205e541]"}
	 *         <p>
	 *         {"errcode":40004,"errmsg":"invalid media type"}
	 * @throws RemoteException
	 */
	public MediaResp uploadMedia(String accessToken, String type, MediaEntity media) throws RemoteException {
		if (media == null || media.getEntity() == null || media.getEntity().length == 0) {
			throw new IllegalArgumentException("media is null or empty.");
		}

		if (StringUtil.isBlank(accessToken, media, media.getFilename(), media.getContentType())) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		final String requestUrl = getUploadMediaUrl(accessToken, type);
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(MultipartEntityBuilder.create().addBinaryBody("media", media.getEntity(),
				ContentType.create(media.getContentType()), media.getFilename()).build());
		return HttpClient.execute(httpPost, MediaResp.class, httpClient);
	}

	/**
	 * 获取临时素材
	 * 
	 * @param accessToken
	 *            访问授权码
	 * 
	 * @param mediaId
	 *            素材Id
	 * @return 素材二进制数组
	 * 
	 * @throws RemoteException
	 */
	public MediaEntityResp getMedia(String accessToken, String mediaId) throws RemoteException {
		if (StringUtil.isBlank(accessToken, mediaId)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		final String requestUrl = getMediaUrl(accessToken, mediaId);
		HttpGet httpPost = new HttpGet(requestUrl);

		AposoftHttpEntity entity = HttpClient.executeEntity(httpPost, httpClient);
		if (ContentType.APPLICATION_JSON.getMimeType().equals(entity.getMimeType())) {
			return JSON.parseObject(entity.getText(), MediaEntityResp.class);
		} else {
			MediaEntityResp resp = new MediaEntityResp();
			resp.setMedia(entity.getMediaEntity());
			return resp;
		}
	}

}
