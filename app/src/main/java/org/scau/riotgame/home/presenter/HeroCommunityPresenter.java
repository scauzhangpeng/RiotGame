package org.scau.riotgame.home.presenter;

import android.support.annotation.NonNull;

import org.scau.riotgame.home.bean.Card;
import org.scau.riotgame.home.bean.CardItem;
import org.scau.riotgame.home.bean.CardsResponse;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.bean.PageResponse;
import org.scau.riotgame.home.contract.HeroCommunityContract;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class HeroCommunityPresenter extends HeroCommunityContract.Presenter {
    private int mCurrentPage = 0;
    @Override
    public void refreshNews() {
        mCurrentPage = 0;
        loadMoreNews();
    }

    @Override
    public void loadMoreNews() {
        RequestManager.getInstance().getHeroGroup(mCurrentPage, "0c8a808f-61bd-4312-a9cc-a7a179b968a1", 7, 9740, new HttpCallback<PageResponse<News>>() {
            @Override
            public void doOnSuccess(@NonNull PageResponse<News> newsPageResponse, Response<PageResponse<News>> response) {
                List<News> list = newsPageResponse.getList();
                if (list != null && list.size() != 0) {
                    if (mCurrentPage == 0) {
                        getView().showNewsList(list);
                    } else {
                        getView().showMoreNewsList(mCurrentPage, list);
                    }
                    mCurrentPage++;
                } else {
                    System.out.println("null list");
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
    public void refreshCardsData() {
        RequestManager.getInstance().getCardsData("0c8a808f-61bd-4312-a9cc-a7a179b968a1", 7, 9740, new HttpCallback<CardsResponse>() {
            @Override
            public void doOnSuccess(@NonNull CardsResponse cardsResponse, Response<CardsResponse> response) {
                List<CardItem> list = cardsResponse.getList();
                if (list != null && list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
                        if ("BattleVideosCard".equals(list.get(i).getNewstypeid())) {
                            List<Card> data = list.get(i).getData();
                            getView().showBattleVideo(data);
                        }
                        if ("RecentHeroCard".equals(list.get(i).getNewstypeid())) {
                            List<Card> data = list.get(i).getData();
                            getView().showRecentHero(data);
                        }
                    }
                } else {
                    System.out.println("null list");
                }
            }

            @Override
            public void doOnError(Response<CardsResponse> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }
}
