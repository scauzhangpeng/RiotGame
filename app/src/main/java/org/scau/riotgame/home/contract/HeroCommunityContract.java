package org.scau.riotgame.home.contract;


import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import org.scau.riotgame.home.bean.Card;
import org.scau.riotgame.home.bean.News;

import java.util.List;

/**
 * Created by ZP on 2017/9/8.
 */

public interface HeroCommunityContract {


    interface View extends BaseView {
        void showNewsList(List<News> news);

        void showMoreNewsList(int currentPage, List<News> news);

        void showBattleVideo(List<Card> battleVideoCard);

        void showRecentHero(List<Card> recentHero);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews();

        public abstract void loadMoreNews();

        public abstract void refreshCardsData();
    }
}
