package cn.aposoft.wechat.echo;

import cn.aposoft.wechat.signature.SignatureValidator;

/**
 * echostr验证接口
 * 
 * @author Jann Liu
 *
 */
public interface EchoValidator extends SignatureValidator {

	/**
	 * 是否包含echostr属性
	 */
	boolean hasEchostr(EchoAttributes attributes);

}