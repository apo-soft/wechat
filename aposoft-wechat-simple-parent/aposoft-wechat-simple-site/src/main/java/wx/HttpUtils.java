/**
 *   Copyright  :  www.aposoft.cn
 */
package wx;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public class HttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static void printHeaders(HttpServletRequest request) {

        Enumeration<String> headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {
            String name = headers.nextElement();
            Enumeration<String> headerArr = request.getHeaders(name);
            StringBuilder builder = new StringBuilder();
            builder.append(name).append(":");
            while (headerArr.hasMoreElements()) {
                builder.append(headerArr.nextElement());
            }

            logger.debug(builder.toString());
        }
    }

    public static void printParams(HttpServletRequest request) {

        Enumeration<String> params = request.getParameterNames();

        while (params.hasMoreElements()) {
            String name = params.nextElement();
            String[] values = request.getParameterValues(name);
            StringBuilder builder = new StringBuilder();
            builder.append(name).append(":").append(StringUtils.join(values));

            logger.debug(builder.toString());
        }
    }

}
