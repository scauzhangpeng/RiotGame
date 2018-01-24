package org.scau.riotgame.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.MvpFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ZP on 2018/1/24.
 */

public abstract class ButterKnifeFragment<V, P extends BasePresenter<V>> extends MvpFragment<V, P> {

    private Unbinder unbinder;


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, mView);
    }
}
