package com.muugi.riot.discovery.hero.presenter;


import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.muugi.riot.discovery.hero.bean.FreeHeroInner;
import com.muugi.riot.discovery.hero.bean.FreeHeroResult;
import com.muugi.riot.discovery.hero.bean.Hero;
import com.muugi.riot.discovery.hero.contract.HeroContract;
import com.muugi.riot.discovery.hero.model.WebManager;
import com.xyz.riotcommon.net.HttpCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class FreeHeroPresenter extends HeroContract.FreePresenter {
    @Override
    public void getFreeHeros() {
        WebManager.getInstance().getFreeHero(9740, new HttpCallback<String>() {
            @Override
            public void doOnSuccess(@NonNull String body, Response<String> response) {
                int index = body.indexOf("free=");
                int endIndex = body.indexOf(";/");
                String resp = body.substring(index + "free=".length(), endIndex);
                Gson gson = new Gson();
                FreeHeroResult freeHeroResult = gson.fromJson(resp, new TypeToken<FreeHeroResult>() {
                }.getType());

                List<Hero> heroes = new ArrayList<>();
                HashMap<String, String> keys = freeHeroResult.getKeys();
                HashMap<String, FreeHeroInner> data = freeHeroResult.getData();
                for (String key : keys.values()) {
                    FreeHeroInner freeHeroInner = data.get(key);
                    Hero hero = new Hero();
                    hero.setName(freeHeroInner.getName());
                    hero.setNick(freeHeroInner.getTitle());
                    hero.setTag1(freeHeroInner.getTags().get(0));
                    heroes.add(hero);
                }
                getView().showFreeHeros(heroes);
            }

            @Override
            public void doOnError(Response<String> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }
}
