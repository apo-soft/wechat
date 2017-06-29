/**
 * 
 */
package cn.aposoft.wechat.access;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.BasicMpAccountId;

/**
 * @author Jann Liu
 *
 */
@RestController
public class AccessTokenController {
	private static final Logger logger = LoggerFactory.getLogger(AccessTokenController.class);

	private CompanyAccessTokenManagement accessTokenManagement;

	@Autowired
	public void setCompanyAccessTokenManagement(CompanyAccessTokenManagement accessTokenManagement) {
		if (logger.isDebugEnabled()) {
			logger.debug("accessTokenManagement is set.");
		}
		this.accessTokenManagement = accessTokenManagement;
	}

	@RequestMapping(value = "/access/token", method = RequestMethod.GET)
	public ApiResult<AccessToken> getAccessToken(BasicMpAccountId accountId) {

		if (logger.isDebugEnabled()) {
			logger.debug(JSON.toJSONString(accountId));
		}
		if (accountId == null || accountId.getAccountType() == null || StringUtils.isBlank(accountId.getId())) {
			return ApiUtil.illegalRequestParams();
		}
		AccessToken token = accessTokenManagement.getAccessToken(accountId);
		if (token != null) {
			return ApiUtil.success(token);
		}
		return ApiUtil.fail();
	}
}
