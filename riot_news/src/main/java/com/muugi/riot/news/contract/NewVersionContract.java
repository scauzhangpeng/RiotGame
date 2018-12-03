package com.muugi.riot.news.contract;

import com.muugi.riot.news.bean.NewVersionCardItem;
import com.muugi.riot.news.bean.NewVersionListBean;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.util.List;


/**
 * Created by ZP on 2018/1/24.
 */

public interface NewVersionContract {

    interface View extends BaseView {
        void showNewVersionNews(List<NewVersionListBean> news);

        void showMoreNewVersionNews(int currentPage, List<NewVersionListBean> news);

        void showNewVersionHero(NewVersionCardItem cards);

        void showNewVersionSkin(NewVersionCardItem cards);

        void updateCardItem(int position, NewVersionListBean bean);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void requestNewVersionNews();

        public abstract void loadMoreNewVersionNews();

        public abstract void requestNewVersionCard();
    }
}
