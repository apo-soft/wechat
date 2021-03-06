/**
 * 
 */
package cn.aposoft.util;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.meidia.MediaEntity;
import cn.aposoft.wechat.meidia.MimeEntity;

/**
 * 客户端工具
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class HttpClient {
	private final static Logger logger = LoggerFactory.getLogger(HttpClient.class);
	private static boolean logEnabled = true;
	//
	private final static String FILENAME_KEY = "filename=";

	public static boolean isLogEnabled() {
		return logEnabled;
	}

	public static boolean setLogEnabled(boolean logEnabled) {
		return HttpClient.logEnabled = logEnabled;
	}

	/**
	 * 
	 * @param url
	 *            get地址
	 * @param clazz
	 *            反射对象
	 * @param httpClient
	 * @return instance of type(T)
	 * @throws RemoteException
	 */
	public static <T> T get(final String url, final Class<T> clazz, final CloseableHttpClient httpClient)
			throws RemoteException {
		return execute(get(url), clazz, httpClient);
	}

	/**
	 * 
	 * @param url
	 *            post地址
	 * @param clazz
	 *            反射对象
	 * @param httpClient
	 * @return instance of type(T)
	 * @throws RemoteException
	 */
	public static <T> T post(final String url, final Object entity, final Class<T> clazz,
			final CloseableHttpClient httpClient) throws RemoteException {
		return execute(jsonPost(url, entity), clazz, httpClient);
	}

	/**
	 * 执行未登录请求，或通用请求
	 * 
	 * @param request
	 *            请求信息
	 * @param httpClient
	 *            客户端
	 * @return 响应报文
	 * @throws Exception
	 */
	public static String execute(final HttpUriRequest request, final CloseableHttpClient httpClient)
			throws RemoteException {
		if (logEnabled && logger.isInfoEnabled()) {
			logger.info("REQUEST:" + request);
		}

		try (CloseableHttpResponse response = httpClient.execute(request);) {
			if (logEnabled && response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				logger.error("RESPONSE Status:" + response.getStatusLine());
				throw new HttpStatusException(response.getStatusLine());
			}
			HttpEntity entity = response.getEntity();
			String jsonStr = EntityUtils.toString(entity, MIME.UTF8_CHARSET);

			if (logEnabled && logger.isInfoEnabled()) {
				logger.info("RESPONSE:" + jsonStr);
			}
			return jsonStr;
		} catch (Exception e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	/**
	 * 执行未登录请求，或通用请求
	 * 
	 * @param request
	 *            请求信息
	 * @param httpClient
	 *            客户端
	 * @return 响应报文
	 * @throws Exception
	 */
	public static MimeEntity executeEntity(final HttpUriRequest request, final CloseableHttpClient httpClient)
			throws RemoteException {
		if (logEnabled && logger.isInfoEnabled()) {
			logger.info("REQUEST:" + request);
		}

		try (CloseableHttpResponse response = httpClient.execute(request);) {
			if (logEnabled && response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				logger.error("RESPONSE Status:" + response.getStatusLine());
				throw new HttpStatusException(response.getStatusLine());
			}

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				if (logEnabled && logger.isDebugEnabled()) {
					logger.debug("RESPONSE:" + response.getStatusLine());
				}

				final String mimeType = response.getFirstHeader("Content-Type") == null ? null
						: response.getFirstHeader("Content-Type").getValue();

				MimeEntity resp = new MimeEntity();
				if (AposoftAssert.isBlank(mimeType)) {
					resp.setMimeType(ContentType.APPLICATION_JSON.getMimeType());
				} else {
					resp.setMimeType(ContentType.parse(mimeType).getMimeType());
				}
				if (!AposoftAssert.isBlank(mimeType)
						&& (ContentType.APPLICATION_JSON.getMimeType().equals(resp.getMimeType())
								|| ContentType.TEXT_PLAIN.getMimeType().equals(resp.getMimeType()))) {
					resp.setText(EntityUtils.toString(response.getEntity()));
				} else {
					// 读取二进制素材
					HttpEntity entity = response.getEntity();
					MediaEntity mediaEntity = new MediaEntity();
					mediaEntity.setContentType(resp.getMimeType());
					mediaEntity.setFilename(getFileName(response));
					mediaEntity.setLength(AposoftAssert.isBlank(response.getFirstHeader("Content-Length"),
							response.getFirstHeader("Content-Length").getValue()) ? null
									: Long.valueOf(response.getFirstHeader("Content-Length").getValue()));
					mediaEntity.setEntity(EntityUtils.toByteArray(entity));
					resp.setMediaEntity(mediaEntity);
				}
				return resp;
			}
			throw new RemoteException("RESP:" + response.getStatusLine());
		} catch (Exception e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	/**
	 * 内部请求公共类
	 * 
	 * @param httpRequest
	 *            请求内容
	 * @param httpClient
	 *            执行客户端
	 * @return {@link WechatResp}
	 * @throws RemoteException
	 */
	public static WechatResp executeWechat(final HttpUriRequest httpRequest, final CloseableHttpClient httpClient)
			throws RemoteException {
		return execute(httpRequest, WechatResp.class, httpClient);
	}

	public static <T> T execute(final HttpUriRequest httpRequest, final Class<T> clazz,
			final CloseableHttpClient httpClient) throws RemoteException {
		String respMsg = HttpClient.execute(httpRequest, httpClient);

		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
		return JSON.parseObject(respMsg, clazz);
	}

	public static HttpGet get(final String listUrl) {
		return new HttpGet(listUrl);
	}

	public static HttpPost post(final String listUrl) {
		return new HttpPost(listUrl);
	}

	public static HttpPost jsonPost(final String requestUrl, final Object entity) {
		String jsonStr = entity instanceof String ? (String) entity : JSON.toJSONString(entity);

		if (logEnabled && logger.isDebugEnabled()) {
			logger.debug("POST JSON:" + jsonStr);
		}
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(EntityBuilder.create()//
				.setContentType(ContentType.APPLICATION_JSON)//
				.setText(jsonStr)//
				.build());
		return httpPost;
	}

	private static String getFileName(CloseableHttpResponse response) {
		if (AposoftAssert.isNull(response, response.getFirstHeader("Content-disposition"))) {
			return null;
		} else {
			String content = response.getFirstHeader("Content-disposition").getValue();
			if (AposoftAssert.isBlank(content)) {
				return null;
			}

			int fileNameIndex = content.indexOf(FILENAME_KEY);
			// 确保文件名有效
			if (fileNameIndex >= 0 && fileNameIndex + FILENAME_KEY.length() + 1 < content.length() - 1) {
				return content.substring(fileNameIndex + FILENAME_KEY.length() + 1, content.length() - 1);
			} else {
				return null;
			}
		}
	}
}
