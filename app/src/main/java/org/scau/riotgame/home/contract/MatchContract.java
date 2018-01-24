package org.scau.riotgame.home.contract;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import org.scau.riotgame.home.bean.Feature;
import org.scau.riotgame.home.bean.News;

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

    abstract class Presenter extends BasePresenter<View> {
        public abstract void gameCenterData();

        public abstract void getNews();

        public abstract void loadMoreNews();
    }
}
