package com.muugi.riot.news.contract;

import com.muugi.riot.news.base.BaseNewsContract;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.model.NewsRepository;


/**
 * Created by ZP on 2018/11/10.
 */
public interface OfficialNewsContract {


    interface View extends BaseNewsContract.View<News> {

    }

    abstract class Presenter extends BaseNewsContract.Presenter<View> {
        public Presenter(String cid, NewsRepository mNewsRepository) {
            super(cid, mNewsRepository);
        }
    }
}
