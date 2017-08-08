package org.scau.riotgame.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.scau.riotgame.base.BaseActivity;
import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/7/30.
 * <p>
 * 关于掌盟
 * </p>
 */

public class AboutRiotGameActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_roit_game);
        initTopBar(this);
    }
}
