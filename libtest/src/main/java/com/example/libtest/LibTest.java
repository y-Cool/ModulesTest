package com.example.libtest;

import android.content.Context;
import android.widget.Toast;

import com.example.funnysdk.core.FunnyTaskDistribution;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class LibTest implements FunnyTaskDistribution {
    public static void libTest(Context context){
        Toast.makeText(context, "libTest call", Toast.LENGTH_SHORT).show();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .build();
    }

    @Override
    public void distribution(Context context, String flag, Object... objects) {
        if(flag.endsWith("test")){
            Toast.makeText(context, "FB_ServerUtils call Successful", Toast.LENGTH_SHORT).show();
           ;

        }
    }
}
