package com.muugi.riot.news.contract;


import com.muugi.riot.news.bean.SpecialColumnListBean;
import com.muugi.riot.news.presenter.BaseNewsPresenter;
import com.xyz.riotcommon.SimpleRefreshView;


/**
 * Created by ZP on 2017/8/23.
 */

public interface ColumnContract {

    interface View extends SimpleRefreshView<SpecialColumnListBean> {
    }

    abstract class Presenter extends BaseNewsPresenter<View> {
        public Presenter(String cid) {
            super(cid);
        }
    }
}
