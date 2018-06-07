package org.scau.riotgame.hero;

import android.support.annotation.NonNull;

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
            public void doOnSuccess(@NonNull List<Hero> heroes, Response<List<Hero>> response) {
                if (getView() != null) {
                    getView().showAllHeros(heroes);
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
