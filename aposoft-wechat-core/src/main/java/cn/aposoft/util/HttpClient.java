/**
 * 
 */
package cn.aposoft.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Jann Liu
 *
 */
public class HttpClient {
	private final static Logger logger = LoggerFactory.getLogger(HttpClient.class);
	private static boolean logEnabled = true;

	public static boolean isLogEnabled() {
		return logEnabled;
	}

	public static boolean setLogEnabled(boolean logEnabled) {
		return HttpClient.logEnabled = logEnabled;
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
	public static String execute(HttpUriRequest request, CloseableHttpClient httpClient) throws RemoteException {
		if (logEnabled) {
			logger.info("REQUEST:" + request);
		}

		try (CloseableHttpResponse response = httpClient.execute(request);) {
			if (logEnabled && response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				logger.error("RESPONSE Status:" + response.getStatusLine());
				throw new HttpStatusException(response.getStatusLine());
			}
			HttpEntity entity = response.getEntity();
			String jsonStr = EntityUtils.toString(entity, MIME.UTF8_CHARSET);

			if (logEnabled) {
				logger.info(jsonStr);
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
	public static AposoftHttpEntity executeEntity(HttpUriRequest request, CloseableHttpClient httpClient)
			throws RemoteException {
		if (logEnabled) {
			logger.info("REQUEST:" + request);
		}

		try (CloseableHttpResponse response = httpClient.execute(request);) {
			if (logEnabled && response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				logger.error("RESPONSE Status:" + response.getStatusLine());
				throw new HttpStatusException(response.getStatusLine());
			}

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				AposoftHttpEntity resp = new AposoftHttpEntity();
				final String mimeType = response.getFirstHeader("Content-Type").getValue();
				resp.setMimeType(mimeType);
				// 读取JSON
				if (ContentType.APPLICATION_JSON.getMimeType().equals(mimeType)) {
					resp.setText(EntityUtils.toString(response.getEntity()));
				} else {
					// 读取二进制素材
					HttpEntity entity = response.getEntity();
					MediaEntity mediaEntity = new MediaEntity();
					mediaEntity.setContentType(mimeType);
					mediaEntity.setFilename(getFileName(response));
					mediaEntity.setLength(StringUtil.isBlank(response.getFirstHeader("Content-Length"),
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

	//
	private final static String FILENAME_KEY = "filename=";

	private static String getFileName(CloseableHttpResponse response) {
		if (StringUtil.isBlank(response, response.getFirstHeader("Content-disposition"),
				response.getFirstHeader("Content-disposition").getValue()))
			return null;
		String content = response.getFirstHeader("Content-disposition").getValue();

		int fileNameIndex = content.indexOf(FILENAME_KEY);
		if (fileNameIndex >= 0) {
			return content.substring(fileNameIndex + FILENAME_KEY.length() + 1, content.length() - 1);
		}
		return null;
	}
}
