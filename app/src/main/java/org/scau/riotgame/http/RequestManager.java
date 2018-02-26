package org.scau.riotgame.http;

import org.scau.riotgame.home.Club;
import org.scau.riotgame.home.bean.CardsResponse;
import org.scau.riotgame.home.bean.DiscoveryMenu;
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

    public static RequestManager getInstance() {
        if (mInstance == null) {
            synchronized (RequestManager.class) {
                mInstance = new RequestManager();
            }
        }

        return mInstance;
    }

    public Call getNews(int id, int page, int version, HttpCallback<PageResponse<News>> callback) {
        Call<PageResponse<News>> call = mApiService.getNews(id, page, version);
        call.enqueue(callback);
        return call;
    }


    public Call getClubInfo(int version, HttpCallback<Club> callback) {
        Call<Club> call = mApiService.getClubInfo(version);
        call.enqueue(callback);
        return call;
    }

    public Call getColumnList(int page, int version, HttpCallback<PageColumnList> callback) {
        Call<PageColumnList> call = mApiService.getColumnList(page, version);
        call.enqueue(callback);
        return call;
    }

    public Call getGameCenterData(int version, HttpCallback<GameCenterData> callback) {
        Call<GameCenterData> call = mApiService.getGameCenterData(version);
        call.enqueue(callback);
        return call;
    }

    public Call getHeroGroup(int page, String uuid, int area_id, int version, HttpCallback<PageResponse<News>> callback) {
        Call<PageResponse<News>> call = mApiService.getHeroGroup(page, uuid, area_id, version);
        call.enqueue(callback);
        return call;
    }

    public Call getCardsData(String uuid, int area_id, int version, HttpCallback<CardsResponse> callback) {
        Call<CardsResponse> call = mApiService.getCardsData(uuid, area_id, version);
        call.enqueue(callback);
        return call;
    }

    public Call getDiscoveryMenu(HttpCallback<PageResponse<DiscoveryMenu>> callback) {
        Call<PageResponse<DiscoveryMenu>> call = mApiService.getDiscoveryMenu();
        call.enqueue(callback);
        return call;
    }

}
