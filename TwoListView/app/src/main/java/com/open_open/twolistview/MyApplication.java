package com.open_open.twolistview;

import android.app.Application;
import android.content.Context;

/******************************************
 * 类名称：MyApplication
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/6
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public class MyApplication extends Application {

    private static Context instance = null;

    public static Context getContext() {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
