package com.muugi.riot.news.view;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muugi.riot.news.R;
import com.muugi.riot.news.adapter.HotNewsAdapter;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.HotNewsContract;
import com.muugi.riot.news.presenter.HotNewsPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.RouterConstants;
import com.xyz.riotcommon.SimpleRefreshFragment;
import com.xyz.riotcommon.webview.WebViewActivity;

/**
 * Created by ZP on 2018/11/10.
 */
@Route(path = RouterConstants.NEWS_HOT)
public class HotNewsFragment extends SimpleRefreshFragment<News, HotNewsContract.View, HotNewsContract.Presenter> implements HotNewsContract.View {

    private MultipleTypeSupport<News> mMultipleTypeSupport = new MultipleTypeSupport<News>() {
        @Override
        public int getLayoutId(News news, int position) {

            if ("image".equals(news.getNewstypeid())) {
                return R.layout.item_news_image;
            } else if ("report".equals(news.getNewstypeid())) {
                return R.layout.item_news_report;
            } else {
                return R.layout.item_news_default;
            }


        }
    };

    @Override
    protected BasicAdapter<News> getAdapter() {
        return new HotNewsAdapter(mData, getActivity(), mMultipleTypeSupport);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNews();
    }

    @Override
    protected HotNewsContract.Presenter initPresenter() {
        return new HotNewsPresenter();
    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("url", mData.get(position).getArticle_url());
        openActivity(WebViewActivity.class, bundle);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.refreshNews();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mSmartRefreshLayout.autoRefresh();
    }
}
