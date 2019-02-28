package com.muugi.riot.news.model;

import com.muugi.riot.news.bean.News;
import com.xyz.riotcommon.bean.PageResponse;
import com.xyz.riotcommon.net.ServiceFactory;

import io.reactivex.Observable;

/**
 * Created by ZP on 2019/2/24.
 */
public class NewsRequestManager {
    private static final String TAG = "NewsRequestManager";
    private static volatile NewsRequestManager INSTANCE = null;
    private NewsService mNewsService;

    private NewsRequestManager(){
        mNewsService = ServiceFactory.createServiceRxJava(NewsService.class, "http://qt.qq.com/");
    }

    public static NewsRequestManager getInstance() {
        if (INSTANCE == null) {
            synchronized (NewsRequestManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NewsRequestManager();
                }
            }
        }
        return INSTANCE;
    }

    public Observable<PageResponse<News>> getNews(String id, int page) {
        return mNewsService.getNews(id, page);
    }
}
