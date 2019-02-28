package com.muugi.riot.news.contract;

import com.muugi.riot.news.base.BaseNewsContract;
import com.muugi.riot.news.bean.Feature;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.model.NewsRepository;

import java.util.List;

/**
 * Created by ZP on 2017/9/1.
 */

public interface MatchContract {

    interface View extends BaseNewsContract.View<News> {
        void showMatchHeaderMenu(List<Feature> features);

        void showMatchHeaderGallery(List<Feature> features);
    }

    abstract class Presenter extends BaseNewsContract.Presenter<View> {
        public Presenter(String cid, NewsRepository mNewsRepository) {
            super(cid, mNewsRepository);
        }

        public abstract void gameCenterData();

    }
}
