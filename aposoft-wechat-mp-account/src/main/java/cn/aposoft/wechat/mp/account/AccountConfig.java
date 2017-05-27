/**
 * 
 */
package cn.aposoft.wechat.mp.account;

/**
 * 公众号临时二维码有效时间配置
 * 
 * @author Jann Liu
 *
 */
public interface AccountConfig {
	/**
	 * 
	 * @return 默认的过期时间 (30s)
	 */
	public int getDefaultExpireSecounds();

	/**
	 * 
	 * @return 最大可配置过期时间 (30天 = 2592000s)
	 */
	public int getMaxExpireSecounds();

}
