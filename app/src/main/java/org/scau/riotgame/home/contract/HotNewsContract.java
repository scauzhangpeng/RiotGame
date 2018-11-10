package org.scau.riotgame.home.contract;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import org.scau.riotgame.home.bean.News;

import java.util.List;

/**
 * Created by ZP on 2018/11/10.
 */
public interface HotNewsContract {


    interface View extends BaseView {
        void showHotNewsList(List<News> news);

        void showMoreHotNewsList(int currentPage, List<News> news);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews();

        public abstract void loadMoreNews();
    }
}
