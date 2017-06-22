/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.codec.aes;

import cn.aposoft.wechat.codec.aes.AesException;
import cn.aposoft.wechat.codec.aes.WXBizMsgCrypt;

/**
 * 加密解密测试
 * 
 * @author Jann Liu
 * @date 2016年10月18日
 * 
 */
public class WXBizMsgCryptTest {

    /**
     * @param args
     * @throws AesException
     */
    public static void main(String[] args) throws AesException {
        WXBizMsgCrypt crypt = new WXBizMsgCrypt("AposoftBugs", "rqWzZv5rjyBwIRmociz7978G2O1D8sjxlsypVIU4SmY", "wx31659662068251dc");

//        String decryptMsg = crypt.decryptMsg("ba1ba3bd7c6557429694d2dd24bb2e5291b107f0", "1476782372351", "5590981212708417", "<xml>" + "<Encrypt>" +
//
//                "<![CDATA[KoJPQOmpUdA/FCBoHRV2/FpcuBvyv1kFvHJJesRw/YoVZCORacfcEogcWAyVQYUYsM3TmCl/KzmkkFgAqYpzBA==]]>" + "</Encrypt>"
//                + "<MsgSignature>" + "<![CDATA[ba1ba3bd7c6557429694d2dd24bb2e5291b107f0]]>" + "</MsgSignature>"
//                + "<TimeStamp>1476782372351</TimeStamp>" + "<Nonce>" + "<![CDATA[5590981212708417]]>" + "</Nonce>" + "</xml>");

        String message = crypt.decrypt("KoJPQOmpUdA/FCBoHRV2/FpcuBvyv1kFvHJJesRw/YoVZCORacfcEogcWAyVQYUYsM3TmCl/KzmkkFgAqYpzBA==");
        System.out.println(message);
    }

}
