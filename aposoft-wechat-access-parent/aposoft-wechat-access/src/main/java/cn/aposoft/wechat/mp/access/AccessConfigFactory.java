/**
 * 
 */
package cn.aposoft.wechat.mp.access;

/**
 * 生成AccessTokenConfig的工厂类
 * 
 * @author Jann Liu
 *
 */
public interface AccessConfigFactory {
	AccessTokenConfig getAccessTokenConfig();

	AccessConfig getAccessConfig();
}
