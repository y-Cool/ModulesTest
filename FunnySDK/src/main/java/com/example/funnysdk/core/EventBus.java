package com.example.funnysdk.core;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Description  用于获取模块转发器的类名 事件分发类，根据 platform 去跳转不同的界面
 * Created by Administrator
 * Time 2017/12/9  18:20
 */


public class EventBus {
    private static HashMap<String, String> hashMap = new HashMap<>();
    private static FunnyTaskDistribution funnyTaskDistribution;
    private static Context mContext;

    //保存包名
    public static void init(Context context) {
        hashMap.put("gp_sever", "com.example.googleplayserver.GPServerUtils");
        hashMap.put("fb_server", "com.example.facebookserver.FBServerUtils");
        hashMap.put("test_server", "com.example.libtest.LibTest");
    }

    private static void getTaskDistribution(String flag) {
        Class c = null;
        try {

            if (flag != null && flag.startsWith("GooglePlayServer")) {
                c = Class.forName(hashMap.get("gp_sever"));
                //todo 跳转 gp 唤起登陆页的逻辑
            }
            if (flag != null && flag.startsWith("FacebookServer")) {
                c = Class.forName(hashMap.get("fb_server"));
            }
            if (flag != null && flag.startsWith("TestServer")) {
                c = Class.forName(hashMap.get("test_server"));
            }
            if (c != null) {
                funnyTaskDistribution = (FunnyTaskDistribution) c.newInstance();
                Toast.makeText(mContext, c.getName(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (flag.startsWith("GooglePlayServer")) {
                Toast.makeText(mContext, "未依赖 谷歌 登陆", Toast.LENGTH_SHORT).show();
            }else if (flag.startsWith("FacebookServer")) {
                Toast.makeText(mContext, "未依赖 脸书 登陆", Toast.LENGTH_SHORT).show();
            }else if (flag.startsWith("TestServer")) {
                Toast.makeText(mContext, "未依赖 TestServer 登陆", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(mContext, "请填写正确的 platform value", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void InitFunnySDKUtil(Context context, String flag, Object... objects) {
        mContext = context;
        getTaskDistribution(flag);
        try {
            funnyTaskDistribution.distribution(context, flag, objects);
        } catch (Exception e) {
        }
    }

    public static void testCallByReflection(Context context) {

    }
}
