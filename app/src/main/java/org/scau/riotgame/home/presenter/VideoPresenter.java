package org.scau.riotgame.home.presenter;

import android.support.annotation.NonNull;

import org.scau.riotgame.home.bean.HotAuthor;
import org.scau.riotgame.home.bean.HotEnter;
import org.scau.riotgame.home.bean.HotMatch;
import org.scau.riotgame.home.bean.HotWpv;
import org.scau.riotgame.home.bean.PageVideoData;
import org.scau.riotgame.home.contract.VideoContract;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.WebManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class VideoPresenter extends VideoContract.Presenter {
    @Override
    public void getHotAuthorList() {

        WebManager.getInstance().getHostAuthors(9738, new HttpCallback<PageVideoData>() {
            @Override
            public void doOnSuccess(@NonNull PageVideoData pageVideoData, Response<PageVideoData> response) {
                List<HotAuthor> hotRecAuthorList = pageVideoData.getMsg().getHotRecAuthorList();
                if (hotRecAuthorList != null) {
                    getView().showHotAuthorList(hotRecAuthorList);
                }

                List<HotWpv> hotRecWpvlist = pageVideoData.getMsg().getHotRecWpvlist();
                if (hotRecWpvlist != null) {
                    getView().showHotWpvList(hotRecWpvlist);
                }

                List<HotEnter> hotRecEnterList = pageVideoData.getMsg().getHotRecEnterList();
                if (hotRecEnterList != null) {
                    getView().showHotEnterList(hotRecEnterList);
                }

                List<HotMatch> hotRecMatchList = pageVideoData.getMsg().getHotRecMatchList();
                if (hotRecMatchList != null) {
                    getView().showHotMatchTop(hotRecMatchList.get(0));
                    hotRecMatchList.remove(0);
                    getView().showHotMatchList(hotRecMatchList);
                }
            }

            @Override
            public void doOnError(Response<PageVideoData> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });


    }

    @Override
    public void getHotWpvList() {
        List<HotWpv> hotWpvs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            HotWpv hotWpv = new HotWpv();
            hotWpvs.add(hotWpv);
        }

        getView().showHotWpvList(hotWpvs);
    }
}
