package com.example.funnysdk.core;

/**
 * Description
 * Created by Administrator
 * Time 2017/12/9  17:37
 */

//标志位
public interface PlatformModules {
    String MODULE_LOGIN = "FunnySDK/funny_login";
    String MODULE_GP= "GooglePlayServer/gp_login";
    //...省略 GooglePlayServer 其他的页面标志
    String MODULE_FB= "FacebookServer/fb_login";
    String MODULE_TEST= "TestServer/test";
    //...省略 FacebookServer 其他的页面标志
}
