package org.scau.riotgame.setting;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/7/30.
 * <p>
 * 推送消息设置
 * </p>
 */

public class MsgPushSettingActivity extends SimpleTopBarActivity {


    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_msg_push_setting;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
