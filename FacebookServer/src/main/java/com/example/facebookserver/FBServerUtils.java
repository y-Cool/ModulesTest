package com.example.facebookserver;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.funnysdk.core.FunnyTaskDistribution;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;

public class FBServerUtils implements FunnyTaskDistribution {
    private static CallbackManager callbackManager;
    public static CallbackManager callFB(Context context)throws Exception{
        try {
            callbackManager = CallbackManager.Factory.create();
            Toast.makeText(context, "获取FB实例成功 ： "+callbackManager.toString(), Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(context, "获取FB实例失败 ： ", Toast.LENGTH_LONG).show();
            Log.e("获取FB实例失败：",e.getMessage());
        }
        return callbackManager;
    }

    @Override
    public void distribution(Context context, String flag, Object... objects) {
        if(flag.endsWith("fb_login")){
            Toast.makeText(context, "FB_ServerUtils call Successful", Toast.LENGTH_SHORT).show();
            try {
                callFB(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            Intent intent = new Intent(context, ModuleTwoActivity.class);
//            context.startActivity(intent);
        }
    }
}
