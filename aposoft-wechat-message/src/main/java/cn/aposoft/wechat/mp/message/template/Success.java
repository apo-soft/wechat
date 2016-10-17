/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template;

import cn.aposoft.wechat.mp.message.impl.AposoftMessage;

/**
 * 默认返回success，表示没有应答
 * 
 * @author LiuJian
 * @date 2016年10月16日
 * 
 */
public class Success extends AposoftMessage {
    private static final long serialVersionUID = -3539209971606525121L;
    private static final Success success = new Success();

    /**
     * 获取success的默认实例
     * 
     * @return
     */
    public static Success getInstance() {
        return success;
    }

    @Override
    public String toString() {
        return "success";
    }
}
