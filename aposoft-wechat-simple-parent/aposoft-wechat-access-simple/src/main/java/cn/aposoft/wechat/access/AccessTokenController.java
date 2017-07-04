/**
 * 
 */
package cn.aposoft.wechat.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aposoft.framework.api.ApiResult;
import cn.aposoft.framework.api.ApiUtil;
import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.CachedAccessTokenService;
import cn.aposoft.wechat.account.AccountId;

/**
 * 
 * @author Jann Liu
 * @since 1.0
 */
@RestController
public class AccessTokenController {
	private static final Logger logger = LoggerFactory.getLogger(AccessTokenController.class);

	@Autowired
	private CachedAccessTokenService defaultCachedAccessTokenService;

	@Autowired
	private AccountId accountId;

	@RequestMapping(value = "/access/token", method = RequestMethod.GET)
	public ApiResult<AccessToken> getAccessToken() {
		if (logger.isDebugEnabled())
			logger.debug("Begin access default access-token.");
		try {
			AccessToken token = defaultCachedAccessTokenService.getAccessToken(accountId);
			if (token != null) {
				return ApiUtil.success(token);
			} else {
				logger.error("Get default  access-token  failed, there isn't any access-token by default.");
			}
		} catch (RuntimeException | AccessTokenException e) {
			logger.error("Get default  access-token  failed with exception.", e);
		}
		return ApiUtil.fail();
	}
}
