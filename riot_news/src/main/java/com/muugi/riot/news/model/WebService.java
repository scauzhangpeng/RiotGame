package com.muugi.riot.news.model;


import com.muugi.riot.news.bean.PageRespWholeVideoData;
import com.muugi.riot.news.bean.PageVideoData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZP on 2017/8/30.
 */

public interface WebService {

    @GET("web201310/js/videodata/LOL_APP_HOTREC_LIST.js")
    Call<PageVideoData> getVideoDataHotRec();

    @GET("biz/hero/free.js")
    Call<String> getFreeHeros(@Query("version") int version);

    @GET("http://apps.game.qq.com/lol/act/website2013/video.php")
    Call<PageRespWholeVideoData> getVideoDataWhole(@Query("page") int page, @Query("pagesize") int pageSize, @Query("r1") int r1, @Query("source") String source);


}
