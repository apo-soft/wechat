/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user;

import java.io.Closeable;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.remote.WechatResponse;

/**
 * 企业号管理成员
 * 
 * @see http://qydev.weixin.qq.com/wiki/index.php?title=%E7%AE%A1%E7%90%86%E6%88%90%E5%91%98
 * @author Jann Liu
 *
 */
public interface UserManagementService extends Closeable {

	WechatResponse create(final String accessToken, final User user) throws RemoteException;

	WechatResponse update(final String accessToken, final User user) throws RemoteException;

	WechatResponse delete(final String accessToken, final String userid) throws RemoteException;

	UserResp get(final String accessToken, final String userid) throws RemoteException;

	UserListResp get(final String accessToken, final int departmentId, final int fetchChild, final int status)
			throws RemoteException;

	UserListResp getDetail(final String accessToken, final int departmentId, final int fetchChild, final int status)
			throws RemoteException;

	@Override
	void close();
}
