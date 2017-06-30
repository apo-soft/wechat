/**
 * 
 */
package cn.aposoft.wechat.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.aposoft.wechat.AccountId;

/**
 * 访问授权码本地Token声明周期维护及远程访问综合管理服务
 * <p>
 * 1. 会对本地的访问授权码进行管理 2. 当本地授权码即将过期时,将调用远程对授权码进行更新
 * 
 * @author Jann Liu
 * @since 1.0
 */
@Service
public class AccessTokenService {
	/**
	 * 维护的账户信息
	 */
	@Autowired
	private AccountId accountId;

	@Autowired
	private AccessTokenManagement accessTokenManagement;

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public AccessToken getAccessToken() {
		return getAccessToken(accountId);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public AccessToken getAccessToken(final AccountId accountId) {
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
