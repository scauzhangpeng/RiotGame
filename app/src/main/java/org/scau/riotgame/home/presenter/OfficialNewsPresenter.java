package org.scau.riotgame.home.presenter;

import android.support.annotation.NonNull;

import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.bean.PageResponse;
import org.scau.riotgame.home.contract.OfficialNewsContract;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;

import retrofit2.Response;

/**
 * Created by ZP on 2018/11/10.
 */
public class OfficialNewsPresenter extends OfficialNewsContract.Presenter {

    private int mCurrentPage = 0;


    @Override
    public void refreshNews() {
        mCurrentPage = 0;
        loadMoreNews();
    }

    @Override
    public void loadMoreNews() {
        RequestManager.getInstance().getHotNews(3, mCurrentPage, new HttpCallback<PageResponse<News>>() {
            @Override
            public void doOnSuccess(@NonNull PageResponse<News> newsPageResponse, Response<PageResponse<News>> response) {
                if (newsPageResponse.getCode() != 0) {
                    doOnError(response, String.valueOf(newsPageResponse.getCode()), newsPageResponse.getMsg());
                    return;
                }
                if (mCurrentPage == 0) {
                    if (getView() != null) {
                        getView().showOfficialNewsList(newsPageResponse.getList());
                    }
                } else {
                    if (getView() != null) {
                        getView().showMoreOfficialNewsList(mCurrentPage, newsPageResponse.getList());
                    }
                }

                if ("True".equals(newsPageResponse.getNext())) {
                    mCurrentPage++;
                } else {

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
