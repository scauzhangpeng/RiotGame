package org.scau.riotgame.home.contract;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import org.scau.riotgame.home.bean.HotMatch;
import org.scau.riotgame.home.bean.News;

import java.util.List;

/**
 * Created by ZP on 2018/11/18.
 */
public interface ColumnListDetailContract {
    interface View extends BaseView {

        void showNewsList(List<News> news);

        void showMoreNewsList(List<News> news);

        void setEnableLoadMore(boolean enableLoadMore);

        void showHotMatchList(List<HotMatch> hotMatches);

        void showMoreHotMatchList(List<HotMatch> hotMatches);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews(String cid);

        public abstract void loadMoreNews(String cid);

        public abstract void refreshHotMatch(String cid);

        public abstract void loadMoreHotMatch(String cid);
    }
}
