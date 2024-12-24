package com.study_demo;

import com.doudian.open.core.AccessToken;
import com.doudian.open.core.AccessTokenBuilder;
import com.doudian.open.core.GlobalConfig;

public class TokenConfig {

    static {
        //设置appKey和appSecret，全局设置一次
        GlobalConfig.initAppKey("7450825832362198538");
        GlobalConfig.initAppSecret("4fd27f78-863b-4923-9c00-6f1e1a577eb3");
    }

    public static AccessToken getAccessToken(Long shopId) {
        return AccessTokenBuilder.build(shopId);
    }
}