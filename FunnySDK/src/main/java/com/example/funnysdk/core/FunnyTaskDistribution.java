package com.example.funnysdk.core;

import android.content.Context;

public interface FunnyTaskDistribution {
    void distribution(Context context, String flag, Object... objects);
}
