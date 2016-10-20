/**
 * 
 */
package cn.aposoft.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author LiuJian
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
        request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0");
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
}
