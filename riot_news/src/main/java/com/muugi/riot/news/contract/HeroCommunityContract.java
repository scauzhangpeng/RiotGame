package com.muugi.riot.news.contract;


import com.muugi.riot.news.bean.CardItem;
import com.muugi.riot.news.bean.HeroGroupListBean;
import com.muugi.riot.news.presenter.BaseNewsPresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.util.List;


/**
 * Created by ZP on 2017/9/8.
 */

public interface HeroCommunityContract {


    interface View extends BaseView {
        void showNewsList(List<HeroGroupListBean> news);

        void showMoreNewsList(int currentPage, List<HeroGroupListBean> news);

        void showBattleVideoCard(CardItem battleVideoCard);

        void showRecentHeroCard(CardItem recentHero);

        void showRecommendStrategyCard(CardItem recommendStrategy);

        void showPlayerShowCard(CardItem playerShow);

        void updateCardItem(int position, HeroGroupListBean bean);
    }

    abstract class Presenter extends BaseNewsPresenter<View> {

        public Presenter(String cid) {
            super(cid);
        }

        public abstract void refreshCardsData();
    }
}
