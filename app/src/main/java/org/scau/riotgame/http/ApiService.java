package org.scau.riotgame.http;

import org.scau.riotgame.act.bean.ActDetailResponse;
import org.scau.riotgame.act.bean.ActInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZP on 2017/8/7.
 */

public interface ApiService {


    @GET("php_cgi/news/php/varcache_actinfo.php")
    Call<ActInfo> getActivityInfo();


    @GET("php_cgi/news/php/varcache_getactnews.php")
    Call<ActDetailResponse> getActDetailList(@Query("t") String type, @Query("lasttime") String lasttime);

}
