package com.muugi.riot.news.presenter;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.NewVersionCardItem;
import com.muugi.riot.news.bean.NewVersionListBean;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.bean.PageRespNewVersionCard;
import com.muugi.riot.news.contract.NewVersionContract;
import com.muugi.riot.news.model.RequestManager;
import com.xyz.riotcommon.bean.PageResponse;
import com.xyz.riotcommon.net.HttpCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class NewVersionPresenter extends NewVersionContract.Presenter {

    private int mCurrentPage;


    @Override
    public void requestNewVersionNews() {
        mCurrentPage = 0;
        loadMoreNewVersionNews();
    }

    @Override
    public void loadMoreNewVersionNews() {
        RequestManager.getInstance().getNewVersionNews(367, mCurrentPage, new HttpCallback<PageResponse<News>>() {
            @Override
            public void doOnSuccess(@NonNull PageResponse<News> newsPageResponse, Response<PageResponse<News>> response) {
                if (newsPageResponse.getCode() == 0) {
                    List<News> list = newsPageResponse.getList();
                    if (getView() != null) {
                        List<NewVersionListBean> beans = new ArrayList<>();
                        for (News news : list) {
                            beans.add(new NewVersionListBean(news, "news"));
                        }
                        if (mCurrentPage == 0) {
                            getView().showNewVersionNews(beans);
                        } else {
                            getView().showMoreNewVersionNews(mCurrentPage, beans);
                        }
                    }
                    if ("True".equals(newsPageResponse.getNext())) {
                        mCurrentPage++;
                    }
                }
            }

            @Override
            public void doOnError(Response<PageResponse<News>> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }

    @Override
    public void requestNewVersionCard() {
        RequestManager.getInstance().getNewVersionCard(367, 7, new HttpCallback<PageRespNewVersionCard>() {
            @Override
            public void doOnSuccess(@NonNull PageRespNewVersionCard newVersionCardItemCardsResponse, Response<PageRespNewVersionCard> response) {
                if (newVersionCardItemCardsResponse.getCode() == 0) {
                    List<NewVersionCardItem> list =
                            newVersionCardItemCardsResponse.getList();
                    for (NewVersionCardItem newVersionCardItem : list) {
                        String newstypeid = newVersionCardItem.getNewstypeid();
                        if ("newverhero".equals(newstypeid)) {
                            NewVersionListBean bean = new NewVersionListBean(null, "newverhero");
                            HashMap<String, String> header = new HashMap<>();
                            header.put("ver", newVersionCardItem.getChange_hero_ver());
                            header.put("desc", newVersionCardItem.getChange_hero_desc());
                            header.put("num", newVersionCardItem.getChange_hero_num_desc());
                            bean.setHeader(header);
                            getView().updateCardItem(Integer.valueOf(newVersionCardItem.getPosition()) - 1, bean);
                            getView().showNewVersionHero(newVersionCardItem);
                        }

                        if ("newverskin".equals(newstypeid)) {
                            NewVersionListBean bean = new NewVersionListBean(null, "newverskin");
                            HashMap<String, String> header = new HashMap<>();
                            header.put("ver", newVersionCardItem.getChange_skin_ver());
                            header.put("desc", newVersionCardItem.getChange_skin_desc());
                            header.put("num", newVersionCardItem.getChange_skin_num_desc());
                            bean.setHeader(header);
                            getView().updateCardItem(Integer.valueOf(newVersionCardItem.getPosition()) - 1, bean);
                            getView().showNewVersionSkin(newVersionCardItem);
                        }
                    }
                }
            }

            @Override
            public void doOnError(Response<PageRespNewVersionCard> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }
}
