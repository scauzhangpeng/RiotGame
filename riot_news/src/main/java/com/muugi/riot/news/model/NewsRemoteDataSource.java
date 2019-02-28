package com.muugi.riot.news.model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.muugi.riot.news.bean.News;
import com.xyz.riotcommon.bean.PageResponse;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZP on 2019/2/21.
 */
public class NewsRemoteDataSource implements NewsDataSource {
    private static final String TAG = "NewsRemoteDataSource";

    private NewsRemoteDataSource() {}

    public static volatile NewsRemoteDataSource INSTANCE = null;

    public static NewsRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (NewsRemoteDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NewsRemoteDataSource();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void loadNewsData(String cid, final int currentPage, @NonNull final LoadNewsCallback callback) {
        NewsRequestManager.getInstance().getNews(cid, currentPage)
                .subscribeOn(Schedulers.io())
                .doOnNext(new Consumer<PageResponse<News>>() {
                    @Override
                    public void accept(PageResponse<News> pageResponse) throws Exception {
                        //store db
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RequestCallback<PageResponse<News>>() {
                    @Override
                    public void onNext(PageResponse<News> pageResponse) {
                        if (pageResponse.getCode() != 0) {
                            onException(pageResponse.getCode() + "", pageResponse.getMsg(), null);
                            return;
                        }
                        List<News> list = pageResponse.getList();
                        if (list != null && list.size() > 0) {
                            callback.onNewsLoadSuccess(list, pageResponse, 3);
                        } else {
                            callback.onNewsLoadEmpty(3);
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "accept: " + Thread.currentThread().getName());
                    }

                    @Override
                    void onException(String code, String message, Throwable e) {
                        Log.d(TAG, "onException: ");
                        callback.onNewsLoadError(code, message, 3);
                    }
                });
    }
}
