package org.scau.riotgame;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by ZP on 2017/8/8.
 */

public class RiotGameApplication extends Application {

    private static final String TAG = "RiotGameApplication";

    private static Context sContext;

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: ");
        super.onCreate();
        sContext = getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }
}
