package org.scau.riotgame.home.presenter;

import org.scau.riotgame.home.bean.Feature;
import org.scau.riotgame.home.bean.GameCenterData;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.bean.PageResponse;
import org.scau.riotgame.home.contract.MatchContract;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class MatchPresenter extends MatchContract.Presenter {
    private int mCurrentPage = 0;

    @Override
    public void gameCenterData() {
        RequestManager.getInstance().getGameCenterData("android", 9738, new HttpCallback<GameCenterData>() {
            @Override
            public void doOnSuccess(Response<GameCenterData> response) {
                List<Feature> normal_features = response.body().getNormal_features();
                if (normal_features != null) {
                    getView().showMatchHeaderMenu(normal_features);
                }

                List<Feature> gallery_features = response.body().getGallery_features();
                if (gallery_features != null) {
                    getView().showMatchHeaderGallery(gallery_features);
                }
            }

            @Override
            public void doOnError(Response<GameCenterData> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }

    @Override
    public void getNews() {
        mCurrentPage = 0;
        loadMoreNews();
    }


    @Override
    public void loadMoreNews() {
        RequestManager.getInstance().getNews(73, mCurrentPage, "android", 9738, new HttpCallback<PageResponse<News>>() {
            @Override
            public void doOnSuccess(Response<PageResponse<News>> response) {
                if (response.body() != null) {
                    List<News> list = response.body().getList();
                    if (list != null && list.size() != 0) {
                        if (mCurrentPage == 0) {
                            getView().showRefreshMatchNews(list);
                        } else {
                            getView().showMoreMatchNews(list);
                        }
                        mCurrentPage++;
                    } else {
                        System.out.println("null list");
                    }
                }
            }

            @Override
            public void doOnError(Response<PageResponse<News>> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }
}
