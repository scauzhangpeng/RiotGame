package com.muugi.riot.news.contract;


import com.muugi.riot.news.base.BaseNewsContract;
import com.muugi.riot.news.bean.SpecialColumnListBean;
import com.muugi.riot.news.model.NewsRepository;


/**
 * Created by ZP on 2017/8/23.
 */

public interface ColumnContract {

    interface View extends BaseNewsContract.View<SpecialColumnListBean> {
    }

    abstract class Presenter extends BaseNewsContract.Presenter<View> {
        public Presenter(String cid, NewsRepository mNewsRepository) {
            super(cid, mNewsRepository);
        }
    }
}
