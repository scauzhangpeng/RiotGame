package com.muugi.riot.news.contract;


import com.muugi.riot.news.bean.SpecialColumnListBean;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleRefreshView;


/**
 * Created by ZP on 2017/8/23.
 */

public interface ColumnContract {

    interface View extends SimpleRefreshView<SpecialColumnListBean> {
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews();

        public abstract void loadMoreNews();
    }
}
