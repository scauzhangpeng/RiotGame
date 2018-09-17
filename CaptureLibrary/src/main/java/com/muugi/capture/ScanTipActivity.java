package com.muugi.capture;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import butterknife.Bind;

/**
 * Created by ZP on 2018/9/16.
 */

public class ScanTipActivity extends SimpleTopBarActivity {


    @Bind(R.id.tv_scan_result)
    TextView mTvScanResult;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_scan_tip;
    }


    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        String result_text = getIntent().getStringExtra("result_text");
        if (!TextUtils.isEmpty(result_text)) {
            mTvScanResult.setText(result_text);
        }
    }
}
