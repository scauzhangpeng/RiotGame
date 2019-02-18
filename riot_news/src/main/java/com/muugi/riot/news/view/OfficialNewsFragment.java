package com.muugi.riot.news.view;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muugi.riot.news.R;
import com.muugi.riot.news.adapter.HotNewsAdapter;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.OfficialNewsContract.View;
import com.muugi.riot.news.presenter.OfficialNewsPresenter;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.RouterConstants;
import com.xyz.riotcommon.webview.WebViewActivity;

/**
 * Created by ZP on 2018/11/11.
 */
@Route(path = RouterConstants.NEWS_OFFICIAL)
public class OfficialNewsFragment extends BaseNewsFragment<News, View, OfficialNewsPresenter> implements View {

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
    protected OfficialNewsPresenter initPresenter() {
        return new OfficialNewsPresenter("3");
    }

    @Override
    public void onItemClick(android.view.View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("url", mData.get(position).getArticle_url());
        openActivity(WebViewActivity.class, bundle);
    }
}
