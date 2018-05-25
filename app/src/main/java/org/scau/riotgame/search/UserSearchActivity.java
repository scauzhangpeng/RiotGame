package org.scau.riotgame.search;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

import butterknife.OnClick;

/**
 * Created by ZP on 2017/8/2.
 */

public class UserSearchActivity extends SimpleTopBarActivity {




    @OnClick(R.id.rl_recently_play_with)
    public void recentlyPlayWith() {
//        openActivity();
    }

    @OnClick(R.id.rl_user_nearby)
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
