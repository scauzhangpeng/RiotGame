package org.scau.riotgame.setting;

import android.os.Bundle;
import android.widget.Button;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;
import org.scau.riotgame.widget.SettingSwitchView;

import butterknife.BindView;

/**
 * Created by ZP on 2017/8/1.
 */

public class ClearCacheActivity extends SimpleTopBarActivity {

    @BindView(R.id.switch_game_cache)
    SettingSwitchView mSwitchGameCache;
    @BindView(R.id.switch_picture_cache)
    SettingSwitchView mSwitchPictureCache;
    @BindView(R.id.switch_app_cache)
    SettingSwitchView mSwitchAppCache;
    @BindView(R.id.switch_video_cache)
    SettingSwitchView mSwitchVideoCache;
    @BindView(R.id.btn_confirm_clear)
    Button mBtnConfirmClear;

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_clear_cache;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        initData();
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }


    private void initData() {
        mSwitchGameCache.setRightSubText("167.66KB");
        mSwitchPictureCache.setRightSubText("122.66KB");
        mSwitchAppCache.setRightSubText("1347.66KB");
        mSwitchVideoCache.setRightSubText("0KB");
    }
}
