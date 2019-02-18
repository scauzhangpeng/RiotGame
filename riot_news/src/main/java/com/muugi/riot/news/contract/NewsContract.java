package com.muugi.riot.news.contract;


import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.presenter.BaseNewsPresenter;
import com.xyz.riotcommon.SimpleRefreshView;

import java.util.List;

/**
 * Created by ZP on 2017/8/17.
 */

public interface NewsContract {

    interface View extends SimpleRefreshView<News> {
        void showBannerNewsList(List<News> bannerNews);
    }

    abstract class Presenter extends BaseNewsPresenter<View> {

        public Presenter(String cid) {
            super(cid);
        }

        public abstract void refreshBannerNews();
    }
}
