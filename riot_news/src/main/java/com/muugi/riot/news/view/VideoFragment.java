package com.muugi.riot.news.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muugi.riot.news.R;
import com.muugi.riot.news.R2;
import com.muugi.riot.news.adapter.WholeVideoAdapter;
import com.muugi.riot.news.bean.HotAuthor;
import com.muugi.riot.news.bean.HotEnter;
import com.muugi.riot.news.bean.HotHero;
import com.muugi.riot.news.bean.HotMatch;
import com.muugi.riot.news.bean.HotWpv;
import com.muugi.riot.news.contract.VideoContract;
import com.muugi.riot.news.presenter.VideoPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.AverageSpaceItemDecoration;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.util.ScreenUtil;
import com.xyz.riotcommon.CommonFragment;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by ZP on 2018/1/24.
 */

public class VideoFragment extends CommonFragment<VideoContract.View, VideoContract.Presenter> implements VideoContract.View, OnRefreshListener, OnLoadmoreListener {

    @BindView(R2.id.rv_hot_author)
    RecyclerView mRvHotAuthor;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R2.id.rv_hot_wpv)
    RecyclerView mRvHotWpv;
    @BindView(R2.id.rv_hot_enter)
    RecyclerView mRvHotEnter;
    @BindView(R2.id.iv_hot_match_top_thumb)
    ImageView mIvHotMatchTopThumb;
    @BindView(R2.id.tv_video_time)
    TextView mTvHotMatchTopTime;
    @BindView(R2.id.tv_hot_match_top_title)
    TextView mTvHotMatchTopTitle;
    @BindView(R2.id.tv_hot_match_top_author)
    TextView mTvHotMatchTopAuthor;
    @BindView(R2.id.tv_hot_match_top_play)
    TextView mTvHotMatchTopPlay;
    @BindView(R2.id.rv_hot_match)
    RecyclerView mRvHotMatch;
    @BindView(R2.id.rv_hot_hero)
    RecyclerView mRvHotHero;
    @BindView(R2.id.rv_whole_video)
    RecyclerView mRvWholeVideo;

    private BasicAdapter<HotAuthor> mAdapter;
    private List<HotAuthor> mHotAuthors;

    private BasicAdapter<HotWpv> mHotWpvAdapter;
    private List<HotWpv> mHotWpvs;

    private BasicAdapter<HotEnter> mHotEnterAdapter;
    private List<HotEnter> mHotEnters;

    private BasicAdapter<HotMatch> mHotMatchAdapter;
    private List<HotMatch> mHotMatches;

    private BasicAdapter<HotHero> mHotHeroAdapter;
    private List<HotHero> mHotHeroes;

    private BasicAdapter<HotMatch> mWholeVideoAdapter;
    private List<HotMatch> mWholeVideos;

    @Override
    public void showHotAuthorList(List<HotAuthor> hotAuthors) {
        mHotAuthors.clear();
        mHotAuthors.addAll(hotAuthors);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showHotWpvList(List<HotWpv> hotWpvs) {
        mHotWpvs.clear();
        mHotWpvs.addAll(hotWpvs);
        mHotWpvAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showHotEnterList(List<HotEnter> hotEnters) {
        mHotEnters.clear();
        mHotEnters.addAll(hotEnters);
        mHotEnterAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showHotMatchList(List<HotMatch> hotMatches) {
        mHotMatches.clear();
        mHotMatches.addAll(hotMatches);
        mHotMatchAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showHotMatchTop(HotMatch hotMatch) {
        mTvHotMatchTopTime.setText(hotMatch.getTime());
        mTvHotMatchTopTitle.setText(hotMatch.getTitle());
        mTvHotMatchTopAuthor.setText(hotMatch.getAuthor());
        mTvHotMatchTopPlay.setText(getString(R.string.information_video_play, hotMatch.getPlay()));
        ImageLoadUtil.loadImage(getActivity(), hotMatch.getAppthumb(), R.drawable.default_lol_ex, mIvHotMatchTopThumb);
    }

    @Override
    public void showHotHeroList(List<HotHero> hotHeroes) {
        mHotHeroes.clear();
        mHotHeroes.addAll(hotHeroes);
        mHotHeroAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showWholeVideoList(List<HotMatch> result) {
        mWholeVideos.clear();
        mWholeVideos.addAll(result);
        mWholeVideoAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreWholeVideoList(int currentPage, List<HotMatch> result) {
        mWholeVideos.addAll(result);
        mWholeVideoAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);

        //本周热榜
        LinearLayoutManager linearLayout1 = new LinearLayoutManager(getActivity());
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        mRvHotWpv.setLayoutManager(linearLayout1);
        mHotWpvs = new ArrayList<>();
        mHotWpvAdapter = new BasicAdapter<HotWpv>(R.layout.item_hot_wpv, mHotWpvs, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, HotWpv hotWpv, int position) {
                holder.setText(R.id.tv_video_time, hotWpv.getTime());
                holder.setText(R.id.tv_hot_wpv_title, hotWpv.getTitle());
                holder.setText(R.id.tv_hot_wpv_author, hotWpv.getAuthor());
                holder.setText(R.id.tv_hot_wpv_play, getString(R.string.information_video_play, hotWpv.getPlay()));
                holder.setImagePath(R.id.iv_hot_wpv_appthumb, new AbstractImageLoader(hotWpv.getAppthumb()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });

                holder.setImagePath(R.id.iv_hot_wpv_author, new AbstractImageLoader(hotWpv.getAuthorImg()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };
        mRvHotWpv.setAdapter(mHotWpvAdapter);


        //热门解说
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        mRvHotAuthor.setLayoutManager(linearLayout);
        mHotAuthors = new ArrayList<>();
        mAdapter = new BasicAdapter<HotAuthor>(R.layout.item_hot_author, mHotAuthors, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, HotAuthor hotAuthor, int position) {
                holder.setText(R.id.tv_hot_author_name, hotAuthor.getSName());
                holder.setText(R.id.tv_hot_author_video, getString(R.string.information_author_video_num, hotAuthor.getIVideo()));
                holder.setText(R.id.tv_hot_author_update, hotAuthor.getPubdate());
                holder.setImagePath(R.id.iv_hot_author, new AbstractImageLoader(hotAuthor.getSIMG()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };
        mRvHotAuthor.setAdapter(mAdapter);


        //热门赛事
        LinearLayoutManager hotMatchLayout = new LinearLayoutManager(getActivity());
        hotMatchLayout.setOrientation(LinearLayout.HORIZONTAL);
        mRvHotMatch.setLayoutManager(hotMatchLayout);
        mHotMatches = new ArrayList<>();
        mHotMatchAdapter = new BasicAdapter<HotMatch>(R.layout.item_hot_match, mHotMatches, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, HotMatch hotMatch, int position) {
                holder.setText(R.id.tv_video_time, hotMatch.getTime());
                holder.setText(R.id.tv_hot_match_title, hotMatch.getTitle());
                holder.setText(R.id.tv_hot_match_play, getString(R.string.information_video_play, hotMatch.getPlay()));
                holder.setImagePath(R.id.iv_hot_match_thumb, new AbstractImageLoader(hotMatch.getThumb()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });

            }
        };
        mRvHotMatch.setAdapter(mHotMatchAdapter);

        //热门娱乐
        LinearLayoutManager hotEnterLayout = new LinearLayoutManager(getActivity());
        hotEnterLayout.setOrientation(LinearLayout.HORIZONTAL);
        mRvHotEnter.setLayoutManager(hotEnterLayout);
        mHotEnters = new ArrayList<>();
        mHotEnterAdapter = new BasicAdapter<HotEnter>(R.layout.item_hot_enter, mHotEnters, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, HotEnter hotEnter, int position) {
                holder.setText(R.id.tv_hot_enter_name, hotEnter.getSName());
                holder.setText(R.id.tv_hot_enter_num, getString(R.string.information_author_video_num, hotEnter.getIVideo()));
                holder.setText(R.id.tv_hot_enter_update, hotEnter.getPubdate());
                holder.setImagePath(R.id.iv_hot_enter_logo, new AbstractImageLoader(hotEnter.getSIMG()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });

            }
        };
        mRvHotEnter.setAdapter(mHotEnterAdapter);

        //热门英雄
        LinearLayoutManager hotHeroLayout = new LinearLayoutManager(getActivity());
        hotHeroLayout.setOrientation(LinearLayout.HORIZONTAL);
        mRvHotHero.setLayoutManager(hotHeroLayout);
        mHotHeroes = new ArrayList<>();
        mHotHeroAdapter = new BasicAdapter<HotHero>(R.layout.item_hot_match, mHotHeroes, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, HotHero hotHero, int position) {
                holder.setText(R.id.tv_video_time, hotHero.getTime());
                holder.setText(R.id.tv_hot_match_title, hotHero.getTitle());
                holder.setText(R.id.tv_hot_match_play, getString(R.string.information_video_play, hotHero.getPlay()));
                holder.setImagePath(R.id.iv_hot_match_thumb, new AbstractImageLoader(hotHero.getThumb()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };
        mRvHotHero.setAdapter(mHotHeroAdapter);

        //全部英雄
        mRvWholeVideo.setNestedScrollingEnabled(false);
        GridLayoutManager wholeVideoLayout = new GridLayoutManager(getActivity(), 2);
        mRvWholeVideo.setLayoutManager(wholeVideoLayout);
        mWholeVideos = new ArrayList<>();
        mWholeVideoAdapter = new WholeVideoAdapter(R.layout.item_whole_video, mWholeVideos, getActivity());
        mRvWholeVideo.addItemDecoration(new AverageSpaceItemDecoration((int) ScreenUtil.dp2px(getActivity(), 10), true));
        mRvWholeVideo.setAdapter(mWholeVideoAdapter);


        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected VideoContract.Presenter initPresenter() {
        return new VideoPresenter();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.getVideoDataHotRec();
        mPresenter.requestVideoDataWhole();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreVideoDataWhole();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mRefreshLayout.autoRefresh();
    }

}
