package org.scau.riotgame.search;

import android.os.Bundle;

import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

import butterknife.OnClick;

/**
 * Created by ZP on 2017/8/2.
 */

public class UserSearchActivity extends SimpleTopBarActivity {

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_user_search;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {

    }

    @OnClick(R.id.rl_recently_play_with)
    public void recentlyPlayWith() {
//        openActivity();
    }

    @OnClick(R.id.rl_user_nearby)
    public void userNearby() {
        openActivity(UserNearbyActivity.class);
    }
}
