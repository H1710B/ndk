package com.example.thinkpad.zhongkao;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class App extends Application {
    public static AppCompatActivity mActivity;
    public static Fragment mLastFragment;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }


    public static Context getContext() {
        return context;
    }

}
