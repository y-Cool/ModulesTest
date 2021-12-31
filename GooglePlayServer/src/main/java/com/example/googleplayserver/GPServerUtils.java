package com.example.googleplayserver;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.funnysdk.core.CommonUtils;
import com.example.funnysdk.core.FunnyTaskDistribution;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class GPServerUtils implements FunnyTaskDistribution {
    private static GoogleSignInOptions gso;
    public static GoogleSignInOptions callGP(Context context){
        try {

            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .build();
            Toast.makeText(context, "获取GP实例成功 : "+gso.toString(), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.e("获取GP实例失败：",e.getMessage());
            Toast.makeText(context, "获取GP实例失败", Toast.LENGTH_SHORT).show();
        }
        return gso;
    }
    public String callCommonUtils(){
        return CommonUtils.commonLoginUtil();
    }

    @Override
    public void distribution(Context context, String flag, Object... objects) {
        if(flag.endsWith("gp_login")){
            Toast.makeText(context, "GP_ServerUtils call Successful", Toast.LENGTH_SHORT).show();
            callGP(context);
            Intent intent = new Intent("com.vrphogame.thyroidapp0716.ACTION_START");
            intent.addCategory("com.vrphogame.thyroidapp0716.LOGIN_ACTIVITY");
            context.startActivity(intent);
//            Intent intent = new Intent(context, ModuleTwoActivity.class);
//            context.startActivity(intent);
        }
    }
}
