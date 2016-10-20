/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.util;

import org.apache.http.StatusLine;

/**
 * HTTP响应状态异常，不为StatusCode!=SC_OK
 * 
 * @author LiuJian
 * @date 2016年10月13日
 * 
 */
public class HttpStatusException extends RemoteException {
    private static final long serialVersionUID = -1031593768318055988L;
    private StatusLine httpStatusLine;

    /**
     * 
     * @param httpStatusLine
     *            异常请求的StatusLine
     */
    public HttpStatusException(StatusLine httpStatusLine) {
        this.httpStatusLine = httpStatusLine;
    }

    /**
     * 异常的HttpStatusLine
     */
    public StatusLine getHttpStatusLine() {
        return this.httpStatusLine;
    }

}
