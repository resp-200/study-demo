package com.study_demo;

import com.doudian.open.core.AccessToken;
import com.doudian.open.core.AccessTokenBuilder;
import com.doudian.open.core.GlobalConfig;

public class TokenConfig {

    static {
        //设置appKey和appSecret，全局设置一次
        GlobalConfig.initAppKey("");
        GlobalConfig.initAppSecret("");
    }

    public static AccessToken getAccessToken(Long shopId) {
        return AccessTokenBuilder.build(shopId);
    }
}