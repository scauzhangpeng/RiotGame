package org.scau.riotgame.http;

import com.xyz.riotcommon.bean.PageResponse;

import org.scau.riotgame.act.bean.ActDetailResponse;
import org.scau.riotgame.act.bean.ActInfo;
import org.scau.riotgame.home.bean.Club;
import org.scau.riotgame.home.bean.DiscoveryMenu;
import org.scau.riotgame.wallpaper.bean.KindWallPaper;
import org.scau.riotgame.wallpaper.bean.WallPaper;

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

    @GET("php_cgi/news/php/varcache_actinfo.php")
    Call<ActInfo> getActivityInfo();


    @GET("php_cgi/news/php/varcache_getactnews.php")
    Call<ActDetailResponse> getActDetailList(@Query("t") String type, @Query("lasttime") String lasttime);

}
