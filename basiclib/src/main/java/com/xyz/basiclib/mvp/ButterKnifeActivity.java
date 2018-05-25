package com.xyz.basiclib.mvp;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import butterknife.ButterKnife;

/**
 * Created by ZP on 2018/5/24.
 */

public abstract class ButterKnifeActivity extends BaseActivity {

    @CallSuper
    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        ButterKnife.bind(this);
    }
}
