/**
 * 
 */
package cn.aposoft.wechat;

import java.io.Serializable;

/**
 * 微信用户验证基础响应消息
 * 
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public interface WechatResult extends Serializable {
	/**
	 * 
	 * @return 微信返回值错误编码
	 */
	public Integer getErrcode();

	/**
	 * 
	 * @return 微信返回值响应报文
	 */
	public String getErrmsg();
}
