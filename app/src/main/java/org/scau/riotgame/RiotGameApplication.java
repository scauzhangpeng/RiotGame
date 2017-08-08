package org.scau.riotgame;

import android.app.Application;
import android.content.Context;

/**
 * Created by ZP on 2017/8/8.
 */

public class RiotGameApplication extends Application {

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
