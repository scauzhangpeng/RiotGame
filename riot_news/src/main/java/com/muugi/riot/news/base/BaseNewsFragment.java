package com.muugi.riot.news.base;

import android.os.Bundle;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.riotcommon.SimpleRefreshFragment;
import com.xyz.riotcommon.SimpleRefreshView;
import com.xyz.riotcommon.webview.WebViewActivity;

/**
 * 新闻资讯基础页面.
 * 主要完成页面自动刷新、刷新数据、加载更多数据。
 * Created by ZP on 2019/2/18.
 */
public abstract class BaseNewsFragment<T, V extends SimpleRefreshView, P extends BaseNewsContract.Presenter<V>> extends SimpleRefreshFragment<T, V, P> {


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

    protected void openWebView(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        openActivity(WebViewActivity.class, bundle);
    }
}
