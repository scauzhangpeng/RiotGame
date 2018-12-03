package com.muugi.riot.news.model;

import com.muugi.riot.news.bean.CardsResponse;
import com.muugi.riot.news.bean.GameCenterData;
import com.muugi.riot.news.bean.HotMatch;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.bean.PageColumnList;
import com.muugi.riot.news.bean.PageRespNewVersionCard;
import com.xyz.riotcommon.bean.PageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by ZP on 2017/8/7.
 */

public interface ApiService {


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


    @GET("php_cgi/news/php/varcache_getnews.php")
    Call<PageResponse<News>> getHotNews(@Query("id") int cid, @Query("page") int page);

    @GET("php_cgi/news/php/varcache_getnews.php")
    Call<PageResponse<News>> getOfficialNews(@Query("id") int cid, @Query("page") int page, @Query("uuid") String uuid, @Query("area_id") int areaId);

    @GET("php_cgi/news/php/varcache_getnews.php")
    Call<PageResponse<News>> getNewVersionNews(@Query("id") int cid, @Query("page") int page);

    @GET("http://qt.qq.com/lua/lol_news/recommend?cid=367&areaid=7")
    @Headers("Cookie:l_uin=o2456513456; p_uin=o2456513456; p_skey=3vAhB*etp*ElpHK15U*LThQfHMAf-yQjk7NV-iE59Nc_; uin=o2456513456; skey=MHplxd1Wtz;")
    Call<PageRespNewVersionCard> getNewVersionCard(@Query("cid") int cid, @Query("areaid") int areaid);

    @GET("php_cgi/news/php/varcache_getcols.php")
    Call<PageResponse<News>> getColumnListNews(@Query("cid") String cid, @Query("page") int page);

    @GET("php_cgi/news/php/varcache_getcols.php")
    Call<PageResponse<HotMatch>> getColumnHotMatch(@Query("cid") String cid, @Query("page") int page);

}
