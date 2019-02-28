package com.muugi.riot.news.model;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.News;
import com.xyz.riotcommon.bean.PageResponse;

import java.util.List;

/**
 * Created by ZP on 2019/2/21.
 */
public interface NewsDataSource {

    interface LoadNewsCallback {
        /**
         * 资讯新闻加载成功，来源：本地数据库、网络缓存、网络
         * @param data 资讯列表
         */
        void onNewsLoadSuccess(List<News> data, PageResponse<News> pageResponse, int type);

        void onNewsLoadEmpty(int type);

        void onNewsLoadError(String code, String message, int type);
    }

    void loadNewsData(String cid, int currentPage, @NonNull LoadNewsCallback callback);
}
