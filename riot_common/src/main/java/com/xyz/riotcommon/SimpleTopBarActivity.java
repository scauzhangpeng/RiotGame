package com.xyz.riotcommon;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.xyz.basiclib.activity.TopBarActivity;

/**
 * Created by ZP on 2018/1/29.
 */

public abstract class SimpleTopBarActivity extends TopBarActivity {

    private TextView mTvTitle;
    private Toolbar mToolbar;


    @Override
    protected void initTopBar(View topView) {
        initDefaultTopBar(topView);
    }

    @Override
    protected int getTopBarHeaderId() {
        return R.layout.toolbar_default;
    }

    protected Toolbar initDefaultTopBar(View topView) {
        mTvTitle = (TextView) topView.findViewById(R.id.toolbar_title);
        mToolbar = (Toolbar) topView.findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        //mToolbar.setPadding(0, ScreenUtil.getStatusBarHeight(this), 0, 0);
        //mToolbar.setNavigationIcon(R.drawable.nav_back_selector);

        setSupportActionBar(mToolbar);
        //必须设置在setSupportActionBar之后才有用
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mTvTitle.setText(getTitle().toString());
        return mToolbar;
    }
}
