package cn.aposoft.wechat.mp.config.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import cn.aposoft.wechat.mp.config.WechatMpConfig;
import cn.aposoft.wechat.mp.exception.WechatAccountConfigException;
import cn.aposoft.wechat.mp.util.StringUtil;

public class BasicWechatMpConfig implements WechatMpConfig {
	private String userId;
	private String appId;
	private String appSecret;
	private String token;
	private int expiredThredhold;
public static BasicWechatMpConfig getInstance(){
	return new BasicWechatMpConfig();
}
	public BasicWechatMpConfig() {
		getPorperties("wechatmp.properties");
	}

	/**
	 * 读取默认配置文件
	 * 
	 * @param string
	 * @Author yujinshui
	 * @createTime 2016年10月15日 上午9:26:06
	 */
	private void getPorperties(String file) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e) {
			System.out.println("默认配置文件加载异常");
			e.printStackTrace();
		}
		setPropertiesValues(p);
	}

	/**
	 * 配置文件赋值操作
	 * 
	 * @param p
	 * @Author yujinshui
	 * @createTime 2016年10月15日 上午9:30:18
	 */
	private void setPropertiesValues(Properties p) {
		userId = p.getProperty("USER_ID");
		appId = p.getProperty("APP_ID");
		appSecret = p.getProperty("APP_SECRET");
		token = p.getProperty("TOKEN");
		expiredThredhold = Integer.valueOf(p.getProperty("EXPIRED_THRESHOLD"));

	}

	public BasicWechatMpConfig(String fileName) {
		getPorperties(fileName);
	}

	public BasicWechatMpConfig(Map<String, String> map) throws WechatAccountConfigException {
		if (map == null) {
			throw new NullPointerException();
		}
		userId = map.get("USER_ID");
		appId = map.get("APP_ID");
		appSecret = map.get("APP_SECRET");
		token = map.get("TOKEN");
		expiredThredhold = Integer.valueOf(map.get("EXPIRED_THRESHOLD"));
		if (StringUtil.isBlank(userId, appId, appSecret, token, expiredThredhold)) {
			throw new WechatAccountConfigException("账号配置不能为空，请检查");
		}
	}

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public String getAppId() {
		return appId;
	}

	@Override
	public String getAppSecret() {
		return appSecret;
	}

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public int getExpiredThreshold() {
		return expiredThredhold;// Token 超时时间，5分钟
	}

}
