package com.muugi.riot.news.base;

import com.muugi.riot.news.model.NewsRepository;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleRefreshView;

/**
 * Created by ZP on 2019/2/26.
 */
public interface BaseNewsContract {

    interface View<T> extends SimpleRefreshView<T> {
    }

    abstract class Presenter<V extends SimpleRefreshView> extends BasePresenter<V> {
        protected String cid;
        protected int mCurrentPage = 0;
        protected NewsRepository mNewsRepository;

        public Presenter(String cid, NewsRepository mNewsRepository) {
            this.cid = cid;
            this.mNewsRepository = mNewsRepository;
        }


        public abstract void loadMoreNews();

        public void refreshNews() {
            mCurrentPage = 0;
            getView().setEnableLoadMore(true);
            loadMoreNews();
        }
    }
}
