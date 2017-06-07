/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 
 * @see java.net.URLDecoder
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class URLDecoder {

	/**
	 * Decodes a <code>application/x-www-form-urlencoded</code> string using a
	 * specific encoding scheme. The supplied encoding is used to determine what
	 * characters are represented by any consecutive sequences of the form
	 * "<code>%<i>xy</i></code>".
	 * <p>
	 * <em><strong>Note:</strong> The <a href=
	 * "http://www.w3.org/TR/html40/appendix/notes.html#non-ascii-chars"> World
	 * Wide Web Consortium Recommendation</a> states that UTF-8 should be used.
	 * Not doing so may introduce incompatibilites.</em>
	 * <p>
	 * the encoding defaults to UTF-8
	 * 
	 * @see java.net.URLDecoder#decode(String, String);
	 * @param s
	 *            the <code>String</code> to decode
	 * @param enc
	 *            The name of a supported
	 *            <a href="../lang/package-summary.html#charenc">character
	 *            encoding</a>.
	 * 
	 * @return the newly decoded <code>String</code>
	 * @exception UnsupportedEncodingException
	 *                If character encoding needs to be consulted, but named
	 *                character encoding is not supported
	 * @see URLEncoder#encode(java.lang.String, java.lang.String)
	 * @since 1.4
	 */
	public static String decode(String s) {
		try {
			return java.net.URLDecoder.decode(s, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			// this won't happen in fact
			return null;
		}
	}

	/**
	 * Decodes a <code>application/x-www-form-urlencoded</code> string using a
	 * specific encoding scheme. The supplied encoding is used to determine what
	 * characters are represented by any consecutive sequences of the form
	 * "<code>%<i>xy</i></code>".
	 * <p>
	 * <em><strong>Note:</strong> The <a href=
	 * "http://www.w3.org/TR/html40/appendix/notes.html#non-ascii-chars"> World
	 * Wide Web Consortium Recommendation</a> states that UTF-8 should be used.
	 * Not doing so may introduce incompatibilites.</em>
	 * 
	 * @see java.net.URLDecoder#decode(String, String);
	 * @param s
	 *            the <code>String</code> to decode
	 * @param enc
	 *            The name of a supported
	 *            <a href="../lang/package-summary.html#charenc">character
	 *            encoding</a>.
	 * @return the newly decoded <code>String</code>
	 * @exception UnsupportedEncodingException
	 *                If character encoding needs to be consulted, but named
	 *                character encoding is not supported
	 * @see URLEncoder#encode(java.lang.String, java.lang.String)
	 * @since 1.4
	 */
	public static String decode(String s, String enc) throws UnsupportedEncodingException {
		return java.net.URLDecoder.decode(s, enc);
	}
}
