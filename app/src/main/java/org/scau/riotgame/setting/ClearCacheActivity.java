package org.scau.riotgame.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseActivity;
import org.scau.riotgame.widget.SettingSwitchView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ZP on 2017/8/1.
 */

public class ClearCacheActivity extends BaseActivity {

    @Bind(R.id.switch_game_cache)
    SettingSwitchView mSwitchGameCache;
    @Bind(R.id.switch_picture_cache)
    SettingSwitchView mSwitchPictureCache;
    @Bind(R.id.switch_app_cache)
    SettingSwitchView mSwitchAppCache;
    @Bind(R.id.switch_video_cache)
    SettingSwitchView mSwitchVideoCache;
    @Bind(R.id.btn_confirm_clear)
    Button mBtnConfirmClear;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear_cache);
        ButterKnife.bind(this);
        initTopBar(this);

        initData();
    }

    private void initData() {
        mSwitchGameCache.setRightSubText("167.66KB");
        mSwitchPictureCache.setRightSubText("122.66KB");
        mSwitchAppCache.setRightSubText("1347.66KB");
        mSwitchVideoCache.setRightSubText("0KB");
    }
}
