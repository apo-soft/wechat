/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.access;

import cn.aposoft.framework.io.QuietCloseable;
import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.access.address.AddressConfig;
import cn.aposoft.wechat.config.AccountConfig;

/**
 * Access Token 客户端
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 * @since 1.0
 */
public interface AccessTokenClient extends QuietCloseable {
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
	AccessTokenResp getAccessToken(AccountConfig config) throws RemoteException;
	/**
	 * 释放资源
	 */
	@Override
	public void close();
}
