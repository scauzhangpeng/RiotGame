package org.scau.riotgame.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/8/1.
 * Activity 基类
 */

public class BaseActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 启动Activity
     *
     * @param cls 需要启动的Activity名称
     */
    protected void openActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    protected Toolbar initTopBar(AppCompatActivity activity) {
        mTvTitle = (TextView) activity.findViewById(R.id.toolbar_title);
        mToolbar = (Toolbar) activity.findViewById(R.id.toolbar);
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
