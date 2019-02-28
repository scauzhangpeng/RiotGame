package com.muugi.riot.news.model;

/**
 * Created by ZP on 2019/2/21.
 */
public class Injection {

    public static NewsRepository provideNewsRepository() {
        return NewsRepository.getInstance(NewsLocalDataSource.getInstance(), NewsRemoteDataSource.getInstance());
    }
}
