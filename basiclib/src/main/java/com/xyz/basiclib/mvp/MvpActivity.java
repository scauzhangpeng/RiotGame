package com.xyz.basiclib.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by ZP on 2017/8/15.
 */

public abstract class MvpActivity<V, P extends BasePresenter<V>> extends BaseActivity {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract P initPresenter();
}
