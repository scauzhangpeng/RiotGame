package com.xyz.basiclib;

import android.app.Application;
import android.content.Context;

/**
 * Created by ZP on 2018/12/3.
 */
public class BaseApplication extends Application {

    private static Context sContext;


    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }
}
