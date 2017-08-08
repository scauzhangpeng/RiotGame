package org.scau.riotgame.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZP on 2017/8/4.
 */
@RunWith(AndroidJUnit4.class)
public class ScreenUtilTest {
    private Context mContext;

    @Before
    public void init() {
        mContext = InstrumentationRegistry.getContext();
    }


    @Test
    public void dip2px() throws Exception {

    }

    @Test
    public void px2dip() throws Exception {
        //N6
        Context context = InstrumentationRegistry.getTargetContext();
        float v = ScreenUtil.px2dip(context, 84);
        assertEquals(24.0, v, 0.0);
    }

    @Test
    public void sp2px() throws Exception {

    }

    @Test
    public void px2sp() throws Exception {

    }

    @Test
    public void getStatusBarHeight() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        int sdkInt = Build.VERSION.SDK_INT;
        //默认0dp
        //api 19 25dp
        //api 23 24dp
        if (sdkInt >= 19 && sdkInt < 23) {

        }

        if (sdkInt >= 23) {
            int statusBarHeight = ScreenUtil.getStatusBarHeight(context);
            assertEquals((int) ScreenUtil.dip2px(context, 24), statusBarHeight);
        }
    }

    @Test
    public void getScreenWidth() throws Exception {
        int screenWidth = ScreenUtil.getScreenWidth((Activity) mContext);
        assertEquals(540.0, screenWidth, 0.0);
    }

    @Test
    public void getScreenHeight() throws Exception {

    }

}