package org.scau.riotgame.home.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.mvp.MvpFragment;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.basiclib.recyclerview.WrapperAdapter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.scau.riotgame.R;
import org.scau.riotgame.home.NewsAdapter;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.NewsContract;
import org.scau.riotgame.home.presenter.NewsPresenter;
import org.scau.riotgame.utils.ImageLoadUtil;
import org.scau.riotgame.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static android.content.ContentValues.TAG;

/**
 * Created by ZP on 2017/7/27.
 */

public class NewsFragment extends MvpFragment<NewsContract.View, NewsContract.Presenter> implements NewsContract.View, OnRefreshListener, OnLoadmoreListener {


    @Bind(R.id.rv_layout_refresh)
    RecyclerView mRvHeroFree;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private BasicAdapter<News> mAdapter;
    private List<News> mNews;

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
        mNews.clear();
        mNews.addAll(news);
        mWrapperAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreNewsList(int currentPage, List<News> news) {
        mNews.addAll(news);
        mWrapperAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
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
    protected void initViewsAndEvents(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mRvHeroFree.setLayoutManager(new LinearLayoutManager(getActivity()));
        mNews = new ArrayList<>();
        mAdapter = new NewsAdapter(mNews, getActivity(), mMultipleTypeSupport);

        mAdapter.setOnItemClickListener(new BasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", mNews.get(position).getArticle_url());
                startActivity(intent);
            }
        });
        mWrapperAdapter = new WrapperAdapter<News>(mAdapter);

        LayoutInflater inflaterHeader = LayoutInflater.from(getActivity());
        View headerBanner = initHeaderBanner(inflaterHeader, container);

        mWrapperAdapter.addHeaderView(headerBanner);

        mRvHeroFree.setAdapter(mWrapperAdapter);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_refresh;
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
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        mRefreshLayout.autoRefresh();
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
}
