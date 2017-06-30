/**
 * 
 */
package org.aposoft.wechat.company.managemnt.user;

import cn.aposoft.framework.io.QuietCloseable;
import cn.aposoft.framework.io.RemoteException;
import cn.aposoft.wechat.WechatResp;

/**
 * 用户管理服务
 * 
 * @author Jann Liu
 *
 */
public interface UserAuthsuccService extends QuietCloseable {
	/**
	 * 确认企业用户关注成功
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param userid
	 *            用户id
	 * @return 确认结果
	 */
	WechatResp authsucc(final String accessToken, final String userid) throws RemoteException;

	void close();
}