/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.message;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.XmlUtils;
import cn.aposoft.wechat.mp.message.template.received.Text;

/**
 * @author Jann Liu
 * @date 2016年10月14日
 * 
 */
public class JaxbXmlTest {

    /**
     * @param args
     * @throws JAXBException
     * @throws IOException
     * @throws SAXException
     */
    public static void main(String[] args) throws JAXBException, SAXException, IOException {
        String xml = "<xml>" + "<ToUserName><![CDATA[toUser]]></ToUserName>" + "<FromUserName><![CDATA[fromUser]]></FromUserName>"
                + "<CreateTime>1348831860</CreateTime>" + "<MsgType><![CDATA[text]]></MsgType>" + "<Content><![CDATA[this is a test]]></Content>"
                + "<MsgId>1234567890123456</MsgId>" + "</xml>";

        Text t1 = XmlUtils.xml2Object(xml, Text.class);
        System.out.println(JSON.toJSONString(t1));
    }

}
