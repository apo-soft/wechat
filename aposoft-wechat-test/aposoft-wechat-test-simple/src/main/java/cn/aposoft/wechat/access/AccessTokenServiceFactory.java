/**
 * 
 */
package cn.aposoft.wechat.access;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.access.impl.FilePathAccessTokenService;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.config.BasicAccessConfigFactory;
import cn.aposoft.wechat.config.RefreshConfigFactory;
import cn.aposoft.wechat.config.WechatMpConfigFactory;
import cn.aposoft.wechat.config.WechatCompanyConfig;

/**
 * @author Jann Liu
 *
 */
public class AccessTokenServiceFactory {

	public static AccessTokenService getAccessTokenService() throws IOException {
		return getAccessTokenService(null);
	}

	public static AccessTokenService getAccessTokenService(String filePath) throws IOException {
		if (StringUtils.isBlank(filePath)) {
			filePath = FilePathAccessTokenService.DEFAULT_FILE_PATH;
		}
		AccessTokenClient accessTokenClient = AccessTokenClientFactory.getAccessTokenClient();
		return new FilePathAccessTokenService("../" + FilePathAccessTokenService.DEFAULT_FILE_PATH, accessTokenClient,
				BasicAccessConfigFactory.getInstance(WechatMpConfigFactory.getConfig()).getAccessConfig(),
				RefreshConfigFactory.getRefreshConfig());
	}

	public static AccessTokenService getCompanyAccessTokenService() throws FileNotFoundException, IOException {
		return getCompanyAccessTokenService(FilePathAccessTokenService.DEFAULT_FILE_PATH, "../config/gome-ops-key.txt");
	}

	public static AccessTokenService getCompanyAccessTokenService(String filePath, String configPath)
			throws FileNotFoundException, IOException {
		if (StringUtils.isBlank(configPath)) {
			configPath = "../config/gome-ops-key.txt";
		}
		if (StringUtils.isBlank(filePath)) {
			filePath = FilePathAccessTokenService.DEFAULT_FILE_PATH;
		}
		AccessTokenClient accessTokenClient = AccessTokenClientFactory.getCompanyAccessTokenClient();
		WechatCompanyConfig config = JSON.parseObject(
				IOUtils.toString(new FileInputStream(configPath), StandardCharsets.UTF_8), WechatCompanyConfig.class);
		AccessTokenService accessTokenService = new FilePathAccessTokenService(filePath, accessTokenClient, config,
				RefreshConfigFactory.getRefreshConfig());
		return accessTokenService;
	}
}
