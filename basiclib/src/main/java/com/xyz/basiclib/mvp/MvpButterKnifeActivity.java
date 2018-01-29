package com.xyz.basiclib.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;

/**
 * Created by ZP on 2018/1/29.
 */

public abstract class MvpButterKnifeActivity<V, P extends BasePresenter<V>> extends MvpActivity<V, P> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
