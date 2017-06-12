/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.access;

import java.util.Date;

/**
 * 微信AccessToken记录
 * 
 * <pre>
 * {"access_token":"n9mXYfPZ3-LQ3c2mhTs3qYsTg60Yhr203GOoMyfMVF2UtkQD0vM4okY1J7aoy1xB1UfiXD_xEPNvEnJkesHL-1d_niPQIFkpFIADMU2k1Kc9kZxngD6RSeJpwrxZS1GaMYHhACAIUD","expires_in":7200}
 * </pre>
 * 
 * @author Jann Liu
 * @date 2016年10月12日
 * @since 1.0
 */
public interface AccessToken {
	/**
	 * Access_token 实际值,微信返回
	 * 
	 * @return 微信提供的Access_token 有效值字符串
	 */
	public String getAccess_token();

	/**
	 * 微信提供的超时时间*秒
	 * 
	 * @return 超时时间
	 */
	public int getExpires_in();

	/**
	 * 刷新token时间,服务器本地计时
	 * 
	 * @return 服务器本地计时刷新时间
	 */
	public Date getRefreshTime();
}
