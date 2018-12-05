package com.muugi.riot.discovery.hero.presenter;

import android.support.annotation.NonNull;

import com.muugi.riot.discovery.hero.bean.Hero;
import com.muugi.riot.discovery.hero.contract.HeroContract;
import com.muugi.riot.discovery.hero.model.OSSWebManager;
import com.xyz.riotcommon.net.HttpCallback;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class AllHeroPresenter extends HeroContract.Presenter {
    @Override
    public void getAllHeros() {
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
