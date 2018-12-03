package com.muugi.riot.news.contract;


import com.muugi.riot.news.bean.SpecialColumnListBean;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.util.List;


/**
 * Created by ZP on 2017/8/23.
 */

public interface ColumnContract {

    interface View extends BaseView {
        void showColumnList(List<SpecialColumnListBean> news);

        void showMoreColumnList(int currentPage, List<SpecialColumnListBean> news);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews();

        public abstract void loadMoreNews();
    }
}
