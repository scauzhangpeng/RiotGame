package org.scau.riotgame.http;

import org.scau.riotgame.act.bean.ActDetailResponse;
import org.scau.riotgame.act.bean.ActInfo;
import org.scau.riotgame.home.Club;
import org.scau.riotgame.home.bean.CardsResponse;
import org.scau.riotgame.home.bean.DiscoveryMenu;
import org.scau.riotgame.home.bean.GameCenterData;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.bean.PageColumnList;
import org.scau.riotgame.home.bean.PageResponse;
import org.scau.riotgame.wallpaper.bean.KindWallPaper;
import org.scau.riotgame.wallpaper.bean.WallPaper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by ZP on 2017/8/7.
 */

public interface ApiService {


    @GET("php_cgi/lol_mobile/club/varcache_team_entrancev2.php")
    Call<Club> getClubInfo(@Query("version") int version);

    @GET("php_cgi/news/php/varcache_getnews.php")
    Call<PageResponse<News>> getNews(@Query("id") int id,
                                     @Query("page") int page,
                                     @Query("version") int version);


    @GET("lua/lol_news/columnlist")
    @Headers("Cookie:l_uin=o2456513456; p_uin=o2456513456; p_skey=3vAhB*etp*ElpHK15U*LThQfHMAf-yQjk7NV-iE59Nc_; uin=o2456513456; skey=MHplxd1Wtz;")
    Call<PageColumnList> getColumnList(@Query("page") int page,
                                       @Query("version") int version);

    @GET("php_cgi/lol_mobile/gamecenter/varcache_gamecenterindex.php")
    Call<GameCenterData> getGameCenterData(@Query("version") int version);

    /**
     * 英雄圈
     *
     * @param page
     * @param uuid
     * @param area_id
     * @param version
     * @return
     */
    @GET("http://qt.qq.com/php_cgi/lol_mobile/hero_group/php/article_list.php")
    Call<PageResponse<News>> getHeroGroup(@Query("page") int page,
                                          @Query("uuid") String uuid,
                                          @Query("area_id") int area_id,
                                          @Query("version") int version);

    @GET("http://qt.qq.com/php_cgi/lol_mobile/hero_group/php/cards.php")
    Call<CardsResponse> getCardsData(@Query("uuid") String uuid,
                                     @Query("area_id") int area_id,
                                     @Query("version") int version);

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

    @GET("php_cgi/news/php/varcache_getnews.php")
    Call<PageResponse<News>> getHotNews(@Query("id") int cid, @Query("page") int page);

}
