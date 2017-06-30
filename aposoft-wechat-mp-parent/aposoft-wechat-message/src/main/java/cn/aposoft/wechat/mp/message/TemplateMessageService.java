/**
 * 
 */
package cn.aposoft.wechat.mp.message;

import cn.aposoft.framework.io.QuietCloseable;
import cn.aposoft.framework.io.RemoteException;

/**
 * @author Jann Liu
 *
 */
public interface TemplateMessageService extends QuietCloseable {
	/**
	 * 读取模板列表
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @return 列表JSON表示
	 * @throws RemoteException
	 */
	public String getTemplateList(String accessToken) throws RemoteException;

	@Override
	public void close();
}
