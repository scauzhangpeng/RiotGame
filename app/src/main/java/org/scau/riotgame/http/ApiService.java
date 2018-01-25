package org.scau.riotgame.http;

import org.scau.riotgame.home.Club;
import org.scau.riotgame.home.bean.GameCenterData;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.bean.PageColumnList;
import org.scau.riotgame.home.bean.PageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZP on 2017/8/7.
 */

public interface ApiService {


    @GET("php_cgi/lol_mobile/club/varcache_team_entrancev2.php")
    Call<Club> getClubInfo(@Query("plat") String plat,
                           @Query("version") int version);

    @GET("php_cgi/news/php/varcache_getnews.php")
    Call<PageResponse<News>> getNews(@Query("id") int id,
                                     @Query("page") int page,
                                     @Query("plat") String plat,
                                     @Query("version") int version);


    @GET("lua/lol_news/columnlist")
    Call<PageColumnList> getColumnList(@Query("page") int page,
                                       @Query("plat") String plat,
                                       @Query("version") int version);

    @GET("php_cgi/lol_mobile/gamecenter/varcache_gamecenterindex.php")
    Call<GameCenterData> getGameCenterData(@Query("plat") String plat,
                                           @Query("version") int version);
}
