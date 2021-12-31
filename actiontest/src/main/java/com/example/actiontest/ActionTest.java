package com.example.actiontest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ActionTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "ActionTest", Toast.LENGTH_SHORT).show();
    }
}
