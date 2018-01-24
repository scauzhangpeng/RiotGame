package com.xyz.basiclib.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by ZP on 2017/8/15.
 */

public class BasePresenter<V> {
    protected Reference<V> mView;

    public void attachView(V view) {
        mView = new WeakReference<V>(view);
    }

    public void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }

    public V getView() {
        return mView.get();
    }

    public boolean isViewAttach() {
        return mView != null && mView.get() != null;
    }

}
