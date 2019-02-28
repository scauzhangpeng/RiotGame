package com.muugi.riot.news.presenter;

import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.HotNewsContract;
import com.muugi.riot.news.model.NewsDataSource;
import com.muugi.riot.news.model.NewsRepository;
import com.xyz.riotcommon.bean.PageResponse;

import java.util.List;

/**
 * Created by ZP on 2018/11/10.
 */
public class HotNewsPresenter extends HotNewsContract.Presenter {

    public HotNewsPresenter(String cid, NewsRepository newsRepository) {
        super(cid, newsRepository);
    }

    @Override
    public void loadMoreNews() {
        mNewsRepository.loadNewsData(cid, mCurrentPage, new NewsDataSource.LoadNewsCallback() {
            @Override
            public void onNewsLoadSuccess(List<News> data, PageResponse<News> pageResponse, int type) {
                if (mCurrentPage == 0) {
                    if (isViewAttach()) {
                        getView().showListData(data);
                    }
                } else {
                    if (isViewAttach()) {
                        getView().showMoreListData(mCurrentPage, data);
                    }
                }

                if ("True".equals(pageResponse.getNext())) {
                    mCurrentPage++;
                } else {
                    if (isViewAttach()) {
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
}
