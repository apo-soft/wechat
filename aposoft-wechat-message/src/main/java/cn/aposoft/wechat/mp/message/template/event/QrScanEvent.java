/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.event;

/**
 * 二维码扫描事件
 * 
 * @author Jann Liu
 * @date 2016年10月18日
 * 
 */
public interface QrScanEvent extends Event {

    /**
     * 事件KEY值 扫描带参数二维码事件：
     * <p>
     * 1. 用户未关注时，进行关注后的事件推送 qrscene_为前缀，后面为二维码的参数值
     * <p>
     * 2. 用户已关注时的事件推送 是一个32位无符号整数，即创建二维码时的二维码scene_id
     * <p>
     * 自定义菜单事件
     * <p>
     * 点击菜单跳转链接时的事件推送 3. 事件KEY值，设置的跳转URL
     * <p>
     * 4. 事件KEY值，与自定义菜单接口中KEY值对应
     */
    public String getEventKey();

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    public String getTicket();
}
