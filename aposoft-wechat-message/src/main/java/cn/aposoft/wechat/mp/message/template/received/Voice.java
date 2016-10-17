/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.message.template.received;

/**
 * @author LiuJian
 * @date 2016年10月17日
 * 
 */
public interface Voice extends Media {
    /**
     * 语音格式类型
     * 
     * @return 语音格式
     */
    public String getFormat();

    /**
     * 语音识别信息
     * 
     * @return 识别结果
     */
    public String getRecongnition();
}
