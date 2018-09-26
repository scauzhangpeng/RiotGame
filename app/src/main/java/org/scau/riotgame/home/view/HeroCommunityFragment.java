package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.basiclib.util.DateUtil;
import com.xyz.riotcommon.CommonFragment;
import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.Card;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.HeroCommunityContract;
import org.scau.riotgame.home.presenter.HeroCommunityPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

import static com.xyz.basiclib.util.DateUtil.DATE_FORMAT_MONTH_DAY;
import static com.xyz.basiclib.util.DateUtil.DATE_FORMAT_SEC;


/**
 * Created by ZP on 2018/1/24.
 */

public class HeroCommunityFragment extends CommonFragment<HeroCommunityContract.View, HeroCommunityContract.Presenter> implements HeroCommunityContract.View, OnRefreshListener, OnLoadmoreListener {


    @Bind(R.id.rv_layout_refresh)
    RecyclerView mRvLayoutRefresh;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private BasicAdapter<News> mAdapter;
    private List<News> mNews;

    /**
     * 英雄时刻
     */
    private RecyclerView mRvBattleVideo;
    private BasicAdapter<Card> mBattleVideoAdapter;
    private List<Card> mBattleVideoCard;

    private RecyclerView mRvRecentHero;
    private BasicAdapter<Card> mRecentHeroAdapter;
    private List<Card> mRecentHeroCard;

    private MultipleTypeSupport<News> mMultipleTypeSupport = new MultipleTypeSupport<News>() {
        @Override
        public int getLayoutId(News news, int position) {
            if (position == 0) {
                return R.layout.layout_recent_hero;
            }

            if (position == 4) {
                return R.layout.layout_battle_video;
            }
            return R.layout.item_hero_group;
        }
    };

    @Override
    public void showNewsList(List<News> news) {
        mNews.clear();
        mNews.addAll(news);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreNewsList(int currentPage, List<News> news) {
        mNews.addAll(news);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void showBattleVideo(List<Card> battleVideoCard) {
        mBattleVideoCard.addAll(battleVideoCard);
        mBattleVideoAdapter.notifyDataSetChanged();
    }

    @Override
    public void showRecentHero(List<Card> recentHero) {
        mRecentHeroCard.addAll(recentHero);
        mRecentHeroAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mRecentHeroCard = new ArrayList<>();
        mRecentHeroAdapter = new BasicAdapter<Card>(R.layout.item_recent_hero, mRecentHeroCard, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, Card card, int position) {
                holder.setText(R.id.tv_user_time, card.getUse_times());
                holder.setText(R.id.tv_win_rate, card.getWin_rate());
                holder.setText(R.id.tv_achievement_num, card.getAchievement_num());
                holder.setText(R.id.tv_achievement_name, card.getAchievement_name());
                holder.setImagePath(R.id.iv_bg, new AbstractImageLoader("") {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };

        mBattleVideoCard = new ArrayList<>();
        mBattleVideoAdapter = new BasicAdapter<Card>(R.layout.item_battle_video, mBattleVideoCard, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, Card card, int position) {
                holder.setText(R.id.tv_title, card.getTitle());
                holder.setText(R.id.tv_news_type, card.getNewstype());
                holder.setText(R.id.tv_video_len, card.getV_len());
                String date = DateUtil.strToStr(card.getPublication_date(), DATE_FORMAT_SEC, DATE_FORMAT_MONTH_DAY);
                holder.setText(R.id.tv_publication_date, date);
                holder.setText(R.id.tv_pv, card.getPv());
                holder.setImagePath(R.id.iv_battle_video_header, new AbstractImageLoader(card.getImage_url_small()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };


        mNews = new ArrayList<>();
        mAdapter = new BasicAdapter<News>(mNews, getActivity(), mMultipleTypeSupport) {
            @Override
            protected void bindData(BasicViewHolder holder, News news, int position) {
                if (position == 0) {
                    mRvRecentHero = holder.getView(R.id.rv_recent_hero);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvRecentHero.setLayoutManager(linearLayoutManager);
                    mRvRecentHero.setAdapter(mRecentHeroAdapter);
                    return;
                }
                if (position == 4) {
                    mRvBattleVideo = holder.getView(R.id.rv_hero_battle_video);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvBattleVideo.setLayoutManager(linearLayoutManager);
                    mRvBattleVideo.setAdapter(mBattleVideoAdapter);
                    return;
                }

                holder.setText(R.id.tv_article_title, news.getTitle());
                holder.setText(R.id.tv_article_summary, news.getSummary());
                holder.setText(R.id.tv_article_pv, news.getPv());
                holder.setImagePath(R.id.iv_article, new AbstractImageLoader(news.getImage_url_small()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });

            }
        };


        mRvLayoutRefresh.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvLayoutRefresh.setAdapter(mAdapter);

        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_refresh;
    }

    @Override
    protected HeroCommunityContract.Presenter initPresenter() {
        return new HeroCommunityPresenter();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.refreshNews();
        mPresenter.refreshCardsData();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        refreshlayout.finishLoadmore(3000);
        mPresenter.loadMoreNews();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.d(TAG, "setUserVisibleHint: ");
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
//            mRefreshLayout.autoRefresh();
        }
    }

    @Override
    protected void requestData() {
        super.requestData();
        mRefreshLayout.autoRefresh();
    }

}
