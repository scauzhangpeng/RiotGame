package com.muugi.riot.news.router;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyz.riotcommon.router.RiotNewsService;

import org.litepal.LitePal;

import static com.xyz.riotcommon.RouterConstants.RIOT_NEWS_SERVICE;

/**
 * Created by ZP on 2019/3/27.
 */
@Route(path = RIOT_NEWS_SERVICE, name = "riot_news_service")
public class RiotNewsServiceImpl implements RiotNewsService {

    private static final String TAG = "RiotNewsServiceImpl";

    @Override
    public void initLitePal(Context context) {
        LitePal.initialize(context);
    }

    @Override
    public void init(Context context) {
        Log.d(TAG, "init: " + context);
    }
}
