package org.scau.riotgame.act;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.scau.riotgame.act.bean.ActDetailResponse;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;

import retrofit2.Response;

/**
 * Created by ZP on 2018/6/8.
 */

public class ActPresenter extends ActContract.Presenter {

    private String type = "open";
    private String lasttime = "";

    public ActPresenter(String type) {
        this.type = type;
    }

    @Override
    void getRefresh() {
        getLoadMore();
    }

    @Override
    void getLoadMore() {
        RequestManager.getInstance().getActDetailList(type, lasttime, new HttpCallback<ActDetailResponse>() {
            @Override
            public void doOnSuccess(@NonNull ActDetailResponse actDetailResponse, Response<ActDetailResponse> response) {
                if (TextUtils.isEmpty(lasttime)) {
                    getView().showRefreshActDetailList(actDetailResponse.getList());
                } else {
                    getView().showLoadMoreActDetailList(actDetailResponse.getList());
                }

                //是否可以继续上拉加载更多
                String next = actDetailResponse.getNext();
                if (!TextUtils.isEmpty(next) && "True".equals(next)) {
                    String lasttime = actDetailResponse.getLasttime();
                    if (!TextUtils.isEmpty(lasttime)) {
                        ActPresenter.this.lasttime = lasttime;
                    }
                } else {
                    getView().setLoadMoreEnable(false);
                    lasttime = "";
                }
            }

            @Override
            public void doOnError(Response<ActDetailResponse> response, String statusCode, String message) {
                getView().showEmptyPage("msg");
            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }
}
