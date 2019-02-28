package com.muugi.riot.news.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.muugi.riot.news.bean.NewVersionCardItem;
import com.muugi.riot.news.bean.NewVersionListBean;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.bean.PageRespNewVersionCard;
import com.muugi.riot.news.contract.NewVersionContract;
import com.muugi.riot.news.model.NewsDataSource;
import com.muugi.riot.news.model.NewsRepository;
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

    public NewVersionPresenter(String cid, NewsRepository mNewsRepository) {
        super(cid, mNewsRepository);
    }


    @Override
    public void loadMoreNews() {
        mNewsRepository.loadNewsData(cid, mCurrentPage, new NewsDataSource.LoadNewsCallback() {
            @Override
            public void onNewsLoadSuccess(List<News> data, PageResponse<News> pageResponse, int type) {
                if (isViewAttach()) {
                    List<NewVersionListBean> beans = new ArrayList<>();
                    for (News news : data) {
                        beans.add(new NewVersionListBean(news, "news"));
                    }
                    if (mCurrentPage == 0) {
                        getView().showListData(beans);
                    } else {
                        getView().showMoreListData(mCurrentPage, beans);
                    }
                    if ("True".equals(pageResponse.getNext())) {
                        mCurrentPage++;
                    } else {
                        getView().setEnableLoadMore(false);
                    }
                }
            }

            @Override
            public void onNewsLoadEmpty(int type) {

            }

            @Override
            public void onNewsLoadError(String code, String message, int type) {

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

                        if ("newverscan".equals(newstypeid)) {
                            NewVersionListBean bean = new NewVersionListBean(null, "newverscan");
                            HashMap<String, String> header = new HashMap<>();
                            header.put("ver", newVersionCardItem.getChange_scan_ver());
                            header.put("desc", newVersionCardItem.getChange_scan_desc());
                            header.put("num", newVersionCardItem.getChange_scan_num_desc());
                            bean.setHeader(header);
                            getView().updateCardItem(Integer.valueOf(newVersionCardItem.getPosition()) - 1, bean);
                            getView().showNewsVersionScan(newVersionCardItem);
                        }

                        if ("newverabout".equals(newstypeid)) {
                            NewVersionListBean bean = new NewVersionListBean(null, "newverabout");
                            HashMap<String, String> header = new HashMap<>();
                            header.put("ver", newVersionCardItem.getChange_about_ver());
//                            header.put("desc", newVersionCardItem.getChange_scan_desc());
//                            header.put("num", newVersionCardItem.getChange_scan_num_desc());
                            bean.setHeader(header);
                            getView().updateCardItem(Integer.valueOf(newVersionCardItem.getPosition()) - 1, bean);
                            getView().showNewsVersionAbout(newVersionCardItem);
                        }
                    }
                }
            }

            @Override
            public void doOnError(Response<PageRespNewVersionCard> response, String statusCode, String message) {
                Log.d("TAG", "doOnError: ");
            }

            @Override
            public void doOnFailure(int httpCode, String message) {
                Log.d("TAG", "doOnFailure: ");
            }
        });
    }
}
