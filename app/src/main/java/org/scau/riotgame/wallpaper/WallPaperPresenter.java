package org.scau.riotgame.wallpaper;

import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;
import org.scau.riotgame.wallpaper.bean.KindWallPaper;
import org.scau.riotgame.wallpaper.bean.WallPaper;
import org.scau.riotgame.wallpaper.bean.WallPaperDetail;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/29.
 */

public class WallPaperPresenter extends WallPaperContract.Presenter {


    private int page = -1;
    private int num = 20;
    private String mType;
    private String mKind;

    public WallPaperPresenter(String type) {
        this.mType = type;
    }

    public WallPaperPresenter(String type, String kind) {
        this.mType = type;
        this.mKind = kind;
    }

    @Override
    void getRefreshWallPaper() {
        page = -1;
        getLoadMoreWallPaper();
    }

    @Override
    void getLoadMoreWallPaper() {
        if ("type".equals(mType)) {
            RequestManager.getInstance().getTypeWallPaper(++page, num, new HttpCallback<KindWallPaper>() {
                @Override
                public void doOnSuccess(Response<KindWallPaper> response) {
                    List<WallPaperDetail> wallpapers = response.body().getCategories();
                    if (page == 0) {
                        getView().showRefreshWallPaper(wallpapers);
                    } else {
                        getView().showMoreWallPaper(wallpapers);
                    }
                    if (response.body().getHasnext() == 0) {
                        getView().setLoadMoreEnable(false);
                    }
                }

                @Override
                public void doOnError(Response<KindWallPaper> response, String statusCode, String message) {

                }

                @Override
                public void doOnFailure(int httpCode, String message) {

                }
            });
        } else if ("kind".equals(mType)) {
            RequestManager.getInstance().getWallPaperByKind(mKind, ++page, num, new HttpCallback<WallPaper>() {
                @Override
                public void doOnSuccess(Response<WallPaper> response) {
                    List<WallPaperDetail> wallpapers = response.body().getWallpapers();
                    if (page == 0) {
                        getView().showRefreshWallPaper(wallpapers);
                    } else {
                        getView().showMoreWallPaper(wallpapers);
                    }
                    if (response.body().getHasnext() == 0) {
                        getView().setLoadMoreEnable(false);
                    }
                }

                @Override
                public void doOnError(Response<WallPaper> response, String statusCode, String message) {

                }

                @Override
                public void doOnFailure(int httpCode, String message) {

                }
            });
        } else {
            RequestManager.getInstance().getWallPaper(mType, ++page, num, new HttpCallback<WallPaper>() {
                @Override
                public void doOnSuccess(Response<WallPaper> response) {
                    List<WallPaperDetail> wallpapers = response.body().getWallpapers();
                    if (page == 0) {
                        getView().showRefreshWallPaper(wallpapers);
                    } else {
                        getView().showMoreWallPaper(wallpapers);
                    }
                    if (response.body().getHasnext() == 0) {
                        getView().setLoadMoreEnable(false);
                    }
                }

                @Override
                public void doOnError(Response<WallPaper> response, String statusCode, String message) {

                }

                @Override
                public void doOnFailure(int httpCode, String message) {

                }
            });
        }
    }
}
