package com.muugi.riot.news.contract;

import com.muugi.riot.news.base.BaseNewsContract;
import com.muugi.riot.news.bean.NewVersionCardItem;
import com.muugi.riot.news.bean.NewVersionListBean;
import com.muugi.riot.news.model.NewsRepository;


/**
 * Created by ZP on 2018/1/24.
 */

public interface NewVersionContract {

    interface View extends BaseNewsContract.View<NewVersionListBean> {

        void showNewVersionHero(NewVersionCardItem cards);

        void showNewVersionSkin(NewVersionCardItem cards);

        void showNewsVersionScan(NewVersionCardItem cards);

        void showNewsVersionAbout(NewVersionCardItem cards);

        void updateCardItem(int position, NewVersionListBean bean);
    }

    abstract class Presenter extends BaseNewsContract.Presenter<View> {
        public Presenter(String cid, NewsRepository mNewsRepository) {
            super(cid, mNewsRepository);
        }

        public abstract void requestNewVersionCard();
    }
}
