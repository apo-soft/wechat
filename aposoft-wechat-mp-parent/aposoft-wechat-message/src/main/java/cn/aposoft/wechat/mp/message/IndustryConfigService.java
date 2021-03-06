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
public interface IndustryConfigService extends QuietCloseable {

	/**
	 * 设置行业ID
	 * 
	 * @param industryId1
	 *            行业1ID
	 * @param industryId2
	 *            行业2ID
	 * @throws RemoteException
	 */
	public void setIndustry(String accessToken, String industryId1, String industryId2) throws RemoteException;

	/**
	 * 查询行业信息
	 * 
	 * @param accessToken
	 *            授权访问码
	 * @return 行业信息字符串
	 * @throws RemoteException
	 */
	public String getIndustry(String accessToken) throws RemoteException;



}
