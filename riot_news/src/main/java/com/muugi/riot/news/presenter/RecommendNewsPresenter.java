package com.muugi.riot.news.presenter;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.RecommendNewsContract;
import com.muugi.riot.news.model.NewsDataSource;
import com.muugi.riot.news.model.NewsRepository;
import com.muugi.riot.news.model.RequestManager;
import com.xyz.riotcommon.bean.PageResponse;
import com.xyz.riotcommon.net.HttpCallback;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2017/8/16.
 */

public class RecommendNewsPresenter extends RecommendNewsContract.Presenter {

    public RecommendNewsPresenter(String cid, NewsRepository mNewsRepository) {
        super(cid, mNewsRepository);
    }


    @Override
    public void loadMoreNews() {
        mNewsRepository.loadNewsData(cid, mCurrentPage, new NewsDataSource.LoadNewsCallback() {
            @Override
            public void onNewsLoadSuccess(List<News> data, PageResponse<News> pageResponse, int type) {
                if (mCurrentPage == 0) {
                    if (isViewAttach()) {
                        getView().showListData(data);
                    }
                } else {
                    if (isViewAttach()) {
                        getView().showMoreListData(mCurrentPage, data);
                    }
                }

                if ("True".equals(pageResponse.getNext())) {
                    mCurrentPage++;
                } else {
                    if (isViewAttach()) {
                        getView().setEnableLoadMore(false);
                    }
                }
            }

            @Override
            public void onNewsLoadEmpty(int type) {

            }

            @Override
            public void onNewsLoadError(String code, String message, int type) {

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
