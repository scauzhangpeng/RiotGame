package com.muugi.riot.discovery.wallpaper;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import com.muugi.riot.discovery.wallpaper.bean.WallPaperDetail;

import java.util.List;

/**
 * Created by ZP on 2018/1/29.
 */

public interface WallPaperContract {

    interface View extends BaseView {
        void showRefreshWallPaper(List<WallPaperDetail> wallPapersDetail);

        void showMoreWallPaper(List<WallPaperDetail> wallPapersDetail);

        void setLoadMoreEnable(boolean isEnable);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getRefreshWallPaper();

        public abstract void getLoadMoreWallPaper();
    }
}
