package com.xyz.basiclib.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Mvp中使用ButterKnife，单独一个类可以随时丢弃.
 * Created by ZP on 2018/1/24.
 */

public abstract class MvpButterKnifeFragment<V, P extends BasePresenter<V>> extends MvpFragment<V, P> {

    private Unbinder mUnBinder;

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mUnBinder = ButterKnife.bind(this, mView);
    }

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }
}
