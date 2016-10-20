/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.util;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringUtils;

/**
 * Xml to Java Bean 转换
 * 
 * @author LiuJian
 * @date 2016年10月14日
 * 
 */
public class XmlUtils {

    private static Map<Class<?>, Unmarshaller> marshallerMap = new HashMap<>();

    public static <T> T xml2Object(String xml, Class<T> c) throws JAXBException {
        if (StringUtils.isBlank(xml)) {
            return null;
        }
        Unmarshaller unmarshaller = getMarshaller(c);
        @SuppressWarnings("unchecked")
        T t = (T) unmarshaller.unmarshal(new StringReader(xml));
        return t;
    }

    private static Unmarshaller getMarshaller(Class<?> c) throws JAXBException {
        if (marshallerMap.containsKey(c)) {
            return marshallerMap.get(c);
        } else {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            marshallerMap.put(c, unmarshaller);
            return unmarshaller;
        }
    }

}
