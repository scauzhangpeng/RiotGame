package com.muugi.riot.discovery.hero.model;

import com.xyz.riotcommon.net.HttpCallback;
import com.xyz.riotcommon.net.ServiceFactory;

import retrofit2.Call;

/**
 * Created by ZP on 2017/8/30.
 */

public class WebManager {


    private WebService mWebService;
    private static WebManager mInstance;

    private WebManager() {
        mWebService = ServiceFactory.createServiceFrom(WebService.class, "http://lol.qq.com/");
    }

    public static WebManager getInstance() {
        if (mInstance == null) {
            synchronized (WebManager.class) {
                mInstance = new WebManager();
            }
        }

        return mInstance;
    }


    public Call getFreeHeros(int version, HttpCallback<String> callback) {
        Call<String> call = mWebService.getFreeHeros(version);
        call.enqueue(callback);
        return call;
    }

    public Call<String> getFreeHero(int version, HttpCallback<String> callback) {
        Call<String> call = mWebService.getFreeHeros(version);
        call.enqueue(callback);
        return call;
    }


}
