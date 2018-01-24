package org.scau.riotgame.home.contract;


import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import org.scau.riotgame.home.bean.News;

import java.util.List;

/**
 * Created by ZP on 2017/8/17.
 */

public interface NewsContract {

    interface View extends BaseView {
        void showNewsList(List<News> news);

        void showMoreNewsList(int currentPage, List<News> news);

        void showBannerNewsList(List<News> bannerNews);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews();

        public abstract void loadMoreNews();

        public abstract void refreshBannerNews();
    }
}
