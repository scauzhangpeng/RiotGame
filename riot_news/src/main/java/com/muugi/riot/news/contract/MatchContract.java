package com.muugi.riot.news.contract;

import com.muugi.riot.news.bean.Feature;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.presenter.BaseNewsPresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.util.List;

/**
 * Created by ZP on 2017/9/1.
 */

public interface MatchContract {

    interface View extends BaseView {
        void showMatchHeaderMenu(List<Feature> features);

        void showMatchHeaderGallery(List<Feature> features);

        void showRefreshMatchNews(List<News> news);

        void showMoreMatchNews(List<News> news);
    }

    abstract class Presenter extends BaseNewsPresenter<View> {
        public Presenter(String cid) {
            super(cid);
        }

        public abstract void gameCenterData();

    }
}
