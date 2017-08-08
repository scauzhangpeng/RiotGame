package org.scau.riotgame.search;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZP on 2017/8/2.
 */

public class UserSearchActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);
        ButterKnife.bind(this);
        initTopBar(this);
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
