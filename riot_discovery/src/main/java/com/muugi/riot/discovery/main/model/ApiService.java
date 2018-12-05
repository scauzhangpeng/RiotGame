package com.muugi.riot.discovery.main.model;

import com.muugi.riot.discovery.main.bean.Club;
import com.muugi.riot.discovery.main.bean.DiscoveryMenu;
import com.muugi.riot.discovery.wallpaper.bean.KindWallPaper;
import com.muugi.riot.discovery.wallpaper.bean.WallPaper;
import com.xyz.riotcommon.bean.PageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZP on 2017/8/7.
 */

public interface ApiService {


    @GET("php_cgi/lol_mobile/club/varcache_team_entrancev2.php")
    Call<Club> getClubInfo(@Query("version") int version);


    @GET("static/pages/news/discovery/c21_index.js")
    Call<PageResponse<DiscoveryMenu>> getDiscoveryMenu();


    @GET("php_cgi/lol_goods/varcache_wallpaper_list.php")
    Call<WallPaper> getWallPaper(@Query("type") String type, @Query("page") int page,
                                 @Query("num") int num);

    @GET("php_cgi/lol_goods/varcache_kind_index.php")
    Call<KindWallPaper> getTypeWallPaper(@Query("page") int page,
                                         @Query("num") int num);

    @GET("php_cgi/lol_goods/varcache_wallpaper_kind.php")
    Call<WallPaper> getWallPaperByKind(
            @Query("kind") String kind,
            @Query("page") int page,
            @Query("num") int num);


}
