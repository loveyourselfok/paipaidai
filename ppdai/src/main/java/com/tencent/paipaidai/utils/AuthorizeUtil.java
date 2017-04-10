package com.tencent.paipaidai.utils;

import com.ppdai.open.core.AuthInfo;
import com.ppdai.open.core.OpenApiClient;
import com.ppdai.open.core.RsaCryptoHelper;

/**
 *
 */

public class AuthorizeUtil {

    // 服务端公钥
    private static final String serverPublicKey="your_public_key";
    // 客户端私钥
    private static final  String clientPrivateKey = "your_private_key";
    // 应用ID
    private static final String appid="your_appid";
    //AccessToken
    private static final String  accessToken = "your_accesstoken";
    /**
     * 用户授权登录获取accesstoken
     * @param code
     * @return
     * @throws Exception
     */
    public static String getAccessToken(String code) throws Exception {
        //仅初始化一次即可
        OpenApiClient.Init(appId, RsaCryptoHelper.PKCSType.PKCS8, serverPublicKey, clientPrivateKey);
        //授权信息
        AuthInfo authInfo = OpenApiClient.authorize(code);
        //获取accessToken
        String accessToke = authInfo.getAccessToken();
        return accessToke;
    }
}
