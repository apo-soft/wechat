/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.event;

/**
 * @author LiuJian
 * @date 2016年10月18日
 * 
 */
public interface MenuEvent extends Event {

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    public String getTicket();
}
