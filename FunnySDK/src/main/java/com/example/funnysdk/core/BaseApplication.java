package com.example.funnysdk.core;

import android.app.Application;
import android.content.Context;




public class BaseApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        EventBus.init(getApplicationContext());
    }
}
