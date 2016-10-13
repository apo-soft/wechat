/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cn.aposoft.wechat.mp.constant.Lexical;

/**
 * 
 * @see java.net.URLDecoder
 * @author LiuJian
 * @date 2016年10月13日
 * 
 */
public class URLDecoder {

    /**
     * 
     * @param s
     *            the <code>String</code> to decode
     * @return the newly decoded <code>String</code>
     */
    public static String decode(String s) {
        try {
            return java.net.URLDecoder.decode(s, Lexical.UTF8);
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
