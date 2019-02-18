package com.muugi.riot.news.view;

import com.muugi.riot.news.presenter.BaseNewsPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.riotcommon.SimpleRefreshFragment;

/**
 * Created by ZP on 2019/2/18.
 */
public abstract class BaseNewsFragment<T, V, P extends BaseNewsPresenter<V>> extends SimpleRefreshFragment<T, V, P> {


    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.refreshNews();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNews();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mSmartRefreshLayout.autoRefresh();
    }
}
