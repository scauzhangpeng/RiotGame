package com.muugi.riot.discovery.hero.model;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZP on 2017/8/30.
 */

public interface WebService {


    @GET("biz/hero/free.js")
    Call<String> getFreeHeros(@Query("version") int version);


}
