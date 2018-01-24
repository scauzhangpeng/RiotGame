package com.xyz.basiclib.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ZP on 2017/8/1.
 * Activity 基类
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private TextView mTvTitle;
    private ImageView mIvLeft;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
//        ButterKnife.bind(this);
        initViewsAndEvents(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    protected abstract void initViewsAndEvents(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    /**
     * 启动Activity
     *
     * @param cls 需要启动的Activity名称
     */
    protected void openActivity(Class<?> cls) {
        openActivity(cls, null);
    }

    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

//    protected Toolbar initTopBar(AppCompatActivity activity) {
//        mTvTitle = (TextView) activity.findViewById(R.id.toolbar_title);
//        mIvLeft = (ImageView) activity.findViewById(R.id.toolbar_left);
//
//        mToolbar = (Toolbar) activity.findViewById(R.id.toolbar);
//        mToolbar.setTitle("");
//        //mToolbar.setPadding(0, ScreenUtil.getStatusBarHeight(this), 0, 0);
//        //mToolbar.setNavigationIcon(R.drawable.nav_back_selector);
//
//        setSupportActionBar(mToolbar);
//        //必须设置在setSupportActionBar之后才有用
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               finish();
//            }
//        });
//
//        mTvTitle.setText(getTitle().toString());
//        return mToolbar;
//    }

    protected Toolbar setLeftImage(int resId) {
        mToolbar.setNavigationIcon(null);
        mIvLeft.setVisibility(View.VISIBLE);
        mIvLeft.setImageDrawable(getResources().getDrawable(resId));
        return mToolbar;
    }

//    protected Toolbar setLeftImage(AbstractImageLoader abstractImageLoader) {
//        mToolbar.setNavigationIcon(null);
//        mIvLeft.setVisibility(View.VISIBLE);
//        abstractImageLoader.loadImage(mIvLeft, abstractImageLoader.getPath());
//        return mToolbar;
//    }

    protected Toolbar setOnLeftClickListener(View.OnClickListener onClickListener) {
        mIvLeft.setOnClickListener(onClickListener);
        return mToolbar;
    }

    protected Toolbar setTitle(String title) {
        mTvTitle.setText(title);
        return mToolbar;
    }

    @Override
    public void showToastLong(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToastShort(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
