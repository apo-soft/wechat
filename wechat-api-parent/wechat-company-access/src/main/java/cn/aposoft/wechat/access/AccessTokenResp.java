/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.access;

import java.util.Date;

import cn.aposoft.wechat.WechatResp;
import cn.aposoft.wechat.WechatResult;

/**
 * 
 * 请求微信接口的响应参数集合
 * 
 * 参数集合声明：
 * 
 * <pre>
 * <a href=
"https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&lang=zh_CN"> 获取access_token </a>
 * </pre>
 * 
 * <pre>
 * 	{
   		"access_token": "accesstoken000001",
   		"expires_in": 7200
	}
 * </pre>
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 * @since 1.0
 */
public class AccessTokenResp extends WechatResp implements WechatResult {
	private static final long serialVersionUID = 726644249402378769L;
	private String access_token;
	private Integer expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * 
	 * @return 转换为AccessToken
	 */
	public AccessToken toToken() {
		BasicAccessToken token = new BasicAccessToken();
		token.setAccess_token(this.access_token);
		token.setExpires_in(this.expires_in);
		token.setRefreshTime(new Date());
		return token;
	}

	@Override
	public String toString() {
		if (getErrcode() == null) {
			return access_token;
		} else {
			return super.toString();
		}
	}
}
