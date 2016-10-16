/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.codec;

/**
 * 微信加密解密类型： 只有raw和aes两种值
 * 
 * @author LiuJian
 * @date 2016年10月16日
 * 
 */
public enum EncryptType {
    RAW("raw"), AES("aes");

    private String type;

    private EncryptType(String type) {
        this.type = (type);
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

}
