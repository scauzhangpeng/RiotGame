package org.scau.riotgame.setting;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/8/1.
 */

public class SecretSettingActivity extends SimpleTopBarActivity {

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_secret_setting;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
