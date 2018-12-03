package org.scau.riotgame.http;

import com.xyz.riotcommon.bean.PageResponse;
import com.xyz.riotcommon.net.HttpCallback;
import com.xyz.riotcommon.net.ServiceFactory;

import org.scau.riotgame.act.bean.ActDetailResponse;
import org.scau.riotgame.act.bean.ActInfo;
import org.scau.riotgame.home.bean.Club;
import org.scau.riotgame.home.bean.DiscoveryMenu;
import org.scau.riotgame.wallpaper.bean.KindWallPaper;
import org.scau.riotgame.wallpaper.bean.WallPaper;

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

    public Call getClubInfo(int version, HttpCallback<Club> callback) {
        Call<Club> call = mApiService.getClubInfo(version);
        call.enqueue(callback);
        return call;
    }

    public Call getDiscoveryMenu(HttpCallback<PageResponse<DiscoveryMenu>> callback) {
        Call<PageResponse<DiscoveryMenu>> call = mApiService.getDiscoveryMenu();
        call.enqueue(callback);
        return call;
    }

    public Call getWallPaper(String type, int page, int num, HttpCallback<WallPaper> callback) {
        Call<WallPaper> call = mApiService.getWallPaper(type, page, num);
        call.enqueue(callback);
        return call;
    }

    public Call getTypeWallPaper(int page, int num, HttpCallback<KindWallPaper> callback) {
        Call<KindWallPaper> call = mApiService.getTypeWallPaper(page, num);
        call.enqueue(callback);
        return call;
    }

    public Call getWallPaperByKind(String kind, int page, int num, HttpCallback<WallPaper> callback) {
        Call<WallPaper> call = mApiService.getWallPaperByKind(kind, page, num);
        call.enqueue(callback);
        return call;
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
