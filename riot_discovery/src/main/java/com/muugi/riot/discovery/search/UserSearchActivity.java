package com.muugi.riot.discovery.search;

import com.muugi.riot.discovery.R;
import com.muugi.riot.discovery.R2;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import butterknife.OnClick;

/**
 * Created by ZP on 2017/8/2.
 */

public class UserSearchActivity extends SimpleTopBarActivity {


    @OnClick(R2.id.rl_recently_play_with)
    public void recentlyPlayWith() {
//        openActivity();
    }

    @OnClick(R2.id.rl_user_nearby)
    public void userNearby() {
        openActivity(UserNearbyActivity.class);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_user_search;
    }
}
