package cn.aposoft.wechat.mp.config.basic;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.aposoft.wechat.mp.SignatureConfig;

public class BasicWechatMpConfigTest {

	SignatureConfig config;

	@Before
	public void init() {
		config = mock(SignatureConfig.class);
		String appId = "wx31659662068251dc";
		String token = "AposoftBugs";
		when(config.getAppId()).thenReturn(appId).thenThrow(new NullPointerException());
		// when(config.getAppId()).thenThrow(new RuntimeException());
		// when(config.getUserId()).thenReturn(userId);
		// when(config.getAppSecret()).thenReturn(appSecret);
		when(config.getToken()).thenReturn(token);
		// when(config.getExpiredThreshold()).thenReturn(expired_threshold);
	}

	@Test
	public void testGetAppId() {
		// expect true
		Assert.assertEquals("wx31659662068251dc", config.getAppId());
		// expect NullPointerException
		// Assert.assertEquals("wx31659662068251dc", config.getAppId());
	}

}
