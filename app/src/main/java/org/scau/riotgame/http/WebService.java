package org.scau.riotgame.http;

import org.scau.riotgame.home.bean.PageVideoData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZP on 2017/8/30.
 */

public interface WebService {

    @GET("web201310/js/videodata/LOL_APP_HOTREC_LIST.js")
    Call<PageVideoData> getVideoData(@Query("version") int version);

    @GET("biz/hero/free.js")
    Call<String> getFreeHeros(@Query("version") int version);


}
