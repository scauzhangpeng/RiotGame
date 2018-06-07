package org.scau.riotgame.home.presenter;

import android.support.annotation.NonNull;

import org.scau.riotgame.home.bean.ColumnList;
import org.scau.riotgame.home.bean.PageColumnList;
import org.scau.riotgame.home.contract.ColumnContract;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2017/8/23.
 */

public class ColumnListPresenter extends ColumnContract.Presenter {

    private int mCurrentPage = 0;

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
                List<ColumnList> unbook_list = pageColumnList.getUnbook_list();
                if (unbook_list != null) {
                    if (mCurrentPage == 0) {
                        getView().showColumnList(unbook_list);
                    } else {
                        getView().showMoreColumnList(mCurrentPage, unbook_list);
                    }
                    mCurrentPage++;
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
