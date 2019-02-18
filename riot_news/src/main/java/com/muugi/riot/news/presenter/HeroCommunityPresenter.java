package com.muugi.riot.news.presenter;

import android.support.annotation.NonNull;

import com.muugi.riot.news.bean.CardItem;
import com.muugi.riot.news.bean.CardsResponse;
import com.muugi.riot.news.bean.HeroGroupListBean;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.HeroCommunityContract;
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

public class HeroCommunityPresenter extends HeroCommunityContract.Presenter {
    private int mCurrentPage = 0;

    public HeroCommunityPresenter(String cid) {
        super(cid);
    }

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
                    List<HeroGroupListBean> heroGroupListBeans = new ArrayList<>();
                    for (News news : list) {
                        HeroGroupListBean bean = new HeroGroupListBean(news, "news");
                        heroGroupListBeans.add(bean);
                    }
                    if (mCurrentPage == 0) {
                        getView().showNewsList(heroGroupListBeans);
                    } else {
                        getView().showMoreNewsList(mCurrentPage, heroGroupListBeans);
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
                if ("0".equals(cardsResponse.getCode())) {
                    List<CardItem> list = cardsResponse.getList();
                    if (list != null && list.size() != 0) {
                        for (int i = 0; i < list.size(); i++) {
                            if ("BattleVideosCard".equals(list.get(i).getNewstypeid())) {
                                HeroGroupListBean bean = new HeroGroupListBean(null, "BattleVideosCard");
                                HashMap<String, String> header = new HashMap<>();
                                header.put("hero", list.get(i).getHero_name());
                                bean.setHeader(header);
                                getView().updateCardItem(Integer.valueOf(list.get(i).getPosition()) - 1, bean);
                                CardItem battleVideosCard = list.get(i);
                                getView().showBattleVideoCard(battleVideosCard);
                            }
                            if ("RecentHeroCard".equals(list.get(i).getNewstypeid())) {
                                HeroGroupListBean bean = new HeroGroupListBean(null, "RecentHeroCard");
                                getView().updateCardItem(Integer.valueOf(list.get(i).getPosition()) - 1, bean);
                                CardItem recentHeroCard = list.get(i);
                                getView().showRecentHeroCard(recentHeroCard);
                            }
                            if ("RecommendStrategyCard".equals(list.get(i).getNewstypeid())) {
                                HeroGroupListBean bean = new HeroGroupListBean(null, "RecommendStrategyCard");
                                HashMap<String, String> header = new HashMap<>();
                                header.put("hero", list.get(i).getHero_name());
                                bean.setHeader(header);
                                getView().updateCardItem(Integer.valueOf(list.get(i).getPosition()) - 1, bean);
                                CardItem recommendStrategy = list.get(i);
                                getView().showRecommendStrategyCard(recommendStrategy);
                            }

                            if ("PlayerShowCard".equals(list.get(i).getNewstypeid())) {
                                HeroGroupListBean bean = new HeroGroupListBean(null, "PlayerShowCard");
                                HashMap<String, String> header = new HashMap<>();
                                header.put("hero", list.get(i).getHero_name());
                                bean.setHeader(header);
                                getView().updateCardItem(Integer.valueOf(list.get(i).getPosition()) - 1, bean);
                                CardItem playerShow = list.get(i);
                                getView().showPlayerShowCard(playerShow);
                            }

                        }
                    } else {
                        System.out.println("null list");
                    }
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
