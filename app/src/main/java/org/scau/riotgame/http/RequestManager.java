package org.scau.riotgame.http;

import org.scau.riotgame.home.Club;
import org.scau.riotgame.home.bean.GameCenterData;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.bean.PageColumnList;
import org.scau.riotgame.home.bean.PageResponse;

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

    public static synchronized RequestManager getInstance() {
        if (mInstance == null) {
            synchronized (RequestManager.class) {
                mInstance = new RequestManager();
            }
        }

        return mInstance;
    }

    public Call getNews(int id, int page, String plat, int version, HttpCallback<PageResponse<News>> callback) {
        Call<PageResponse<News>> call = mApiService.getNews(id, page, plat, version);
        call.enqueue(callback);
        return call;
    }


    public Call getClubInfo(String plat, int version, HttpCallback<Club> callback) {
        Call<Club> call = mApiService.getClubInfo(plat, version);
        call.enqueue(callback);
        return call;
    }

    public Call getColumnList(int page, String plat, int version, HttpCallback<PageColumnList> callback) {
        Call<PageColumnList> call = mApiService.getColumnList(page, plat, version);
        call.enqueue(callback);
        return call;
    }

    public Call getGameCenterData(String plat, int version, HttpCallback<GameCenterData> callback) {
        Call<GameCenterData> call = mApiService.getGameCenterData(plat, version);
        call.enqueue(callback);
        return call;
    }
}
