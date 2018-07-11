package com.muugi.debugtools.ele;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import me.ele.uetool.UETool;

/**
 * Created by ZP on 2018/7/11.
 */

public class EleActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private int visibleActivityCount;
    private int uetoolDismissY = 300;

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        visibleActivityCount++;
        if (visibleActivityCount == 1 && uetoolDismissY >= 0) {
            UETool.showUETMenu(uetoolDismissY);
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        visibleActivityCount--;
        if (visibleActivityCount == 0) {
            uetoolDismissY = UETool.dismissUETMenu();
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
