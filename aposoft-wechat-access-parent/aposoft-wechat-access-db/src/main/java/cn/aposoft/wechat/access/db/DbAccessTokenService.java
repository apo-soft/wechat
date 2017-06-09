/**
 * 
 */
package cn.aposoft.wechat.access.db;

import java.io.IOException;

import org.springframework.transaction.annotation.Transactional;

import cn.aposoft.wechat.access.AccessToken;
import cn.aposoft.wechat.access.AccessTokenException;
import cn.aposoft.wechat.access.AccessTokenService;
import cn.aposoft.wechat.access.RefreshConfig;
import cn.aposoft.wechat.access.impl.AbstractAccessTokenService;
import cn.aposoft.wechat.access.remote.AccessTokenClient;
import cn.aposoft.wechat.config.AccountConfig;

/**
 * 使用Database完成accessToken的缓存
 * 
 * @author Jann Liu
 * @since 1.0
 */
public class DbAccessTokenService extends AbstractAccessTokenService implements AccessTokenService {

	// DB访问对象
	private AccessTokenDao accessTokenDao;

	public DbAccessTokenService(AccessTokenClient client, AccountConfig config, RefreshConfig refreshConfig,
			AccessTokenDao accessTokenDao) throws IOException {
		super(client, config, refreshConfig);
	}

	/**
	 * 提供了基础的AccessToken的实现 在添加缓存的分布式管理的系统中,需要重写此实现
	 * 
	 * @throws AccessTokenException
	 */
	@Transactional
	@Override
	protected synchronized AccessToken refresh() throws AccessTokenException {
		if (get() == null || isNearlyExpired(get())) {
			// lockDb
			set(acquireAccessToken());
			// unlockDb
		}
		return get();
	}

	/**
	 * @return the accessTokenDao
	 */
	public AccessTokenDao getAccessTokenDao() {
		return accessTokenDao;
	}

	/**
	 * @param accessTokenDao
	 *            the accessTokenDao to set
	 */
	public void setAccessTokenDao(AccessTokenDao accessTokenDao) {
		this.accessTokenDao = accessTokenDao;
	}

}
