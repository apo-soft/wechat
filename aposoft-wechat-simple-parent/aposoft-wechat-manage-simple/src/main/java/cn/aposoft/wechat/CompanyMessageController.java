/**
 * 
 */
package cn.aposoft.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aposoft.framework.api.ApiResult;
import cn.aposoft.framework.api.ApiUtil;
import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.CachedAccessTokenService;
import cn.aposoft.wechat.account.AccountId;
import cn.aposoft.wechat.company.message.CompanyMessageService;
import cn.aposoft.wechat.company.message.RequestConfig;
import cn.aposoft.wechat.company.message.remote.MessageResp;

/**
 * 企业消息发送服务
 * 
 * @author Jann Liu
 * @since 1.0
 */
@RestController
public class CompanyMessageController {
	private static final Logger logger = LoggerFactory.getLogger(CompanyMessageController.class);
	// AccessToken管理
	@Autowired
	private CachedAccessTokenService defaultCachedAccessTokenService;

	// Company Message Service
	@Autowired
	private CompanyMessageService companyMessageService;
	// 账户id
	@Autowired
	private AccountId accountId;

	@RequestMapping(value = "/work/message/to/{user}", method = RequestMethod.POST)
	public ApiResult<?> sendTextMessage(@PathVariable(value = "user", required = true) final String user,
			final String message) {
		if (logger.isDebugEnabled())
			logger.debug("Begin send text message '{}' to {}", message, user);
		try {
			AccessToken token = defaultCachedAccessTokenService.getAccessToken(accountId);

			if (token != null) {
				return sendRemoteText(token.getAccess_token(), config(user), message);
			} else {
				logger.error("Get default access-token failed, there isn't any access-token by default.");
			}
		} catch (RuntimeException | AccessTokenException e) {
			logger.error("Get default access-token failed with exception.", e);
		}
		return ApiUtil.fail();
	}

	private ApiResult<?> sendRemoteText(String accessToken, RequestConfig config, String message) {
		try {
			MessageResp wechatMessgeResp = companyMessageService.sendText(accessToken, config, message);
			return WechatResultUtil.convert(wechatMessgeResp);
		} catch (RemoteException e) {
			return ApiUtil.fail();
		}
	}

	private RequestConfig config(String user) {
		RequestConfig config = new RequestConfig();
		config.setTouser(new String[] { user });
		config.setAgentid(((CompanyAccountId) accountId).getAgentId());
		return config;
	}
}
