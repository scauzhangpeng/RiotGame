package com.muugi.riot.news.presenter;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.ColumnList;
import com.muugi.riot.news.bean.PageColumnList;
import com.muugi.riot.news.bean.SpecialColumnListBean;
import com.muugi.riot.news.contract.ColumnContract;
import com.muugi.riot.news.model.RequestManager;
import com.xyz.riotcommon.net.HttpCallback;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2017/8/23.
 */

public class ColumnListPresenter extends ColumnContract.Presenter {

    private int mCurrentPage = 0;

    public ColumnListPresenter(String cid) {
        super(cid);
    }

    @Override
    public void refreshNews() {
        mCurrentPage = 0;
        loadMoreNews();
    }

    @Override
    public void loadMoreNews() {
        RequestManager.getInstance().getColumnList(mCurrentPage, 9740, new HttpCallback<PageColumnList>() {

            @Override
            public void doOnSuccess(@NonNull PageColumnList pageColumnList, Response<PageColumnList> response) {
                List<ColumnList> unBook_list = pageColumnList.getUnbook_list();
                List<ColumnList> book_list = pageColumnList.getBook_list();
                List<ColumnList> recommend_list = pageColumnList.getRecommend_list();
                List<SpecialColumnListBean> wrappers = new ArrayList<>();
                if (recommend_list != null && recommend_list.size() > 0) {
                    wrappers.add(new SpecialColumnListBean(null, 5));
                    for (ColumnList columnList : recommend_list) {
                        wrappers.add(new SpecialColumnListBean(columnList, 2));
                    }
                }

                if (book_list != null && book_list.size() > 0) {
                    wrappers.add(new SpecialColumnListBean(null, 4));
                    for (ColumnList columnList : book_list) {
                        wrappers.add(new SpecialColumnListBean(columnList, 1));
                    }
                }

                if (unBook_list != null && unBook_list.size() > 0) {
                    if (mCurrentPage == 0) {
                        wrappers.add(new SpecialColumnListBean(null, 3));
                    }
                    for (ColumnList columnList : unBook_list) {
                        wrappers.add(new SpecialColumnListBean(columnList, 0));
                    }
                }


                if (mCurrentPage == 0) {
                    getView().showListData(wrappers);
                } else {
                    getView().showMoreListData(mCurrentPage, wrappers);
                }
                if ("1".equals(pageColumnList.getHasnext())) {
                    mCurrentPage++;
                } else {

                }
            }

            @Override
            public void doOnError(Response<PageColumnList> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }
}
