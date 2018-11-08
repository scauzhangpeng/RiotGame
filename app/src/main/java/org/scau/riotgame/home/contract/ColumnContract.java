package org.scau.riotgame.home.contract;


import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import org.scau.riotgame.home.ListColumnListWrapper;

import java.util.List;

/**
 * Created by ZP on 2017/8/23.
 */

public interface ColumnContract {

    interface View extends BaseView {
        void showColumnList(List<ListColumnListWrapper> news);

        void showMoreColumnList(int currentPage, List<ListColumnListWrapper> news);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void refreshNews();

        public abstract void loadMoreNews();
    }
}
