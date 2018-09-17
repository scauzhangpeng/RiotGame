package com.muugi.capture;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

/**
 * Created by ZP on 2018/9/16.
 */

public class QRActivity extends SimpleTopBarActivity {


    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_my_qr;
    }
}
