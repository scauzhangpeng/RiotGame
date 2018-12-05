package com.muugi.riot.discovery.wallpaper;

import android.support.annotation.NonNull;

import com.muugi.riot.discovery.main.model.RequestManager;
import com.muugi.riot.discovery.wallpaper.bean.KindWallPaper;
import com.muugi.riot.discovery.wallpaper.bean.WallPaper;
import com.muugi.riot.discovery.wallpaper.bean.WallPaperDetail;
import com.xyz.riotcommon.net.HttpCallback;

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
    public void getRefreshWallPaper() {
        page = -1;
        getLoadMoreWallPaper();
    }

    @Override
    public void getLoadMoreWallPaper() {
        if ("type".equals(mType)) {
            RequestManager.getInstance().getTypeWallPaper(++page, num, new HttpCallback<KindWallPaper>() {
                @Override
                public void doOnSuccess(@NonNull KindWallPaper kindWallPaper, Response<KindWallPaper> response) {
                    List<WallPaperDetail> wallpapers = kindWallPaper.getCategories();
                    if (page == 0) {
                        getView().showRefreshWallPaper(wallpapers);
                    } else {
                        getView().showMoreWallPaper(wallpapers);
                    }
                    if (kindWallPaper.getHasnext() == 0) {
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
                public void doOnSuccess(@NonNull WallPaper wallPaper, Response<WallPaper> response) {
                    List<WallPaperDetail> wallpapers = wallPaper.getWallpapers();
                    if (page == 0) {
                        getView().showRefreshWallPaper(wallpapers);
                    } else {
                        getView().showMoreWallPaper(wallpapers);
                    }
                    if (wallPaper.getHasnext() == 0) {
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
                public void doOnSuccess(@NonNull WallPaper wallPaper, Response<WallPaper> response) {
                    List<WallPaperDetail> wallpapers = wallPaper.getWallpapers();
                    if (page == 0) {
                        getView().showRefreshWallPaper(wallpapers);
                    } else {
                        getView().showMoreWallPaper(wallpapers);
                    }
                    if (wallPaper.getHasnext() == 0) {
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
