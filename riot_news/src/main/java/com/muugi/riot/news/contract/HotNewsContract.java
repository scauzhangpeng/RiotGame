package com.muugi.riot.news.contract;

import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.presenter.BaseNewsPresenter;
import com.xyz.riotcommon.SimpleRefreshView;


/**
 * Created by ZP on 2018/11/10.
 */
public interface HotNewsContract {


    interface View extends SimpleRefreshView<News> {
    }

    abstract class Presenter extends BaseNewsPresenter<View> {
        public Presenter(String cid) {
            super(cid);
        }
    }
}
