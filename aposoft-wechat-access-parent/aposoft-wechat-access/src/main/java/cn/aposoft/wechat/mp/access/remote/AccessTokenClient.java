/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.access.remote;

import java.io.Closeable;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.mp.access.AccessTokenConfig;

/**
 * Access Token 客户端
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public interface AccessTokenClient extends Closeable {
	/**
	 * 读取远程AccessToken
	 * 
	 * @param config
	 *            {@link AccessTokenConfig}
	 * @return {"access_token":"d_uqUS_Abt-TcKDpuZj-FLkWOe54nrvZbBKuJwXN2d9Qk67OMQHuwZ9MAFRN2plB","expires_in":7200}
	 * @throws RemoteException
	 */
	AccessTokenResp getAccessToken(AccessTokenConfig config) throws RemoteException;

	@Override
	public void close();
}
