package com.muugi.riot.news.contract;

import com.muugi.riot.news.bean.NewVersionCardItem;
import com.muugi.riot.news.bean.NewVersionListBean;
import com.muugi.riot.news.presenter.BaseNewsPresenter;
import com.xyz.riotcommon.SimpleRefreshView;


/**
 * Created by ZP on 2018/1/24.
 */

public interface NewVersionContract {

    interface View extends SimpleRefreshView<NewVersionListBean> {

        void showNewVersionHero(NewVersionCardItem cards);

        void showNewVersionSkin(NewVersionCardItem cards);

        void updateCardItem(int position, NewVersionListBean bean);
    }

    abstract class Presenter extends BaseNewsPresenter<View> {

        public Presenter(String cid) {
            super(cid);
        }

        public abstract void requestNewVersionCard();
    }
}
