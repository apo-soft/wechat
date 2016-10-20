/**
 *   Copyright  :  www.aposoft.cn
 */
package cn.aposoft.wechat.mp.auth;

import com.alibaba.fastjson.JSON;

import cn.aposoft.util.RemoteException;
import cn.aposoft.wechat.mp.auth.remote.Oauth2AccessTokenClient;
import cn.aposoft.wechat.mp.auth.remote.WechatUserInfoResp;

/**
 * @author LiuJian
 * @date 2016年10月15日
 * 
 */
public class UserInfoDemo {

    /**
     * @param args
     * @throws RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        try (Oauth2AccessTokenClient client = new Oauth2AccessTokenClient();) {
            // 刷新ACCESS_TOKEN
            WechatUserInfoResp resp = client.getUserInfo(
                    "F5cUe7IxN7ju-IIAVOB8LAO1GTbuneH3suHnaX-aYi03giklaG1uHVpQoHxdgljq4mf-E-6o1bUm2g87VCs7VRhCk4ffQKYHQ4l6-fLEjws",
                    "ojqOLxLh0480oz5gqHqLgzRgCLHM");

            System.out.println(JSON.toJSONString(resp));
        }
    }

}
