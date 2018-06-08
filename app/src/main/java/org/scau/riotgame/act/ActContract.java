package org.scau.riotgame.act;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import org.scau.riotgame.act.bean.ActDetail;

import java.util.List;

/**
 * Created by ZP on 2018/6/8.
 */

public interface ActContract {

    interface View extends BaseView {
        void showRefreshActDetailList(List<ActDetail> actDetails);

        void showLoadMoreActDetailList(List<ActDetail> actDetails);

        void setLoadMoreEnable(boolean isEnable);
    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void getRefresh();

        abstract void getLoadMore();
    }
}
