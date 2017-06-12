/**
 * 
 */
package cn.aposoft.wechat.mp.csa;

import java.io.Closeable;
import java.util.List;

import cn.aposoft.wechat.RemoteException;
import cn.aposoft.wechat.WechatResp;

/**
 * 
 * 客服管理模块
 * 
 * @author liuya
 *
 */
public interface CustomServiceAgentService extends Closeable {
	/**
	 * 新增客服
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param account
	 *            客服账号
	 * @return 新增处理结果
	 * @throws RemoteException
	 */
	WechatResp add(String accessToken, AgentAccount account) throws RemoteException;

	/**
	 * 更新客服
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param account
	 *            客服账号
	 * @return 更新处理结果
	 * @throws RemoteException
	 */
	WechatResp update(String accessToken, AgentAccount account) throws RemoteException;

	/**
	 * 刪除客服
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param account
	 *            客服账号
	 * @return 删除处理结果
	 * @throws RemoteException
	 */
	WechatResp delete(String accessToken, AgentAccount account) throws RemoteException;

	/**
	 * 读取客服列表
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @return 客服列表
	 */
	List<AgentAccount> getAgentList(String accessToken) throws RemoteException;

	/**
	 * 上传头像
	 * 
	 * @param accessToken
	 *            访问授权码
	 * @param account
	 *            客服账号
	 * @param image
	 *            头像内容
	 * @return 上传处理结果
	 * @throws RemoteException
	 */
	WechatResp uploadHeadImg(final String accessToken, final AgentAccount account, byte[] image) throws RemoteException;

	/**
	 * 重写close方法, 取消抛出异常
	 */
	void close();
}
