/**
 * 
 */
package cn.aposoft.wechat.access.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.aposoft.wechat.AccountId;
import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.DbAccessTokenManagement;

/**
 * @author Jann Liu
 *
 */
@Service
public class AccessTokenService {
	/**
	 * 维护的账户信息
	 */
	@Autowired
	private AccountId accountId;

	@Autowired
	private DbAccessTokenManagement accessTokenManagement;

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public AccessToken getAccessToken() {
		AccessToken accessToken = accessTokenManagement.getAccessToken(accountId);
		accessToken = checkExpires(accessToken);
		return accessToken;
	}

	// 判断访问码是否过期
	private AccessToken checkExpires(AccessToken accessToken) {
		// TODO Auto-generated method stub
		return null;
	}
}
