package com.muugi.riot.news.contract;


import com.muugi.riot.news.bean.News;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleRefreshView;

import java.util.List;

/**
 * Created by ZP on 2017/8/17.
 */

public interface NewsContract {

    interface View extends SimpleRefreshView<News> {
        void showBannerNewsList(List<News> bannerNews);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews();

        public abstract void loadMoreNews();

        public abstract void refreshBannerNews();
    }
}
