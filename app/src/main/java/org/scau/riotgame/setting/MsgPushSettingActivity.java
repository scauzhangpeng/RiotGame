package org.scau.riotgame.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;

import org.scau.riotgame.base.BaseActivity;
import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/7/30.
 * <p>
 * 推送消息设置
 * </p>
 */

public class MsgPushSettingActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_push_setting);
        initTopBar(this);
    }
}
