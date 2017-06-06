/**
 * 
 */
package cn.aposoft.wechat.access.db;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.aposoft.wechat.mp.access.AccessTokenConfig;
import cn.aposoft.wechat.mp.access.CompanyAccessTokenConfig;

/**
 * 根据公众号ID,读取AccessToken
 * 
 * @author Jann Liu
 *
 */
public interface AccessTokenDao {
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
	DbAccessToken getAccessToken(AccessTokenConfig config);

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
	DbAccessToken getCompanyAccessToken(CompanyAccessTokenConfig config);
}
