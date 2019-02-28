package com.muugi.riot.news.contract;


import com.muugi.riot.news.base.BaseNewsContract;
import com.muugi.riot.news.bean.CardItem;
import com.muugi.riot.news.bean.HeroGroupListBean;
import com.muugi.riot.news.model.NewsRepository;


/**
 * Created by ZP on 2017/9/8.
 */

public interface HeroCommunityContract {


    interface View extends BaseNewsContract.View<HeroGroupListBean> {

        void showBattleVideoCard(CardItem battleVideoCard);

        void showRecentHeroCard(CardItem recentHero);

        void showRecommendStrategyCard(CardItem recommendStrategy);

        void showPlayerShowCard(CardItem playerShow);

        void showWeekFreeHero(CardItem weekFreeHero);

        void updateCardItem(int position, HeroGroupListBean bean);
    }

    abstract class Presenter extends BaseNewsContract.Presenter<View> {
        public Presenter(String cid, NewsRepository mNewsRepository) {
            super(cid, mNewsRepository);
        }

        public abstract void refreshCardsData();
    }
}
