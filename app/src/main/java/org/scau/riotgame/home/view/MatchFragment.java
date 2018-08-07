package org.scau.riotgame.home.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.basiclib.recyclerview.WrapperAdapter;
import com.xyz.riotcommon.CommonFragment;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.Feature;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.MatchContract;
import org.scau.riotgame.home.presenter.MatchPresenter;
import org.scau.riotgame.utils.FormatUtil;

import com.xyz.riotcommon.ImageLoadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ZP on 2018/1/24.
 * <p>
 * 赛事
 * </p>
 */

public class MatchFragment extends CommonFragment<MatchContract.View, MatchContract.Presenter> implements MatchContract.View, OnRefreshListener, OnLoadmoreListener {


    @Bind(R.id.rv_layout_refresh)
    RecyclerView mRvLayoutRefresh;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private WrapperAdapter<News> mWrapperAdapter;
    private BasicAdapter<News> mAdapter;
    private List<News> mNewses;

    private Banner mBanner;
    private List<String> images;

    ImageView mIvMenu0;

    TextView mTvMenu0;

    ImageView mIvMenu1;

    TextView mTvMenu1;

    ImageView mIvMenu2;

    TextView mTvMenu2;

    ImageView mIvMenu3;

    TextView mTvMenu3;

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
        mTvMenu0.setText(features.get(0).getName());
        mTvMenu1.setText(features.get(1).getName());
        mTvMenu2.setText(features.get(2).getName());
        mTvMenu3.setText(features.get(3).getName());
        ImageLoadUtil.loadImage(getActivity(), features.get(0).getIconUrl(), R.drawable.default_lol_ex, mIvMenu0);
        ImageLoadUtil.loadImage(getActivity(), features.get(1).getIconUrl(), R.drawable.default_lol_ex, mIvMenu1);
        ImageLoadUtil.loadImage(getActivity(), features.get(2).getIconUrl(), R.drawable.default_lol_ex, mIvMenu2);
        ImageLoadUtil.loadImage(getActivity(), features.get(3).getIconUrl(), R.drawable.default_lol_ex, mIvMenu3);
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
    public void showRefreshMatchNews(List<News> news) {
        mNewses.clear();
        mNewses.addAll(news);
        mWrapperAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreMatchNews(List<News> news) {
        mNewses.addAll(news);
        mWrapperAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mNewses = new ArrayList<>();
        mAdapter = new BasicAdapter<News>(mNewses, getActivity(), mMultipleTypeSupport) {
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
        mWrapperAdapter = new WrapperAdapter<>(mAdapter);

        LayoutInflater inflaterHeader = LayoutInflater.from(getActivity());
        View header = inflaterHeader.inflate(R.layout.header_match_gallery, container, false);
        mBanner = (Banner) header.findViewById(R.id.banner_match);
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ImageLoadUtil.loadImage(context, path.toString(), R.drawable.default_lol_ex, imageView);
            }
        });
        images = new ArrayList<>();
        mWrapperAdapter.addHeaderView(header);

        View headerMenu = initHeaderMenu(inflater, container);
        mWrapperAdapter.addHeaderView(headerMenu);

        mRvLayoutRefresh.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvLayoutRefresh.setAdapter(mWrapperAdapter);

        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    private View initHeaderMenu(LayoutInflater inflater, ViewGroup container) {
        View headerMenu = inflater.inflate(R.layout.header_match_menu, container, false);
        mTvMenu0 = (TextView) headerMenu.findViewById(R.id.tv_menu_0);
        mTvMenu1 = (TextView) headerMenu.findViewById(R.id.tv_menu_1);
        mTvMenu2 = (TextView) headerMenu.findViewById(R.id.tv_menu_2);
        mTvMenu3 = (TextView) headerMenu.findViewById(R.id.tv_menu_3);
        mIvMenu0 = (ImageView) headerMenu.findViewById(R.id.iv_menu_0);
        mIvMenu1 = (ImageView) headerMenu.findViewById(R.id.iv_menu_1);
        mIvMenu2 = (ImageView) headerMenu.findViewById(R.id.iv_menu_2);
        mIvMenu3 = (ImageView) headerMenu.findViewById(R.id.iv_menu_3);
        return headerMenu;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_refresh;
    }

    @Override
    protected MatchContract.Presenter initPresenter() {
        return new MatchPresenter();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            mRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.gameCenterData();
        mPresenter.getNews();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNews();
    }
}
