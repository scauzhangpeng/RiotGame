package com.xyz.basiclib.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by ZP on 2018/1/24.
 */

public abstract class SimpleButterKnifeFragment extends BaseFragment {


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
