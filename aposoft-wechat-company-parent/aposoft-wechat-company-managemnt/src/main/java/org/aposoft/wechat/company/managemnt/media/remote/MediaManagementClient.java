/**
 * 
 */
package org.aposoft.wechat.company.managemnt.media.remote;

import java.io.Closeable;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.util.AposoftAssert;
import cn.aposoft.wechat.meidia.MediaEntity;
import cn.aposoft.wechat.meidia.MimeEntity;
import cn.aposoft.wechat.mp.media.remote.MediaEntityResp;
import cn.aposoft.wechat.mp.media.remote.MediaResp;

/**
 * 临时素材管理服务
 * 
 * @author Jann Liu
 *
 */
public class MediaManagementClient implements Closeable {
	static final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	//
	static final String COMPANY_MEDIA_UPLOAD_URL = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=";
	static final String COMPANY_MEDIA_UPLOAD_TYPE_PARAM_URL = "&type=";

	static final String COMPANY_MEDIA_GET_URL = "https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=";
	static final String COMPANY_GET_MEIDA_ID_PARAM_URL = "&media_id=";

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

	public MediaResp upload(final String accessToken, final String type, MediaEntity media) throws RemoteException {
		if (media == null || media.getEntity() == null || media.getEntity().length == 0) {
			throw new IllegalArgumentException("media is null or empty.");
		}

		if (AposoftAssert.isBlank(accessToken, media, media.getFilename(), media.getContentType())) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		final String requestUrl = getUploadMediaUrl(accessToken, type);
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(MultipartEntityBuilder.create().addBinaryBody("media", media.getEntity(),
				ContentType.create(media.getContentType()), media.getFilename()).build());
		return HttpClient.execute(httpPost, MediaResp.class, httpClient);
	}

	private String getUploadMediaUrl(String accessToken, String type) {
		return COMPANY_MEDIA_UPLOAD_URL + accessToken + COMPANY_MEDIA_UPLOAD_TYPE_PARAM_URL + type;
	}

	/**
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param meidaId
	 *            素材ID
	 * @return 素材信息
	 * @throws RemoteException
	 */
	public MediaEntityResp getMeida(final String accessToken, final String mediaId) throws RemoteException {
		if (AposoftAssert.isBlank(accessToken, mediaId)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		final String requestUrl = getMediaUrl(accessToken, mediaId);
		HttpGet httpPost = new HttpGet(requestUrl);

		MimeEntity entity = HttpClient.executeEntity(httpPost, httpClient);
		if (ContentType.APPLICATION_JSON.getMimeType().equals(entity.getMimeType())) {
			return JSON.parseObject(entity.getText(), MediaEntityResp.class);
		} else {
			MediaEntityResp resp = new MediaEntityResp();
			resp.setMedia(entity.getMediaEntity());
			return resp;
		}
	}

	private String getMediaUrl(String accessToken, String mediaId) {
		return COMPANY_MEDIA_GET_URL + accessToken + COMPANY_GET_MEIDA_ID_PARAM_URL + mediaId;
	}

}
