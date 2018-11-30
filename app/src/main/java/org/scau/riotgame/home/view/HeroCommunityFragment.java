package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import org.scau.riotgame.home.bean.CardItem;
import org.scau.riotgame.home.bean.HeroGroupListBean;
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

    private BasicAdapter<HeroGroupListBean> mAdapter;
    private List<HeroGroupListBean> mNews;

    /**
     * 英雄时刻
     */
    private RecyclerView mRvBattleVideo;
    private BasicAdapter<Card> mBattleVideoAdapter;
    private List<Card> mBattleVideoCard;

    /**
     * 我的英雄圈
     */
    private RecyclerView mRvRecentHero;
    private BasicAdapter<Card> mRecentHeroAdapter;
    private List<Card> mRecentHeroCard;

    /**
     * 推荐攻略
     */
    private RecyclerView mRvRecommendStrategy;
    private BasicAdapter<Card> mRecommendStrategyAdapter;
    private List<Card> mRecommendStrategyCard;

    /**
     * 玩家英雄秀
     */
    private RecyclerView mRvPlayShow;
    private BasicAdapter<Card> mPlayShowAdapter;
    private List<Card> mPlayShowCard;

    private MultipleTypeSupport<HeroGroupListBean> mMultipleTypeSupport = new MultipleTypeSupport<HeroGroupListBean>() {
        @Override
        public int getLayoutId(HeroGroupListBean heroGroupListBean, int position) {
            if ("RecentHeroCard".equals(heroGroupListBean.getType())) {
                return R.layout.layout_recent_hero;
            }

            if ("RecommendStrategyCard".equals(heroGroupListBean.getType())) {
                return R.layout.layout_recommend_strategy;
            }

            if ("PlayerShowCard".equals(heroGroupListBean.getType())) {
                return R.layout.layout_player_show;
            }

            if ("BattleVideosCard".equals(heroGroupListBean.getType())) {
                return R.layout.layout_battle_video;
            }

            return R.layout.item_hero_group;
        }
    };

    @Override
    public void showNewsList(List<HeroGroupListBean> news) {
        mNews.clear();
        mNews.addAll(news);
        mAdapter.notifyDataSetChanged();
        mPresenter.refreshCardsData();
    }

    @Override
    public void showMoreNewsList(int currentPage, List<HeroGroupListBean> news) {
        mNews.addAll(news);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void showBattleVideoCard(CardItem battleVideoCard) {
        mBattleVideoCard.clear();
        mBattleVideoCard.addAll(battleVideoCard.getData());
        mBattleVideoAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showRecentHeroCard(CardItem recentHero) {
        mRecentHeroCard.clear();
        mRecentHeroCard.addAll(recentHero.getData());
        mRecentHeroAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showPlayerShowCard(CardItem playerShow) {
        mPlayShowCard.clear();
        mPlayShowCard.addAll(playerShow.getData());
        mPlayShowAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showRecommendStrategyCard(CardItem recommendStrategy) {
        mRecommendStrategyCard.clear();
        mRecommendStrategyCard.addAll(recommendStrategy.getData());
        mRecommendStrategyAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void updateCardItem(int position, HeroGroupListBean bean) {
        mNews.add(position, bean);
        mAdapter.notifyDataSetChanged();
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
                holder.setImagePath(R.id.iv_bg, new AbstractImageLoader(card.getImage_url_small()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };

        mRecommendStrategyCard = new ArrayList<>();
        mRecommendStrategyAdapter = new BasicAdapter<Card>(R.layout.item_recommend_strategy, mRecommendStrategyCard, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, Card card, int position) {
                holder.setText(R.id.tv_publication_date, card.getPublication_date());
                holder.setText(R.id.tv_pv, card.getPv());
                holder.setText(R.id.tv_video_title, card.getTitle());
                holder.setImagePath(R.id.iv_article_small, new AbstractImageLoader(card.getImage_url_small()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };

        mPlayShowCard = new ArrayList<>();
        mPlayShowAdapter = new BasicAdapter<Card>(R.layout.item_play_show, mPlayShowCard, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, Card card, int position) {
                holder.setText(R.id.tv_user_nick_name, card.getGame_nick());
                holder.setText(R.id.tv_user_rank, card.getRank());
                holder.setText(R.id.tv_content, card.getContent());
                holder.setImagePath(R.id.iv_user_logo, new AbstractImageLoader(card.getLogo_url()) {
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
        mAdapter = new BasicAdapter<HeroGroupListBean>(mNews, getActivity(), mMultipleTypeSupport) {
            @Override
            protected void bindData(BasicViewHolder holder, HeroGroupListBean bean, int position) {
                if ("RecentHeroCard".equals(bean.getType())) {
                    mRvRecentHero = holder.getView(R.id.rv_recent_hero);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvRecentHero.setLayoutManager(linearLayoutManager);
                    mRvRecentHero.setAdapter(mRecentHeroAdapter);
                    return;
                }
                if ("RecommendStrategyCard".equals(bean.getType())) {
                    mRvRecommendStrategy = holder.getView(R.id.rv_recommend_strategy);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvRecommendStrategy.setLayoutManager(linearLayoutManager);
                    mRvRecommendStrategy.setAdapter(mRecommendStrategyAdapter);
                    return;
                }
                if ("PlayerShowCard".equals(bean.getType())) {
                    mRvPlayShow = holder.getView(R.id.rv_player_show);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvPlayShow.setLayoutManager(linearLayoutManager);
                    mRvPlayShow.setAdapter(mPlayShowAdapter);
                    return;
                }
                if ("BattleVideosCard".equals(bean.getType())) {
                    mRvBattleVideo = holder.getView(R.id.rv_hero_battle_video);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvBattleVideo.setLayoutManager(linearLayoutManager);
                    mRvBattleVideo.setAdapter(mBattleVideoAdapter);
                    return;
                }

                holder.setText(R.id.tv_article_title, bean.getNews().getTitle());
                holder.setText(R.id.tv_article_summary, bean.getNews().getSummary());
                holder.setText(R.id.tv_article_pv, bean.getNews().getPv());
                holder.setImagePath(R.id.iv_article, new AbstractImageLoader(bean.getNews().getImage_url_small()) {
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
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNews();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mRefreshLayout.autoRefresh();
    }

}
