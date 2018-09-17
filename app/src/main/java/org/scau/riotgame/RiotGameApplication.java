package org.scau.riotgame;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;

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
        initARouter();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {
            // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As early as possible, it is recommended to initialize in the Application
    }

    public static Context getContext() {
        return sContext;
    }
}
