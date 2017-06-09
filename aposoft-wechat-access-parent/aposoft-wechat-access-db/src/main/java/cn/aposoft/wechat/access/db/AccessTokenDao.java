/**
 * 
 */
package cn.aposoft.wechat.access.db;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.aposoft.wechat.AccountId;
import cn.aposoft.wechat.CompanyAccountId;

/**
 * 根据公众号ID,读取AccessToken
 * 
 * @author Jann Liu
 *
 */
public interface AccessTokenDao {
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
	DbAccessToken getAccessToken(AccountId config);

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
	DbAccessToken getCompanyAccessToken(CompanyAccountId config);
}
