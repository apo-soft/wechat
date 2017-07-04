/**
 * 
 */
package cn.aposoft.wechat;

import cn.aposoft.framework.api.ApiResult;
import cn.aposoft.framework.api.BasicApiResult;

/**
 * @author Jann Liu
 *
 */
public class WechatResultUtil {
	public static ApiResult<?> convert(WechatResult result) {
		BasicApiResult<?> resp = new BasicApiResult<>(
				(result.getErrcode() == null ? ApiResult.ERROR : result.getErrcode()), result.getErrmsg());
		return resp;

	}
}
