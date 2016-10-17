/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

/**
 * @author LiuJian
 * @date 2016年10月17日
 * 
 */
public interface Picture extends Media {

    /**
     * 图片消息
     * 
     * @return 图片地址
     */
    public String getPicUrl();
}
