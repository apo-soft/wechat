package cn.aposoft.wechat.mp.config.basic;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BasicWechatMpConfigTest {

	BasicWechatMpConfig config;

	@Before
	public void init() {
		config = mock(BasicWechatMpConfig.class);
		String userId = "gh_0f504b63df22";
		String appId = "wx31659662068251dc";
		String appSecret = "9cf9858af4718fde40d67968b5de3967";
		String token = "AposoftBugs";
		int expired_threshold = 300;
		when(config.getAppId()).thenReturn(appId);
		when(config.getUserId()).thenReturn(userId);
		when(config.getAppSecret()).thenReturn(appSecret);
		when(config.getToken()).thenReturn(token);
		when(config.getExpiredThreshold()).thenReturn(expired_threshold);
	}

	@Test
	public void testGetAppId() {
		Assert.assertEquals("wx31659662068251dc", config.getAppId());
	}

	
}
