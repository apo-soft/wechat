/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import cn.aposoft.constant.Lexical;

/**
 * 对 java.net.URLEncoder的方法进行封装，重载 encode,decode 方法,固定使用UTF-8编码，而不是系统默认编码
 * 
 * @see java.net.URLEncoder
 * @author LiuJian
 * @date 2016年10月13日
 * 
 */
public class URLEncoder {

    /**
     * use UTF-8 character encoding to encode the input String
     * 
     * @see java.net.URLEncoder#encode(String,String)
     * @param s
     *            the input String for encoding
     * @return URL Encode String with UTF-8 character encoding
     */
    public static String encode(String s) {
        try {
            return java.net.URLEncoder.encode(s, Lexical.UTF8);
        } catch (UnsupportedEncodingException e) {
            // this won't happen in fact
            return null;
        }
    }

    /**
     * Translates a string into <code>application/x-www-form-urlencoded</code>
     * format using a specific encoding scheme. This method uses the supplied
     * encoding scheme to obtain the bytes for unsafe characters.
     * <p>
     * <em><strong>Note:</strong> The <a href=
     * "http://www.w3.org/TR/html40/appendix/notes.html#non-ascii-chars"> World
     * Wide Web Consortium Recommendation</a> states that UTF-8 should be used.
     * Not doing so may introduce incompatibilites.</em>
     *
     * @param s
     *            <code>String</code> to be translated.
     * @param enc
     *            The name of a supported
     *            <a href="../lang/package-summary.html#charenc">character
     *            encoding</a>.
     * @return the translated <code>String</code>.
     * @exception UnsupportedEncodingException
     *                If the named encoding is not supported
     * @see URLDecoder#decode(java.lang.String, java.lang.String)
     * @since 1.4
     */
    public static String encode(String s, String charset) throws UnsupportedEncodingException {
        return java.net.URLEncoder.encode(s, charset);
    }

}
