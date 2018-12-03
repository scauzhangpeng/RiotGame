package org.scau.riotgame.http;

import com.xyz.riotcommon.net.HttpCallback;
import com.xyz.riotcommon.net.ServiceFactory;

import org.scau.riotgame.hero.GoodBean;
import org.scau.riotgame.hero.GoodsDetailBean;
import org.scau.riotgame.hero.Hero;
import org.scau.riotgame.hero.HeroDetailBean;

import java.util.List;

import retrofit2.Call;

/**
 * Created by ZP on 2018/2/26.
 */

public class OSSWebManager {

    private OSSWebService mWebService;
    private static OSSWebManager mInstance;

    private OSSWebManager() {
        mWebService = ServiceFactory.createServiceFrom(OSSWebService.class, "http://ossweb-img.qq.com/");
    }

    public static OSSWebManager getInstance() {
        if (mInstance == null) {
            synchronized (RequestManager.class) {
                mInstance = new OSSWebManager();
            }
        }

        return mInstance;
    }

    public Call getAllHero(HttpCallback<List<Hero>> callback) {
        Call<List<Hero>> call = mWebService.getAllHero();
        call.enqueue(callback);
        return call;
    }

    public Call<HeroDetailBean> getHeroDetail(int heroId, int version, HttpCallback<HeroDetailBean> callback) {
        Call<HeroDetailBean> call = mWebService.getHeroDetail(heroId, version);
        call.enqueue(callback);
        return call;
    }

    public Call getGoods(HttpCallback<GoodBean> callback) {
        Call<GoodBean> call = mWebService.getGoods();
        call.enqueue(callback);
        return call;
    }

    public Call getGoodsDetail(int good_id, HttpCallback<GoodsDetailBean> callback) {
        Call<GoodsDetailBean> call = mWebService.getGoodsDetail(good_id);
        call.enqueue(callback);
        return call;
    }
}
