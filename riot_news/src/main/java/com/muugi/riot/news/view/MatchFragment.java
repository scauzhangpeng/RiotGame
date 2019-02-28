package com.muugi.riot.news.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muugi.riot.news.R;
import com.muugi.riot.news.adapter.MatchHeaderMenuAdapter;
import com.muugi.riot.news.base.BaseNewsFragment;
import com.muugi.riot.news.bean.Feature;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.MatchContract;
import com.muugi.riot.news.model.Injection;
import com.muugi.riot.news.presenter.MatchPresenter;
import com.muugi.riot.news.utils.FormatUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.basiclib.recyclerview.WrapperAdapter;
import com.xyz.riotcommon.ImageLoadUtil;
import com.xyz.riotcommon.RouterConstants;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZP on 2018/1/24.
 * <p>
 * 赛事
 * </p>
 */
@Route(path = RouterConstants.NEWS_MATCH)
public class MatchFragment extends BaseNewsFragment<News, MatchContract.View, MatchContract.Presenter> implements MatchContract.View {


    private WrapperAdapter<News> mWrapperAdapter;

    private Banner mBanner;
    private List<String> images;

    private RecyclerView mHeaderMenu;
    private List<Feature> mHeaderMenuData;
    private MatchHeaderMenuAdapter mMatchHeaderMenuAdapter;

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
    public void showMatchHeaderMenu(List<Feature> features) {
        mHeaderMenuData.clear();
        mHeaderMenuData.addAll(features);
        mMatchHeaderMenuAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMatchHeaderGallery(List<Feature> features) {
        images.clear();
        for (Feature feature : features) {
            images.add(feature.getIconUrl());
        }
        mBanner.setImages(images);
        mBanner.start();
    }

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
    public BasicAdapter<News> getAdapter() {
        return new BasicAdapter<News>(mData, getActivity(), mMultipleTypeSupport) {
            @Override
            protected void bindData(BasicViewHolder holder, News news, int position) {
                if ("ordinary".equals(news.getNewstypeid())) {
                    if ("True".equals(news.getIs_top())) {
                        holder.setVisibility(R.id.iv_article_top, View.VISIBLE);
                    } else {
                        holder.setVisibility(R.id.iv_article_top, View.GONE);
                    }
                    holder.setText(R.id.tv_article_title, news.getTitle());
                    holder.setText(R.id.tv_article_summary, news.getSummary());
                    holder.setText(R.id.tv_article_pv, FormatUtil.unitToTenThousand(news.getPv()));
                    if (news.getNewstype() == null || TextUtils.isEmpty(news.getNewstype())) {
                        holder.setVisibility(R.id.tv_article_tag, View.GONE);
                    } else {
                        holder.setVisibility(R.id.tv_article_tag, View.VISIBLE);
                        holder.setText(R.id.tv_article_tag, news.getNewstype());
                    }
                    holder.setImagePath(R.id.iv_article, new AbstractImageLoader(news.getImage_url_small()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });

                    if ("True".equals(news.getImage_with_btn())) {
                        holder.setVisibility(R.id.iv_article_video, View.VISIBLE);
                    } else {
                        holder.setVisibility(R.id.iv_article_video, View.GONE);
                    }
                }

                if ("report".equals(news.getNewstypeid())) {
                    holder.setText(R.id.tv_article_title, news.getTitle());

                    holder.setText(R.id.tv_article_pv, FormatUtil.unitToTenThousand(news.getPv()));
                    if (news.getNewstype() == null || TextUtils.isEmpty(news.getNewstype())) {
                        holder.setVisibility(R.id.tv_article_tag, View.GONE);
                    } else {
                        holder.setText(R.id.tv_article_tag, news.getNewstype());
                    }
                    holder.setImagePath(R.id.iv_article, new AbstractImageLoader(news.getImage_url_small()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });

                    holder.setImagePath(R.id.iv_logo_teama, new AbstractImageLoader(news.getTeama_logo()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });
                    holder.setText(R.id.tv_name_teama, news.getTeama_name());
                    holder.setText(R.id.tv_match_result, news.getMarch_result());
                    holder.setImagePath(R.id.iv_logo_teamb, new AbstractImageLoader(news.getTeamb_logo()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });
                    holder.setText(R.id.tv_name_teamb, news.getTeamb_name());
                }

            }
        };
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
    public void onItemClick(View view, int position) {

    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mWrapperAdapter = new WrapperAdapter<>(mAdapter);

        View header = initHeaderBanner(inflater, container);
        images = new ArrayList<>();
        mWrapperAdapter.addHeaderView(header);

        View headerMenu = initHeaderMenu(inflater, container);
        mWrapperAdapter.addHeaderView(headerMenu);

        mRecyclerView.setAdapter(mWrapperAdapter);
    }

    private View initHeaderBanner(LayoutInflater inflater, ViewGroup container) {
        View header = inflater.inflate(R.layout.header_match_gallery, container, false);
        mBanner = (Banner) header.findViewById(R.id.banner_match);
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ImageLoadUtil.loadImage(context, path.toString(), R.drawable.default_lol_ex, imageView);
            }
        });
        return header;
    }
    private View initHeaderMenu(LayoutInflater inflater, ViewGroup container) {
        View headerMenu = inflater.inflate(R.layout.header_match_menu, container, false);
        mHeaderMenu = headerMenu.findViewById(R.id.rv_match_menu);
        mHeaderMenu.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mHeaderMenuData = new ArrayList<>();
        mMatchHeaderMenuAdapter = new MatchHeaderMenuAdapter(mHeaderMenuData, getActivity());
        mHeaderMenu.setAdapter(mMatchHeaderMenuAdapter);
        return headerMenu;
    }

    @Override
    protected MatchContract.Presenter initPresenter() {
        return new MatchPresenter("73", Injection.provideNewsRepository());
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.gameCenterData();
        mPresenter.refreshNews();
    }
}
