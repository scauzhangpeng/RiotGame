package com.muugi.capture;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.util.ClipboardUtil;
import com.xyz.riotcommon.SimpleTopBarActivity;

import butterknife.BindView;

/**
 * Created by ZP on 2018/9/16.
 */

public class ScanTipActivity extends SimpleTopBarActivity {


    @BindView(R2.id.tv_scan_result)
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
            mTvScanResult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClipboardUtil.copyText(ScanTipActivity.this, mTvScanResult.getText());
                    showToastShort("已复制到剪切板");
                }
            });
        }
    }
}
