package com.muugi.riot.news.view;

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
import com.muugi.riot.news.base.BaseNewsFragment;
import com.muugi.riot.news.bean.Card;
import com.muugi.riot.news.bean.CardItem;
import com.muugi.riot.news.bean.HeroGroupListBean;
import com.muugi.riot.news.contract.HeroCommunityContract;
import com.muugi.riot.news.model.Injection;
import com.muugi.riot.news.presenter.HeroCommunityPresenter;
import com.muugi.riot.news.utils.FormatUtil;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.basiclib.util.DateUtil;
import com.xyz.riotcommon.ImageLoadUtil;
import com.xyz.riotcommon.RouterConstants;
import com.xyz.riotcommon.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.xyz.basiclib.util.DateUtil.DATE_FORMAT_DAY;
import static com.xyz.basiclib.util.DateUtil.DATE_FORMAT_MONTH_DAY;
import static com.xyz.basiclib.util.DateUtil.DATE_FORMAT_SEC;


/**
 * Created by ZP on 2018/1/24.
 */
@Route(path = RouterConstants.NEWS_HERO_COMMUNITY)
public class HeroCommunityFragment extends BaseNewsFragment<HeroGroupListBean, HeroCommunityContract.View, HeroCommunityContract.Presenter> implements HeroCommunityContract.View {


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

    /**
     * 本周限免
     */
    private RecyclerView mRvWeekFreeHero;
    private BasicAdapter<Card> mWeekFreeHeroAdapter;
    private List<Card> mWeekFreeHeroCard;

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

            if ("WeekFreeHeroCard".equals(heroGroupListBean.getType())) {
                return R.layout.layout_hero_community_week_free;
            }

            return R.layout.item_hero_group;
        }
    };

    @Override
    public BasicAdapter<HeroGroupListBean> getAdapter() {
        return new BasicAdapter<HeroGroupListBean>(mData, getActivity(), mMultipleTypeSupport) {
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
                    HashMap<String, String> header = bean.getHeader();
                    holder.setText(R.id.tv_hero_desc, getString(R.string.hero_time_desc, header.get("hero")));
                    mRvRecommendStrategy = holder.getView(R.id.rv_recommend_strategy);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvRecommendStrategy.setLayoutManager(linearLayoutManager);
                    mRvRecommendStrategy.setAdapter(mRecommendStrategyAdapter);
                    return;
                }
                if ("PlayerShowCard".equals(bean.getType())) {
                    HashMap<String, String> header = bean.getHeader();
                    holder.setText(R.id.tv_hero_desc, getString(R.string.hero_time_desc, header.get("hero")));
                    mRvPlayShow = holder.getView(R.id.rv_player_show);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvPlayShow.setLayoutManager(linearLayoutManager);
                    mRvPlayShow.setAdapter(mPlayShowAdapter);
                    return;
                }
                if ("BattleVideosCard".equals(bean.getType())) {
                    HashMap<String, String> header = bean.getHeader();
                    holder.setText(R.id.tv_hero_desc, getString(R.string.hero_time_desc, header.get("hero")));
                    mRvBattleVideo = holder.getView(R.id.rv_hero_battle_video);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvBattleVideo.setLayoutManager(linearLayoutManager);
                    mRvBattleVideo.setAdapter(mBattleVideoAdapter);
                    return;
                }

                if ("WeekFreeHeroCard".equals(bean.getType())) {
                    mRvWeekFreeHero = holder.getView(R.id.rv_community_hero_week_free);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvWeekFreeHero.setLayoutManager(linearLayoutManager);
                    mRvWeekFreeHero.setAdapter(mWeekFreeHeroAdapter);
                    return;
                }

                holder.setText(R.id.tv_article_title, bean.getNews().getTitle());
                holder.setText(R.id.tv_article_summary, bean.getNews().getSummary());
                holder.setText(R.id.tv_article_pv, FormatUtil.unitToTenThousand(bean.getNews().getPv()));
                holder.setImagePath(R.id.iv_article, new AbstractImageLoader(bean.getNews().getImage_url_small()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });

            }
        };
    }

    @Override
    public void onItemClick(View view, int position) {
        if ("news".equals(mData.get(position).getType())) {
            Bundle bundle = new Bundle();
            bundle.putString("url", mData.get(position).getNews().getArticle_url());
            openActivity(WebViewActivity.class, bundle);
        }
    }

    @Override
    public void showListData(List<HeroGroupListBean> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
        mPresenter.refreshCardsData();
    }

    @Override
    public void showBattleVideoCard(CardItem battleVideoCard) {
        mBattleVideoCard.clear();
        mBattleVideoCard.addAll(battleVideoCard.getData());
        mBattleVideoAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showRecentHeroCard(CardItem recentHero) {
        mRecentHeroCard.clear();
        mRecentHeroCard.addAll(recentHero.getData());
        mRecentHeroAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showPlayerShowCard(CardItem playerShow) {
        mPlayShowCard.clear();
        mPlayShowCard.addAll(playerShow.getData());
        mPlayShowAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showRecommendStrategyCard(CardItem recommendStrategy) {
        mRecommendStrategyCard.clear();
        mRecommendStrategyCard.addAll(recommendStrategy.getData());
        mRecommendStrategyAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showWeekFreeHero(CardItem weekFreeHero) {
        mWeekFreeHeroCard.clear();
        mWeekFreeHeroCard.addAll(weekFreeHero.getData());
        mWeekFreeHeroAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void updateCardItem(int position, HeroGroupListBean bean) {
        mData.add(position, bean);
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
                holder.setText(R.id.tv_publication_date, DateUtil.strToStr(card.getPublication_date(), DATE_FORMAT_SEC, DATE_FORMAT_DAY));
                holder.setText(R.id.tv_pv, FormatUtil.unitToTenThousand(card.getPv()));
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
                holder.setText(R.id.tv_praise_num, getString(R.string.praise_num, card.getPraise_num()));
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
                String newstype = card.getNewstype();
                if (TextUtils.isEmpty(newstype)) {
                    holder.setVisibility(R.id.tv_news_type, View.GONE);
                } else {
                    holder.setVisibility(R.id.tv_news_type, View.VISIBLE);
                    holder.setText(R.id.tv_news_type, newstype);
                }

                holder.setText(R.id.tv_video_len, card.getV_len());
                String date = DateUtil.strToStr(card.getPublication_date(), DATE_FORMAT_SEC, DATE_FORMAT_MONTH_DAY);
                holder.setText(R.id.tv_publication_date, date);
                holder.setText(R.id.tv_pv, FormatUtil.formatVideoPv(card.getPv()));
                holder.setImagePath(R.id.iv_battle_video_header, new AbstractImageLoader(card.getImage_url_small()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };

        mWeekFreeHeroCard = new ArrayList<>();
        mWeekFreeHeroAdapter = new BasicAdapter<Card>(R.layout.item_community_hero_week_free, mWeekFreeHeroCard, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, Card card, int position) {
                holder.setText(R.id.tv_hero_nickname, card.getHero_nick() + " " + card.getHero_name());
                holder.setText(R.id.tv_hero_rank, card.getWin_rate());
                holder.setImagePath(R.id.iv_hero_icon, new AbstractImageLoader(card.getImage_url_small()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };
    }

    @Override
    protected HeroCommunityContract.Presenter initPresenter() {
        return new HeroCommunityPresenter("", Injection.provideNewsRepository());
    }

}
