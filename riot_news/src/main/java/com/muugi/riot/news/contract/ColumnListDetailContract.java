package com.muugi.riot.news.contract;

import com.muugi.riot.news.bean.HotMatch;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.presenter.BaseNewsPresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.util.List;

/**
 * Created by ZP on 2018/11/18.
 */
public interface ColumnListDetailContract {
    interface View extends BaseView {

        void showNewsList(List<News> news);

        void showMoreNewsList(List<News> news);

        void setEnableLoadMore(boolean enableLoadMore);

        void showHotMatchList(List<HotMatch> hotMatches);

        void showMoreHotMatchList(List<HotMatch> hotMatches);
    }

    abstract class Presenter extends BaseNewsPresenter<View> {
        public Presenter(String cid) {
            super(cid);
        }

        public abstract void refreshHotMatch(String cid);

        public abstract void loadMoreHotMatch(String cid);
    }
}
