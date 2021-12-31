package com.example.modulestest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.funnysdk.core.EventBus;
import com.example.funnysdk.core.PlatformModules;

public class MainActivity extends AppCompatActivity {
    private EditText platformEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        platformEdit = findViewById(R.id.platformEdit);

        findViewById(R.id.btn1).setOnClickListener(v -> {
            EventBus.InitFunnySDKUtil(MainActivity.this, PlatformModules.MODULE_GP);
        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
            EventBus.InitFunnySDKUtil(MainActivity.this, PlatformModules.MODULE_FB);
        });
        findViewById(R.id.btn5).setOnClickListener(v -> {
            EventBus.InitFunnySDKUtil(MainActivity.this,PlatformModules.MODULE_TEST);
        });

        findViewById(R.id.btn3).setOnClickListener(v -> {
            String platformValue = platformEdit.getText().toString();
            EventBus.InitFunnySDKUtil(MainActivity.this, platformValue);

        });
    }
}