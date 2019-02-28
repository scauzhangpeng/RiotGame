package com.muugi.riot.news.model;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.News;
import com.xyz.riotcommon.bean.PageResponse;

import java.util.List;

/**
 * Created by ZP on 2019/2/21.
 */
public class NewsRepository implements NewsDataSource {

    public static volatile NewsRepository INSTANCE = null;

    private final NewsLocalDataSource mNewsLocalDataSource;

    private final NewsRemoteDataSource mNewsRemoteDataSource;

    private NewsRepository(NewsLocalDataSource newsLocalDataSource, NewsRemoteDataSource newsRemoteDataSource) {
        this.mNewsLocalDataSource = newsLocalDataSource;
        this.mNewsRemoteDataSource = newsRemoteDataSource;
    }

    public static NewsRepository getInstance(NewsLocalDataSource newsLocalDataSource, NewsRemoteDataSource newsRemoteDataSource) {
        if (INSTANCE == null) {
            synchronized (NewsRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NewsRepository(newsLocalDataSource, newsRemoteDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void loadNewsData(final String cid, final int currentPage, @NonNull final LoadNewsCallback callback) {
        loadNewsFromRemoteDataSource(cid, currentPage, callback);
    }

    private void loadNewsFromRemoteDataSource(String cid, int currentPage, final LoadNewsCallback callback) {
        mNewsRemoteDataSource.loadNewsData(cid, currentPage, new LoadNewsCallback() {
            @Override
            public void onNewsLoadSuccess(List<News> data, PageResponse<News> pageResponse, int type) {
                callback.onNewsLoadSuccess(data, pageResponse, type);
            }

            @Override
            public void onNewsLoadEmpty(int type) {
                callback.onNewsLoadEmpty(type);
            }

            @Override
            public void onNewsLoadError(String code, String message, int type) {
                callback.onNewsLoadError(code, message, type);
            }
        });
    }
}
