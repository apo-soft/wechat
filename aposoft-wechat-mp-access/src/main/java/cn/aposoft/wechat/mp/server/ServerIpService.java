/**
 * 
 */
package cn.aposoft.wechat.mp.server;

import java.io.Closeable;
import java.util.List;

import cn.aposoft.util.RemoteException;

/**
 * 读取服务器IP列表
 * 
 * @author Jann Liu
 *
 */
public interface ServerIpService extends Closeable {
	/**
	 * 读取服务器IP列表
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @return 服务器IP列表
	 * @throws RemoteException
	 */
	List<String> getIpList(final String accessToken) throws RemoteException;

	@Override
	void close();
}
