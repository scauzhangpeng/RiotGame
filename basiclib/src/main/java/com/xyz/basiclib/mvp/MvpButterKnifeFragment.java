package com.xyz.basiclib.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by ZP on 2018/1/24.
 */

public abstract class MvpButterKnifeFragment<V, P extends BasePresenter<V>> extends MvpFragment<V, P> {

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ButterKnife.bind(this, mView);
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
