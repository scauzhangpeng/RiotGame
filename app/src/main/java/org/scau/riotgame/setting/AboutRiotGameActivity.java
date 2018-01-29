package org.scau.riotgame.setting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.xyz.basiclib.PackageUtil;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZP on 2017/7/30.
 * <p>
 * 关于掌盟
 * </p>
 */

public class AboutRiotGameActivity extends BaseActivity {

    private static final String TAG = "AboutRiotGameActivity";

    @Bind(R.id.tv_version_info)
    TextView mTvVersionInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_roit_game);
        ButterKnife.bind(this);
        initTopBar(this);

        showVersionInfo();
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
