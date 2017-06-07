/**
 * 
 */
package cn.aposoft.wechat.access;

/**
 * 访问授权密钥
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface AccessSecret {
	/**
	 * Secret 适用于公众号,服务号,企业号
	 * 
	 * @return secret密文
	 */
	public String getSecret();
}
