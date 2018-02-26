package org.scau.riotgame.hero;

import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.OSSWebManager;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class AllHeroPresenter extends HeroContract.Presenter {
    @Override
    void getAllHeros() {
        OSSWebManager.getInstance().getAllHero(new HttpCallback<List<Hero>>() {
            @Override
            public void doOnSuccess(Response<List<Hero>> response) {
                List<Hero> body = response.body();
                if (body != null) {
                    if (getView() != null) {
                        getView().showAllHeros(body);
                    }
                }
            }

            @Override
            public void doOnError(Response<List<Hero>> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }
}
