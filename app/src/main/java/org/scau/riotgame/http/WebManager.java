package org.scau.riotgame.http;

import org.scau.riotgame.home.bean.PageRespWholeVideoData;
import org.scau.riotgame.home.bean.PageVideoData;

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
            synchronized (RequestManager.class) {
                mInstance = new WebManager();
            }
        }

        return mInstance;
    }

    public Call getVideoDataHotRec(HttpCallback<PageVideoData> callback) {
        Call<PageVideoData> call = mWebService.getVideoDataHotRec();
        call.enqueue(callback);
        return call;
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

    public Call<PageRespWholeVideoData> getVideoDataWhole(int page, int pageSize, HttpCallback<PageRespWholeVideoData> callback) {
        Call<PageRespWholeVideoData> call = mWebService.getVideoDataWhole(page, pageSize, 1, "lolapp");
        call.enqueue(callback);
        return call;
    }
}
