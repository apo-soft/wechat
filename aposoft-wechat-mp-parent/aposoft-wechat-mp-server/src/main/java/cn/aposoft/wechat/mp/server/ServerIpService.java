/**
 * 
 */
package cn.aposoft.wechat.mp.server;

import java.util.List;

import cn.aposoft.framework.io.QuietCloseable;
import cn.aposoft.framework.io.RemoteException;

/**
 * 读取服务器IP列表
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface ServerIpService extends QuietCloseable {
	/**
	 * 读取服务器IP列表
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @return 服务器IP列表
	 * @throws RemoteException
	 */
	List<String> getIpList(final String accessToken) throws RemoteException;

}
