/**
 * 
 */
package cn.aposoft.wechat.config;

/**
 * Wechat的配置持久化存储格式
 * <p>
 * 兼容对MP账号和企业应用号的配置信息的存储
 * 
 * @author Jann Liu
 * @since 1.0
 */
public interface WechatConfig extends WechatMpConfig, WechatCompanyConfig {
	
}
