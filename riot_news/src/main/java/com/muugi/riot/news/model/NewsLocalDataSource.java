package com.muugi.riot.news.model;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.News;

import java.util.ArrayList;

/**
 * Created by ZP on 2019/2/21.
 */
public class NewsLocalDataSource implements NewsDataSource {
    private static final String TAG = "NewsLocalDataSource";

    private NewsLocalDataSource() {}

    public static volatile NewsLocalDataSource INSTANCE = null;

    public static NewsLocalDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (NewsLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NewsLocalDataSource();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void loadNewsData(String cid, int currentPage, @NonNull LoadNewsCallback callback) {
        callback.onNewsLoadSuccess(new ArrayList<News>(), null, 1);
    }
}
