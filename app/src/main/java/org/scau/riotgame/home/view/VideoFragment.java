package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.CommonFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.HotAuthor;
import org.scau.riotgame.home.bean.HotEnter;
import org.scau.riotgame.home.bean.HotMatch;
import org.scau.riotgame.home.bean.HotWpv;
import org.scau.riotgame.home.contract.VideoContract;
import org.scau.riotgame.home.presenter.VideoPresenter;
import org.scau.riotgame.utils.ImageLoadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * Created by ZP on 2018/1/24.
 */

public class VideoFragment extends CommonFragment<VideoContract.View, VideoContract.Presenter> implements VideoContract.View, OnRefreshListener, OnLoadmoreListener {

    @Bind(R.id.rv_hot_author)
    RecyclerView mRvHotAuthor;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.rv_hot_wpv)
    RecyclerView mRvHotWpv;
    @Bind(R.id.rv_hot_enter)
    RecyclerView mRvHotEnter;
    @Bind(R.id.iv_hot_match_top_thumb)
    ImageView mIvHotMatchTopThumb;
    @Bind(R.id.tv_hot_match_top_title)
    TextView mTvHotMatchTopTitle;
    @Bind(R.id.tv_hot_match_top_author)
    TextView mTvHotMatchTopAuthor;
    @Bind(R.id.tv_hot_match_top_play)
    TextView mTvHotMatchTopPlay;
    @Bind(R.id.rv_hot_match)
    RecyclerView mRvHotMatch;

    private BasicAdapter<HotAuthor> mAdapter;
    private List<HotAuthor> mHotAuthors;

    private BasicAdapter<HotWpv> mHotWpvAdapter;
    private List<HotWpv> mHotWpvs;

    private BasicAdapter<HotEnter> mHotEnterAdapter;
    private List<HotEnter> mHotEnters;

    private BasicAdapter<HotMatch> mHotMatchAdapter;
    private List<HotMatch> mHotMatches;

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
        mTvHotMatchTopTitle.setText(hotMatch.getTitle());
        mTvHotMatchTopAuthor.setText(hotMatch.getAuthor());
        mTvHotMatchTopPlay.setText(hotMatch.getPlay());
        ImageLoadUtil.loadImage(getActivity(), hotMatch.getAppthumb(), R.drawable.default_lol_ex, mIvHotMatchTopThumb);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            mRefreshLayout.autoRefresh();
        }
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        mRvHotAuthor.setLayoutManager(linearLayout);

        mHotAuthors = new ArrayList<>();
        mAdapter = new BasicAdapter<HotAuthor>(R.layout.item_hot_author, mHotAuthors, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, HotAuthor hotAuthor, int position) {
                holder.setText(R.id.tv_hot_author_name, hotAuthor.getSName());
                holder.setText(R.id.tv_hot_author_video, hotAuthor.getIVideo());
                holder.setText(R.id.tv_hot_author_update, hotAuthor.getPubdate());
                holder.setImagePath(R.id.iv_hot_author, new AbstractImageLoader(hotAuthor.getSIMG()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadCircleImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };

        mRvHotAuthor.setAdapter(mAdapter);
        //
        LinearLayoutManager linearLayout1 = new LinearLayoutManager(getActivity());
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        mRvHotWpv.setLayoutManager(linearLayout1);
        mHotWpvs = new ArrayList<>();
        mHotWpvAdapter = new BasicAdapter<HotWpv>(R.layout.item_hot_wpv, mHotWpvs, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, HotWpv hotWpv, int position) {
                holder.setText(R.id.tv_hot_wpv_title, hotWpv.getTitle());
                holder.setText(R.id.tv_hot_wpv_author, hotWpv.getAuthor());
                holder.setText(R.id.tv_hot_wpv_play, hotWpv.getPlay());
                holder.setImagePath(R.id.iv_hot_wpv_appthumb, new AbstractImageLoader(hotWpv.getAppthumb()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });

                holder.setImagePath(R.id.iv_hot_wpv_author, new AbstractImageLoader(hotWpv.getAuthorImg()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadCircleImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };
        mRvHotWpv.setAdapter(mHotWpvAdapter);

        //
        LinearLayoutManager hotEnterLayout = new LinearLayoutManager(getActivity());
        hotEnterLayout.setOrientation(LinearLayout.HORIZONTAL);
        mRvHotEnter.setLayoutManager(hotEnterLayout);
        mHotEnters = new ArrayList<>();
        mHotEnterAdapter = new BasicAdapter<HotEnter>(R.layout.item_hot_enter, mHotEnters, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, HotEnter hotEnter, int position) {
                holder.setText(R.id.tv_hot_enter_name, hotEnter.getSName());
                holder.setText(R.id.tv_hot_enter_num, hotEnter.getIVideo());
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

        //
        LinearLayoutManager hotMatchLayout = new LinearLayoutManager(getActivity());
        hotMatchLayout.setOrientation(LinearLayout.HORIZONTAL);
        mRvHotMatch.setLayoutManager(hotMatchLayout);
        mHotMatches = new ArrayList<>();
        mHotMatchAdapter = new BasicAdapter<HotMatch>(R.layout.item_hot_match, mHotMatches, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, HotMatch hotMatch, int position) {
                holder.setText(R.id.tv_hot_match_title, hotMatch.getTitle());
                holder.setText(R.id.tv_hot_match_play, hotMatch.getPlay());
                holder.setImagePath(R.id.iv_hot_match_thumb, new AbstractImageLoader(hotMatch.getThumb()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });

            }
        };
        mRvHotMatch.setAdapter(mHotMatchAdapter);

        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(false);
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
        mPresenter.getHotAuthorList();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }
}
