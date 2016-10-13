package cn.aposoft.wechat.mp.access;

/**
 * Access访问的实际服务接口，保证返回有效的AccessToken
 * 
 * @author LiuJian
 * @date 2016年10月12日
 *
 */
public interface AccessTokenService {
    AccessToken getAccessToken();
}
