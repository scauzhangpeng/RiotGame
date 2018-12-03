package com.muugi.riot.news.contract;

import com.muugi.riot.news.bean.News;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.util.List;


/**
 * Created by ZP on 2018/11/10.
 */
public interface OfficialNewsContract {


    interface View extends BaseView {
        void showOfficialNewsList(List<News> news);

        void showMoreOfficialNewsList(int currentPage, List<News> news);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews();

        public abstract void loadMoreNews();
    }
}
