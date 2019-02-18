package com.muugi.riot.news.presenter;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.NewsContract;
import com.muugi.riot.news.model.RequestManager;
import com.xyz.riotcommon.bean.PageResponse;
import com.xyz.riotcommon.net.HttpCallback;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2017/8/16.
 */

public class NewsPresenter extends NewsContract.Presenter {

    private int mCurrentPage = 0;

    public NewsPresenter(String cid) {
        super(cid);
    }

    @Override
    public void refreshNews() {
        mCurrentPage = 0;
        loadMoreNews();
    }

    @Override
    public void loadMoreNews() {
        RequestManager.getInstance().getNews(cid, mCurrentPage, 9740, new HttpCallback<PageResponse<News>>() {

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

    @Override
    public void refreshBannerNews() {
        RequestManager.getInstance().getNews("13", 0, 9738, new HttpCallback<PageResponse<News>>() {
            @Override
            public void doOnSuccess(@NonNull PageResponse<News> newsPageResponse, Response<PageResponse<News>> response) {
                List<News> list = newsPageResponse.getList();
                if (list != null && list.size() != 0) {
                    getView().showBannerNewsList(list);
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
