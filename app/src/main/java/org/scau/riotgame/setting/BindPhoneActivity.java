package org.scau.riotgame.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseActivity;

/**
 * Created by ZP on 2017/8/3.
 */

public class BindPhoneActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_phone);
        initTopBar(this);
    }
}
