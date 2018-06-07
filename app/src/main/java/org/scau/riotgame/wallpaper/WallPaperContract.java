package org.scau.riotgame.wallpaper;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import org.scau.riotgame.wallpaper.bean.WallPaperDetail;

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
        abstract void getRefreshWallPaper();

        abstract void getLoadMoreWallPaper();
    }
}
