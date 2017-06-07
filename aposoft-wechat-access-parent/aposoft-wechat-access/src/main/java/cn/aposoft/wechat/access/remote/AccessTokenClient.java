/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.access.remote;

import java.io.Closeable;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.access.AccessTokenConfig;
import cn.aposoft.wechat.access.address.AddressConfig;

/**
 * Access Token 客户端
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public interface AccessTokenClient extends Closeable {
	/**
	 * 设置访问地址的Url信息
	 * 
	 * @param addressConfig
	 *            地址配置信息
	 */
	void setAddressConfig(AddressConfig addressConfig);

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
