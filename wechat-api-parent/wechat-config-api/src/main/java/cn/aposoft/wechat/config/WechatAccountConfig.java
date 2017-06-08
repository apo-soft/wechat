/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.config;

import java.io.Serializable;

import cn.aposoft.wechat.access.AccessTokenConfig;
import cn.aposoft.wechat.access.AccountConfig;
import cn.aposoft.wechat.access.AccountType;
import cn.aposoft.wechat.access.AccountTypeAware;
import cn.aposoft.wechat.access.RefreshConfig;
import cn.aposoft.wechat.signature.SignatureConfig;

/**
 * 微信公众号配置
 * 
 * @author Jann Liu
 * @date 2016年10月12日
 * @since 1.0
 */
public interface WechatAccountConfig extends AccountTypeAware, Serializable {
	/**
	 * 
	 * @return 账户类型
	 */
	AccountType getAccountType();

	/**
	 * 用户ID:开发者微信ID <br/>
	 * gh_0f504b63df22
	 */
	String getUserId();

	/**
	 * 微信公众号APPID wx31659662068251dc<br/>
	 * corpId
	 * 
	 */
	String getId();

	/**
	 * 微信AppSecret <br/>
	 * 9cf9858af4718fde40d67968b5de3967
	 */
	String getSecret();

	/**
	 * Token 自定义的 Token AposoftBugs
	 */
	String getToken();

	/**
	 * EncodingAESKey (消息加解密密钥) 43位
	 */
	String getEncodingAESKey();

	/**
	 * 
	 * @return 会话过期时间保护
	 */
	int getExpiredThreshold();

	/**
	 * @return 回话过期阻塞时间
	 */
	int getHoldonThreshold();

	AccountConfig toAccountConfig();

	AccessTokenConfig toAccessTokenConfig();

	SignatureConfig toSignatureConfig();

	RefreshConfig toRefreshConfig();
}
