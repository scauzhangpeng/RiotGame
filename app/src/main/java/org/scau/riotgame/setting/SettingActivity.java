package org.scau.riotgame.setting;

import android.os.Bundle;
import android.view.View;

import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;
import org.scau.riotgame.webview.WebViewActivity;
import org.scau.riotgame.widget.SettingItemView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ZP on 2017/7/27.
 * <p>
 * 设置
 * <p/>
 */

public class SettingActivity extends SimpleTopBarActivity {

    @Bind(R.id.stv_bind_area)
    SettingItemView mStvBindArea;
    @Bind(R.id.stv_bind_phone)
    SettingItemView mStvBindPhone;
    @Bind(R.id.stv_msg_setting)
    SettingItemView mStvMsgSetting;
    @Bind(R.id.stv_save_data)
    SettingItemView mStvSaveData;
    @Bind(R.id.stv_clear_cache)
    SettingItemView mStvClearCache;
    @Bind(R.id.stv_secret_setting)
    SettingItemView mStvSecretSetting;
    @Bind(R.id.stv_about_riot)
    SettingItemView mStvAboutRiot;
    @Bind(R.id.stv_feed_back)
    SettingItemView mStvFeedBack;

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {

    }

    @OnClick(R.id.stv_bind_area)
    public void bindingArea() {
        openActivity(WebViewActivity.class);
    }

    @OnClick(R.id.stv_bind_phone)
    public void bingingMobilePhone(View view) {
        openActivity(BindPhoneActivity.class);
    }

    @OnClick(R.id.stv_msg_setting)
    public void msgPushSetting(View view) {
        openActivity(MsgPushSettingActivity.class);
    }

    @OnClick(R.id.stv_clear_cache)
    public void clearCache(View view) {
        openActivity(ClearCacheActivity.class);
    }

    @OnClick(R.id.stv_secret_setting)
    public void secretSetting(View view) {
        openActivity(SecretSettingActivity.class);
    }

    @OnClick(R.id.stv_about_riot)
    public void aboutRiotGame(View view) {
        openActivity(AboutRiotGameActivity.class);
    }

    @OnClick(R.id.stv_feed_back)
    public void feedback(View view) {
        openActivity(FeedBackActivity.class);
    }
}
