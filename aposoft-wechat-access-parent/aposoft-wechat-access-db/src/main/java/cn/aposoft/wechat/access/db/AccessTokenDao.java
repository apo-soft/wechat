/**
 * 
 */
package cn.aposoft.wechat.access.db;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.aposoft.wechat.AccountId;
import cn.aposoft.wechat.CompanyAccountId;
import cn.aposoft.wechat.access.AccessToken;

/**
 * 根据公众号ID,读取AccessToken
 * 
 * @author Jann Liu
 *
 */
public interface AccessTokenDao {
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
	AccessToken getAccessToken(AccountId accountId);

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
	AccessToken getCompanyAccessToken(CompanyAccountId accountId);
}
