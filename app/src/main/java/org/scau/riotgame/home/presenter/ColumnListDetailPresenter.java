package org.scau.riotgame.home.presenter;

import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.ColumnListDetailContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZP on 2018/11/18.
 */
public class ColumnListDetailPresenter extends ColumnListDetailContract.Presenter {

    private int mCurrentPage = 0;

    @Override
    public void refreshNews() {
        mCurrentPage = 0;
        loadMoreNews();
    }

    @Override
    public void loadMoreNews() {
        List<News> result = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            News news = new News();
            news.setNewstypeid("ordinary");
            news.setIs_top("True");
            news.setTitle("Tr111ue");
            news.setSummary("Tr111ue");
            news.setPv("121333");
            result.add(news);
        }
        if (getView() != null) {
            if (mCurrentPage == 0) {
                getView().showNewsList(result);
            } else {
                getView().showMoreNewsList(result);
            }
            mCurrentPage++;
        }
    }
}
