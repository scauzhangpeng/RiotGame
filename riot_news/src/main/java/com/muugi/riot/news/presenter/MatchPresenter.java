package com.muugi.riot.news.presenter;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.Feature;
import com.muugi.riot.news.bean.GameCenterData;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.MatchContract;
import com.muugi.riot.news.model.NewsRepository;
import com.muugi.riot.news.model.RequestManager;
import com.xyz.riotcommon.bean.PageResponse;
import com.xyz.riotcommon.net.HttpCallback;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class MatchPresenter extends MatchContract.Presenter {
    public MatchPresenter(String cid, NewsRepository mNewsRepository) {
        super(cid, mNewsRepository);
    }

    @Override
    public void gameCenterData() {
        RequestManager.getInstance().getGameCenterData(9738, new HttpCallback<GameCenterData>() {
            @Override
            public void doOnSuccess(@NonNull GameCenterData gameCenterData, Response<GameCenterData> response) {
                List<Feature> normal_features = gameCenterData.getNormal_features();
                if (normal_features != null) {
                    getView().showMatchHeaderMenu(normal_features);
                }

                List<Feature> gallery_features = gameCenterData.getGallery_features();
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
    public void refreshNews() {
        mCurrentPage = 0;
        loadMoreNews();
    }


    @Override
    public void loadMoreNews() {
        RequestManager.getInstance().getNews(cid, mCurrentPage, 9738, new HttpCallback<PageResponse<News>>() {
            @Override
            public void doOnSuccess(@NonNull PageResponse<News> newsPageResponse, Response<PageResponse<News>> response) {
                List<News> list = newsPageResponse.getList();
                if (list != null && list.size() != 0) {
                    if (mCurrentPage == 0) {
                        getView().showListData(list);
                    } else {
                        getView().showMoreListData(mCurrentPage, list);
                    }
                    mCurrentPage++;
                } else {
                    System.out.println("null list");
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
