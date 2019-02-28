package com.muugi.riot.news.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muugi.riot.news.R;
import com.muugi.riot.news.adapter.HotNewsAdapter;
import com.muugi.riot.news.base.BaseNewsFragment;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.RecommendNewsContract;
import com.muugi.riot.news.model.Injection;
import com.muugi.riot.news.presenter.RecommendNewsPresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.basiclib.recyclerview.WrapperAdapter;
import com.xyz.riotcommon.ImageLoadUtil;
import com.xyz.riotcommon.RouterConstants;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 资讯 - 最新.
 * 顶部一个Banner，采用{@link WrapperAdapter} 进行对原来{@link android.widget.Adapter} 进行包装.
 * Created by ZP on 2017/7/27.
 */
@Route(path = RouterConstants.NEWS_RECOMMEND)
public class RecommendNewsFragment extends BaseNewsFragment<News, RecommendNewsContract.View, RecommendNewsContract.Presenter> implements RecommendNewsContract.View {

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
    public void showListData(List<News> news) {
        mData.clear();
        mData.addAll(news);
        mWrapperAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreListData(int currentPage, List<News> news) {
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
        openWebView(mData.get(position).getArticle_url());
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
    protected RecommendNewsContract.Presenter initPresenter() {
        return new RecommendNewsPresenter("12", Injection.provideNewsRepository());
    }

    private View initHeaderBanner(LayoutInflater inflater, ViewGroup container) {
        View headerBanner = inflater.inflate(R.layout.header_news_gallery, container, false);
        mBanner = (Banner) headerBanner.findViewById(R.id.banner_news);
        images = new ArrayList<>();
        return headerBanner;
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.refreshBannerNews();
    }
}
