package com.muugi.riot.news.contract;


import com.muugi.riot.news.bean.HotAuthor;
import com.muugi.riot.news.bean.HotEnter;
import com.muugi.riot.news.bean.HotHero;
import com.muugi.riot.news.bean.HotMatch;
import com.muugi.riot.news.bean.HotWpv;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.util.List;

/**
 * Created by ZP on 2017/8/24.
 */

public interface VideoContract {

    interface View extends BaseView {
        void showHotAuthorList(List<HotAuthor> hotAuthors);

        void showHotWpvList(List<HotWpv> hotWpvs);

        void showHotEnterList(List<HotEnter> hotEnters);

        void showHotMatchList(List<HotMatch> hotMatches);

        void showHotMatchTop(HotMatch hotMatch);

        void showHotHeroList(List<HotHero> hotHeroes);

        void showWholeVideoList(List<HotMatch> result);

        void showMoreWholeVideoList(int currentPage, List<HotMatch> result);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getVideoDataHotRec();

        public abstract void requestVideoDataWhole();

        public abstract void loadMoreVideoDataWhole();
    }
}
