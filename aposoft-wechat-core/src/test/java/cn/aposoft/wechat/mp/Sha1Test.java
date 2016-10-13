package cn.aposoft.wechat.mp;

import org.junit.Test;

import cn.aposoft.wechat.mp.codec.aes.AesException;
import cn.aposoft.wechat.mp.codec.digest.DigestUtils;

public class Sha1Test {

    /**
     * @throws AesException
     * 
     */
    @Test
    public void testSha1Digest() throws AesException {
        String a1 = "333";
        String a2 = "444";
        String a3 = "bbb";
        String a4 = "ccc";

        String sigResult = DigestUtils.sha1Hex(a1, a2, a3, a4);
        System.out.println(sigResult);
    }
}
