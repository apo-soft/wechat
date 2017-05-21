/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.codec.digest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 微信通用的sha1签名算法实现工具
 * 
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class DigestUtils {
    /**
     * 微信通用的sha1签名算法
     * 
     * @param params
     *            待签名的字符串数组
     * @return 签名后字符串
     */
    public static String toSha1Hex(final List<String> params) {
        Collections.sort(params);
        String rawSigText = StringUtils.join(params, "");
        String sigResult = org.apache.commons.codec.digest.DigestUtils.sha1Hex(rawSigText);
        return sigResult;
    }

    /**
     * 微信通用的sha1签名算法
     * 
     * @param params
     *            待签名的字符串数组
     * @return 签名后字符串
     */
    public static String sha1Hex(String... params) {
        Arrays.sort(params);
        String rawSigText = StringUtils.join(params, "");
        String sigResult = org.apache.commons.codec.digest.DigestUtils.sha1Hex(rawSigText);
        return sigResult;
    }

    /**
     * 微信通用的sha1签名算法
     * 
     * @param params
     *            待签名的字符串数组
     * @return 签名后字符串
     */
    public static String sha1Hex(final List<String> params) {
        Collections.sort(params);
        String rawSigText = StringUtils.join(params, "");
        String sigResult = org.apache.commons.codec.digest.DigestUtils.sha1Hex(rawSigText);
        return sigResult;
    }

    /**
     * 微信通用的sha1签名算法
     * 
     * @param params
     *            待签名的字符串数组
     * @return 签名后字符串
     */
    public static String sha1Hex(final String data) {
        return org.apache.commons.codec.digest.DigestUtils.sha1Hex(data);
    }

}
