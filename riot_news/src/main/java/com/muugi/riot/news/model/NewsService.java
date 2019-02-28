package com.muugi.riot.news.model;

import com.muugi.riot.news.bean.News;
import com.xyz.riotcommon.bean.PageResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZP on 2019/2/24.
 */
public interface NewsService {

    @GET("php_cgi/news/php/varcache_getnews.php")
    Observable<PageResponse<News>> getNews(@Query("id") String cid, @Query("page") int page);
}
