/**
 * 
 */
package cn.aposoft.wechat.mp.message.remote;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;

import cn.aposoft.util.HttpClient;
import cn.aposoft.util.HttpClientFactory;
import cn.aposoft.util.RemoteException;
import cn.aposoft.util.StringUtil;
import cn.aposoft.wechat.mp.remote.WechatResp;

/**
 * 模板消息行业配置
 * 
 * @author Jian Liu
 *
 */
public class IndustryConfigClient implements Closeable {
	final CloseableHttpClient httpClient = HttpClientFactory.createDefault();
	//
	static final String TEMPLATE_INDUSTRY_CONFIG = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
	//
	static final String TEMPLATE_INDUSTRY_CONFIG_QUERY = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=";

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
	public WechatResp setIndustryConfig(String accessToken, String id1, String id2) throws RemoteException {
		if (StringUtil.isBlank(accessToken, id1, id2)) {
			throw new IllegalArgumentException("Some argument(s) is null or empty.");
		}
		Map<String, String> idsContent = new HashMap<>();
		idsContent.put("industry_id1", id1);
		idsContent.put("industry_id2", id2);
		return HttpClient.executeWechat(HttpClient.jsonPost(getConfigIndustryUrl(accessToken), idsContent),
				httpClient);
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
		return HttpClient.execute(new HttpGet(getQueryConfigIndustryUrl(accessToken)), httpClient);
	}

	/**
	 * 设置Industry的url
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @return 合并后URL地址
	 */
	private String getConfigIndustryUrl(String accessToken) {
		return TEMPLATE_INDUSTRY_CONFIG + accessToken;
	}

	/**
	 * 设置Industry的url
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @return 合并后URL地址
	 */
	private String getQueryConfigIndustryUrl(String accessToken) {
		return TEMPLATE_INDUSTRY_CONFIG_QUERY + accessToken;
	}

	@Override
	public void close() {
		HttpClientUtils.closeQuietly(httpClient);
	}

}
