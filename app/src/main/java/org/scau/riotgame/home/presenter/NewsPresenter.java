package org.scau.riotgame.home.presenter;

import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.bean.PageResponse;
import org.scau.riotgame.home.contract.NewsContract;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2017/8/16.
 */

public class NewsPresenter extends NewsContract.Presenter {

    private int mCurrentPage = 0;

    @Override
    public void refreshNews() {
        mCurrentPage = 0;
        loadMoreNews();
    }

    @Override
    public void loadMoreNews() {
        RequestManager.getInstance().getNews(12, mCurrentPage, "android", 9738, new HttpCallback<PageResponse<News>>() {
            @Override
            public void doOnSuccess(Response<PageResponse<News>> response) {
                if (response.body() != null) {
                    List<News> list = response.body().getList();
                    if (list != null && list.size() != 0) {
                        if (mCurrentPage == 0) {
                            getView().showNewsList(list);
                        } else {
                            getView().showMoreNewsList(mCurrentPage, list);
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

    @Override
    public void refreshBannerNews() {
        RequestManager.getInstance().getNews(13, 0, "android", 9738, new HttpCallback<PageResponse<News>>() {
            @Override
            public void doOnSuccess(Response<PageResponse<News>> response) {
                if (response.body() != null) {
                    List<News> list = response.body().getList();
                    if (list != null && list.size() != 0) {
                        getView().showBannerNewsList(list);
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
