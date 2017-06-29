/**
 * 
 */
package cn.aposoft.wechat.access.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.aposoft.wechat.ApiResult;
import cn.aposoft.wechat.ApiUtil;
import cn.aposoft.wechat.access.AccessToken;

/**
 * 
 * @author Jann Liu
 * @since 1.0
 */
@RestController
public class AccessTokenController {
	private static final Logger logger = LoggerFactory.getLogger(AccessTokenController.class);

	@Autowired
	private AccessTokenService accessTokenService;

	@RequestMapping(value = "/access/token", method = RequestMethod.GET)
	public ApiResult<AccessToken> getAccessToken() {
		if (logger.isDebugEnabled())
			logger.debug("Begin access default access-token.");
		try {
			AccessToken token = accessTokenService.getAccessToken();
			if (token != null) {
				return ApiUtil.success(token);
			} else {
				logger.error("Get default  access-token  failed, there isn't any access-token by default.");
			}
		} catch (RuntimeException e) {
			logger.error("Get default  access-token  failed with exception.", e);
		}
		return ApiUtil.fail();
	}
}
