package com.muugi.riot.discovery.hero.model;

import com.muugi.riot.discovery.hero.bean.GoodBean;
import com.muugi.riot.discovery.hero.bean.GoodsDetailBean;
import com.muugi.riot.discovery.hero.bean.Hero;
import com.muugi.riot.discovery.hero.bean.HeroDetailBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ZP on 2018/2/26.
 */

public interface OSSWebService {

    @GET("upload/qqtalk/lol_hero/hero_list.js")
    Call<List<Hero>> getAllHero();

    @GET("upload/qqtalk/lol_hero/hero_{heroid}.js")
    Call<HeroDetailBean> getHeroDetail(
            @Path("heroid") int heroId,
            @Query("version") int version);

    @GET("upload/qqtalk/lol_hero/goods_list.js")
    Call<GoodBean> getGoods();

    @GET("upload/qqtalk/lol_hero/good_{goods_id}.js")
    Call<GoodsDetailBean> getGoodsDetail(@Path("goods_id") int goods_id);
}
