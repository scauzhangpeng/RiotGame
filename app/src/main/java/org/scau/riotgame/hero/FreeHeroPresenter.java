package org.scau.riotgame.hero;


import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.WebManager;

import java.util.Iterator;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class FreeHeroPresenter extends HeroContract.FreePresenter {
    @Override
    void getFreeHeros() {
        WebManager.getInstance().getFreeHero(9740, new HttpCallback<String>() {
            @Override
            public void doOnSuccess(@NonNull String body, Response<String> response) {
                int index = body.indexOf("free=");
                String resp = body.substring(index + "free=".length());
                try {
                    JSONObject jsonObject = new JSONObject(resp);
                    JSONObject keys = jsonObject.getJSONObject("keys");
                    Iterator<String> iterator = keys.keys();
                    while (iterator.hasNext()) {
                        String next = iterator.next();
                        String name = keys.getString(next);
                        System.out.println(name);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
