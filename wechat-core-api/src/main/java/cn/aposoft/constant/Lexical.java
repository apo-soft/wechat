/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.constant;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 通用词汇常量
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 */
public class Lexical {
	/**
	 * UTF-8 Character encoding
	 * 
	 * @deprecated use {@link StandardCharsets.UTF_8} instead
	 */
	public static final Charset UTF8_CHARSET = StandardCharsets.UTF_8;
	/**
	 * UTF-8
	 */
	public static final String UTF8 = UTF8_CHARSET.displayName();
	/**
	 * JSON : "json"
	 */
	public static final String JSON = "json";
}
