package cn.aposoft.wechat.access;

import java.io.Closeable;

/**
 * Access访问的实际服务接口，保证返回有效的AccessToken
 * <p>
 * 此服务适用于公众号和服务号的单体应用
 * 
 * @author Jann Liu
 * @date 2016年10月12日
 * @since 1.0
 */
public interface AccessTokenService extends Closeable {

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
