package com.xyz.riotcommon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by ZP on 2018/1/29.
 */

public class TopBarFactory {

    public static View getDefaultTopBar(Context context, int layoutId) {
        if (layoutId == 0) {
            throw new RuntimeException("layout is not correct");
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(layoutId, null);
    }
}
