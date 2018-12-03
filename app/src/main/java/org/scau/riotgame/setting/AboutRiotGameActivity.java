package org.scau.riotgame.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.util.PackageUtil;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ZP on 2017/7/30.
 * <p>
 * 关于掌盟
 * </p>
 */

public class AboutRiotGameActivity extends SimpleTopBarActivity {

    private static final String TAG = "AboutRiotGameActivity";

    @BindView(R.id.tv_version_info)
    TextView mTvVersionInfo;

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_about_roit_game;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        showVersionInfo();
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    private void showVersionInfo() {
        String appVersionName = PackageUtil.getAppVersionName(this);
        int appVersionCode = PackageUtil.getAppVersionCode(this);
        String versionInfo = getString(R.string.version_info, appVersionName, appVersionCode);
        mTvVersionInfo.setText(versionInfo);
    }

    @OnClick(R.id.btn_update_version)
    public void updateVersion() {
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent);
    }
}
