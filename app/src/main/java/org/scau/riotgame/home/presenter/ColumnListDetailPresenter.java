package org.scau.riotgame.home.presenter;

import android.support.annotation.NonNull;

import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.bean.PageResponse;
import org.scau.riotgame.home.contract.ColumnListDetailContract;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;

import retrofit2.Response;

/**
 * Created by ZP on 2018/11/18.
 */
public class ColumnListDetailPresenter extends ColumnListDetailContract.Presenter {

    private int mCurrentPage = 0;

    @Override
    public void refreshNews(String cid) {
        mCurrentPage = 0;
        getView().setEnableLoadMore(true);
        loadMoreNews(cid);
    }

    @Override
    public void loadMoreNews(String cid) {
        RequestManager.getInstance().getColumnListNews(cid, mCurrentPage, new HttpCallback<PageResponse<News>>() {
            @Override
            public void doOnSuccess(@NonNull PageResponse<News> newsPageResponse, Response<PageResponse<News>> response) {
                if (newsPageResponse.getCode() != 0) {
                    doOnError(response, String.valueOf(newsPageResponse.getCode()), newsPageResponse.getMsg());
                    return;
                }
                if (mCurrentPage == 0) {
                    if (getView() != null) {
                        getView().showNewsList(newsPageResponse.getList());
                    }
                } else {
                    if (getView() != null) {
                        getView().showMoreNewsList(newsPageResponse.getList());
                    }
                }

                if ("True".equals(newsPageResponse.getNext())) {
                    mCurrentPage++;
                } else {
                    getView().setEnableLoadMore(false);
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