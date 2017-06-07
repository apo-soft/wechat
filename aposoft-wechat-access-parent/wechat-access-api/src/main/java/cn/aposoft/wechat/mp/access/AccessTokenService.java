package cn.aposoft.wechat.mp.access;

import java.io.Closeable;

/**
 * Access访问的实际服务接口，保证返回有效的AccessToken
 * 
 * @author Jann Liu
 * @date 2016年10月12日
 *
 */
public interface AccessTokenService extends Closeable {

	AccessTokenConfig getConfig();

	/**
	 * 读取默认的AccessToken
	 * 
	 * @return AccessToken
	 * 
	 * @throws AccessTokenException
	 */
	AccessToken getAccessToken() throws AccessTokenException;

	@Override
	public void close();
}
