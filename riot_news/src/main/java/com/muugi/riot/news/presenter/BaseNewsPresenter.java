package com.muugi.riot.news.presenter;

import com.xyz.basiclib.mvp.BasePresenter;

/**
 * Created by ZP on 2019/2/18.
 */
public abstract class BaseNewsPresenter<V> extends BasePresenter<V> {

    protected String cid;

    public BaseNewsPresenter(String cid) {
        this.cid = cid;
    }

    public abstract void refreshNews();

    public abstract void loadMoreNews();
}
