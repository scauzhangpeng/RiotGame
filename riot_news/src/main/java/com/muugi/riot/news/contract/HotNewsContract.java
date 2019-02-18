package com.muugi.riot.news.contract;

import com.muugi.riot.news.bean.News;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleRefreshView;


/**
 * Created by ZP on 2018/11/10.
 */
public interface HotNewsContract {


    interface View extends SimpleRefreshView<News> {
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews();

        public abstract void loadMoreNews();
    }
}
