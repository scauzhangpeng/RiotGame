package com.muugi.riot.news.model;

import com.muugi.riot.news.bean.CardsResponse;
import com.muugi.riot.news.bean.GameCenterData;
import com.muugi.riot.news.bean.HotMatch;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.bean.PageColumnList;
import com.muugi.riot.news.bean.PageRespNewVersionCard;
import com.xyz.riotcommon.bean.PageResponse;
import com.xyz.riotcommon.net.HttpCallback;
import com.xyz.riotcommon.net.ServiceFactory;

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

    public Call getHotNews(int id, int currentPage, HttpCallback<PageResponse<News>> callback) {
        Call<PageResponse<News>> call = mApiService.getHotNews(id, currentPage);
        call.enqueue(callback);
        return call;
    }

    public Call getNewVersionNews(int id, int currentPage, HttpCallback<PageResponse<News>> callback) {
        Call<PageResponse<News>> call = mApiService.getNewVersionNews(id, currentPage);
        call.enqueue(callback);
        return call;
    }

    public Call getNewVersionCard(int cid, int currentPage, HttpCallback<PageRespNewVersionCard> callback) {
        Call<PageRespNewVersionCard> call = mApiService.getNewVersionCard(cid, currentPage);
        call.enqueue(callback);
        return call;
    }

    public Call getColumnListNews(String cid, int page, HttpCallback<PageResponse<News>> callback) {
        Call<PageResponse<News>> call = mApiService.getColumnListNews(cid, page);
        call.enqueue(callback);
        return call;
    }

    public Call getColumnHotMatch(String cid, int page, HttpCallback<PageResponse<HotMatch>> callback) {
        Call<PageResponse<HotMatch>> call = mApiService.getColumnHotMatch(cid, page);
        call.enqueue(callback);
        return call;
    }
}
