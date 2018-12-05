package org.scau.riotgame.http;

import com.xyz.riotcommon.net.HttpCallback;
import com.xyz.riotcommon.net.ServiceFactory;

import org.scau.riotgame.act.bean.ActDetailResponse;
import org.scau.riotgame.act.bean.ActInfo;

import retrofit2.Call;

/**
 * Created by ZP on 2017/8/7.
 */

public class RequestManager {

    private ApiService mApiService;
    private static RequestManager mInstance;

    private RequestManager() {
        mApiService = ServiceFactory.createServiceFrom(ApiService.class, "http://qt.qq.com/");
    }

    public static RequestManager getInstance() {
        if (mInstance == null) {
            synchronized (RequestManager.class) {
                mInstance = new RequestManager();
            }
        }

        return mInstance;
    }

    public Call getActInfo(HttpCallback<ActInfo> callback) {
        Call<ActInfo> call = mApiService.getActivityInfo();
        call.enqueue(callback);
        return call;
    }

    public Call getActDetailList(String type, String lasttime, HttpCallback<ActDetailResponse> callback) {
        Call<ActDetailResponse> call = mApiService.getActDetailList(type, lasttime);
        call.enqueue(callback);
        return call;
    }


}
