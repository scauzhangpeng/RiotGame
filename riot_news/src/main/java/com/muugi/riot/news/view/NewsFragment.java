package com.muugi.riot.news.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.muugi.riot.news.R;
import com.muugi.riot.news.adapter.HotNewsAdapter;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.NewsContract;
import com.muugi.riot.news.presenter.NewsPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.basiclib.recyclerview.WrapperAdapter;
import com.xyz.riotcommon.ImageLoadUtil;
import com.xyz.riotcommon.SimpleRefreshFragment;
import com.xyz.riotcommon.webview.WebViewActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZP on 2017/7/27.
 */

public class NewsFragment extends SimpleRefreshFragment<News, NewsContract.View, NewsContract.Presenter> implements NewsContract.View {

    private Banner mBanner;
    private List<String> images;

    private WrapperAdapter<News> mWrapperAdapter;


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
    public void showNewsList(List<News> news) {
        mData.clear();
        mData.addAll(news);
        mWrapperAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreNewsList(int currentPage, List<News> news) {
        mData.addAll(news);
        mWrapperAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishLoadmore();
    }

    @Override
    public void showBannerNewsList(List<News> bannerNews) {
        images.clear();
        for (int i = 0; i < bannerNews.size(); i++) {
            images.add(bannerNews.get(i).getImage_url_big());
        }
        mBanner.setImages(images);
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ImageLoadUtil.loadImage(context, path.toString(), R.drawable.default_lol_ex, imageView);
            }
        });
        mBanner.start();
    }

    @Override
    protected BasicAdapter<News> getAdapter() {
        return new HotNewsAdapter(mData, getActivity(), mMultipleTypeSupport);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("url", mData.get(position).getArticle_url());
        startActivity(intent);
    }

    @Override
    protected void initViewsAndEvents(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mWrapperAdapter = new WrapperAdapter<News>(mAdapter);

        LayoutInflater inflaterHeader = LayoutInflater.from(getActivity());
        View headerBanner = initHeaderBanner(inflaterHeader, container);

        mWrapperAdapter.addHeaderView(headerBanner);

        mRecyclerView.setAdapter(mWrapperAdapter);
    }

    @Override
    protected void initRecycleView() {
        mData = new ArrayList<>();
        mAdapter = getAdapter();
        mRecyclerView = (RecyclerView) mView.findViewById(com.xyz.riotcommon.R.id.rv_base);
        mRecyclerView.setLayoutManager(getLayoutManager());
//        setRecyclerViewAdapter(mAdapter);
        if (mAdapter != null) {
            mAdapter.setOnItemClickListener(this);
        }
    }

    @Override
    protected NewsContract.Presenter initPresenter() {
        return new NewsPresenter();
    }

    private View initHeaderBanner(LayoutInflater inflater, ViewGroup container) {
        View headerBanner = inflater.inflate(R.layout.header_news_gallery, container, false);
        mBanner = (Banner) headerBanner.findViewById(R.id.banner_news);
        images = new ArrayList<>();
        return headerBanner;
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.refreshNews();
        mPresenter.refreshBannerNews();
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
