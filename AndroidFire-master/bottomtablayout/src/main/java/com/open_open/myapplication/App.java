package com.open_open.myapplication;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/******************************************
 * 类名称：App
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
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
