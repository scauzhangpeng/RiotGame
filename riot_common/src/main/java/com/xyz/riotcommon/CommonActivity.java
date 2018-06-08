package com.xyz.riotcommon;

import android.content.Context;
import android.os.Bundle;

import com.xyz.basiclib.PageManager;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.MvpActivity;
import com.xyz.basiclib.permission.AndRequestExecutorAdapter;

import java.util.List;

/**
 * Created by ZP on 2018/5/24.
 */

public abstract class CommonActivity<V, P extends BasePresenter<V>> extends MvpActivity<V, P> {


    @Override
    public void showRationaleDialog(Context context, List<String> permissions, AndRequestExecutorAdapter andRequestExecutorAdapter) {

    }

    @Override
    public void showAlwaysDeniedRationale(List<String> permissions) {

    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
    }

    @Override
    public void showEmptyPage(String msg) {

    }

    @Override
    public void showErrorPage(String msg) {
        PageManager.getInstance().showErrorLayout(findViewById(R.id.fl_content), getWindowManager());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PageManager.getInstance().onDestroy(getWindowManager());
    }
}
