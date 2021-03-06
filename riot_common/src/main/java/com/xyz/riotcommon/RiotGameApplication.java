package com.xyz.riotcommon;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.xyz.basiclib.BaseApplication;
import com.xyz.riotcommon.router.RiotNewsService;

/**
 * Created by ZP on 2017/8/8.
 */

public class RiotGameApplication extends BaseApplication {

    private static final String TAG = "RiotGameApplication";

    private static Context sContext;

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: ");
        super.onCreate();
        sContext = getApplicationContext();
        initARouter();
        initLitePal();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {
            // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As early as possible, it is recommended to initialize in the Application
    }

    private void initLitePal() {
        RiotNewsService riotNewsService = (RiotNewsService) ARouter.getInstance().build(RouterConstants.RIOT_NEWS_SERVICE).navigation();
        riotNewsService.initLitePal(this);
    }

    public static Context getContext() {
        return sContext;
    }
}
