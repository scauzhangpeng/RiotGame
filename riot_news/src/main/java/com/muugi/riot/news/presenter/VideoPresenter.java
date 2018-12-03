package com.muugi.riot.news.presenter;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.HotAuthor;
import com.muugi.riot.news.bean.HotEnter;
import com.muugi.riot.news.bean.HotHero;
import com.muugi.riot.news.bean.HotMatch;
import com.muugi.riot.news.bean.HotWpv;
import com.muugi.riot.news.bean.PageRespWholeVideoData;
import com.muugi.riot.news.bean.PageVideoData;
import com.muugi.riot.news.bean.WholeVideoData;
import com.muugi.riot.news.contract.VideoContract;
import com.muugi.riot.news.model.WebManager;
import com.xyz.riotcommon.net.HttpCallback;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class VideoPresenter extends VideoContract.Presenter {

    private int mCurrentPage;
    private int mPageSize = 10;
    @Override
    public void getVideoDataHotRec() {

        WebManager.getInstance().getVideoDataHotRec(new HttpCallback<PageVideoData>() {
            @Override
            public void doOnSuccess(@NonNull PageVideoData pageVideoData, Response<PageVideoData> response) {
                List<HotAuthor> hotRecAuthorList = pageVideoData.getMsg().getHotRecAuthorList();
                if (hotRecAuthorList != null) {
                    if (getView() != null) {
                        getView().showHotAuthorList(hotRecAuthorList);
                    }
                }

                List<HotWpv> hotRecWpvlist = pageVideoData.getMsg().getHotRecWpvlist();
                if (hotRecWpvlist != null) {
                    if (getView() != null) {
                        getView().showHotWpvList(hotRecWpvlist);
                    }
                }

                List<HotEnter> hotRecEnterList = pageVideoData.getMsg().getHotRecEnterList();
                if (hotRecEnterList != null) {
                    if (getView() != null) {
                        getView().showHotEnterList(hotRecEnterList);
                    }
                }

                List<HotMatch> hotRecMatchList = pageVideoData.getMsg().getHotRecMatchList();
                if (hotRecMatchList != null) {
                    if (getView() != null) {
                        getView().showHotMatchTop(hotRecMatchList.get(0));
                        hotRecMatchList.remove(0);
                        getView().showHotMatchList(hotRecMatchList);
                    }
                }

                List<HotHero> hotHeroes = pageVideoData.getMsg().getHotRecHeroList();
                if (hotHeroes != null) {
                    if (getView() != null) {
                        getView().showHotHeroList(hotHeroes);
                    }
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
    public void requestVideoDataWhole() {
        mCurrentPage = 0;
        loadMoreVideoDataWhole();
    }

    @Override
    public void loadMoreVideoDataWhole() {
        WebManager.getInstance().getVideoDataWhole(mCurrentPage, mPageSize, new HttpCallback<PageRespWholeVideoData>() {

            @Override
            public void doOnSuccess(@NonNull PageRespWholeVideoData pageRespWholeVideoData, Response<PageRespWholeVideoData> response) {
                if ("0".equals(pageRespWholeVideoData.getStatus())) {
                    WholeVideoData msg = pageRespWholeVideoData.getMsg();
                    List<HotMatch> result = msg.getResult();
                    if (result != null) {
                        if (getView() != null) {
                            if (mCurrentPage == 0) {
                                getView().showWholeVideoList(result);
                            } else {
                                getView().showMoreWholeVideoList(mCurrentPage, result);
                            }
                        }
                        String totalpage = msg.getTotalpage();
                        String page = msg.getPage();
                        try {
                            Integer totalPage = Integer.valueOf(totalpage);
                            Integer currentPage = Integer.valueOf(page);
                            if (currentPage <= totalPage) {
                                mCurrentPage = currentPage;
                                mCurrentPage++;
                            }
                        } catch (Exception ex) {

                        }
                    }
                }
            }

            @Override
            public void doOnError(Response<PageRespWholeVideoData> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }
}
