package com.xyz.basiclib;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by ZP on 2018/6/8.
 */

public class PageManager {

    private ViewGroup mEmptyLayout;
    private ViewGroup mErrorLayout;
    private ViewGroup currentLayout;

    private PageManager() {

    }

    private static PageManager sPageManager;

    public static PageManager getInstance() {
        if (sPageManager == null) {
            synchronized (PageManager.class) {
                if (sPageManager == null) {
                    sPageManager = new PageManager();
                }
            }
        }
        return sPageManager;
    }

    public void setEmptyLayout(Context context, int resId) {
        mEmptyLayout = (ViewGroup) LayoutInflater.from(context.getApplicationContext()).inflate(resId, null);
        mEmptyLayout.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public void setErrorLayout(Context context, int resId) {
        mErrorLayout = (ViewGroup) LayoutInflater.from(context.getApplicationContext()).inflate(resId, null);
        mErrorLayout.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }


    public void showEmptyLayout(View target, WindowManager wm) {
        if (currentLayout != null) {
            wm.removeView(currentLayout);
        }
        currentLayout = mEmptyLayout;
        wm.addView(currentLayout, setLayoutParams(target));
    }

    public void showErrorLayout(View target, WindowManager wm) {
        if (currentLayout != null) {
            wm.removeView(currentLayout);
        }
        currentLayout = mErrorLayout;
        wm.addView(currentLayout, setLayoutParams(target));
    }


    private ViewGroup.LayoutParams setLayoutParams(View target) {
        WindowManager.LayoutParams wlp = new WindowManager.LayoutParams();
        wlp.format = PixelFormat.TRANSPARENT;
        wlp.flags = (WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        int[] location = new int[2];
        target.getLocationOnScreen(location);
        wlp.x = location[0];
        wlp.y = location[1];
        wlp.height = target.getHeight();
        wlp.width = target.getWidth();
        wlp.type = WindowManager.LayoutParams.FIRST_SUB_WINDOW;
        wlp.gravity = Gravity.LEFT | Gravity.TOP;
        return wlp;
    }

    public void onDestroy(WindowManager wm) {
        if (currentLayout != null) {
            wm.removeViewImmediate(currentLayout);
            currentLayout = null;
        }
    }
}
