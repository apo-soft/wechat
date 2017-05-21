/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.access;

import com.alibaba.fastjson.JSON;

import cn.aposoft.wechat.mp.access.AccessToken;
import cn.aposoft.wechat.mp.access.AccessTokenService;
import cn.aposoft.wechat.mp.access.impl.BasicAccessTokenService;
import cn.aposoft.wechat.mp.access.remote.AccessTokenClient;

/**
 * Access_Token Client 测试用例
 * @author Jann Liu
 * @date 2016年10月13日
 * 
 */
public class AccessTokenServiceDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AccessTokenClient client = new AccessTokenClient();
        AccessTokenService accessTokenService = new BasicAccessTokenService(client);
        for (int i = 0; i < 200; i++) {
            AccessToken accessToken = accessTokenService.getAccessToken();
            System.out.println(JSON.toJSONString(accessToken));

            // try {
            // Thread.sleep(1000);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
        }
    }
}
