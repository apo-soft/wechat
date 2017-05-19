/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.mp.config.UrlConstant;

/**
 * @author Jian Liu
 *
 */
public class IndustryConfigClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();

	/**
	 * 
	 * @param accessToken
	 *            微信访问授权码
	 * @param id1
	 *            主行业
	 * @param id2
	 *            第二行业
	 * @throws RemoteException
	 */
	public void setIndustryConfig(String accessToken, String id1, String id2) throws RemoteException {
		if (StringUtil.isBlank(accessToken, id1, id2)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		Map<String, String> idsContent = new HashMap<>();
		idsContent.put("industry_id1", id1);
		idsContent.put("industry_id2", id2);
		final String requestUrl = getConfigIndustryUrl(accessToken);
		HttpPost httpPost = new HttpPost(requestUrl);
		httpPost.setEntity(EntityBuilder.create()//
				.setContentType(ContentType.APPLICATION_JSON)//
				.setText(JSON.toJSONString(idsContent))//
				.build());
		String respMsg = HttpClient.execute(httpPost, httpClient);
		if (StringUtils.isBlank(respMsg)) {
			throw new RemoteException("Empty response message.");
		}
	}

	/**
	 * @return 行业配置信息
	 * @throws RemoteException
	 * 
	 */
	public String getIndustry(String accessToken) throws RemoteException {
		if (StringUtil.isBlank(accessToken)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		final String requestUrl = getQueryConfigIndustryUrl(accessToken);
		HttpGet httpGet = new HttpGet(requestUrl);
		String respMsg = HttpClient.execute(httpGet, httpClient);
		return respMsg;
	}

	/**
	 * 设置Industry的url
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @return 合并后URL地址
	 */
	private String getConfigIndustryUrl(String accessToken) {
		return UrlConstant.TEMPLATE_INDUSTRY_CONFIG + accessToken;
	}

	/**
	 * 设置Industry的url
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @return 合并后URL地址
	 */
	private String getQueryConfigIndustryUrl(String accessToken) {
		return UrlConstant.TEMPLATE_INDUSTRY_CONFIG_QUERY + accessToken;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}
}
