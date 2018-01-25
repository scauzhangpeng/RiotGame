package com.xyz.basiclib.mvp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xyz.basiclib.R;

/**
 * Created by ZP on 2018/1/25.
 */

public abstract class TopBarActivity extends AppCompatActivity {

    /**
     * 顶部布局
     */
    private FrameLayout mFlTopBar;
    /**
     * 内容布局
     */
    private FrameLayout mFlContent;

    /**
     * 顶部标题栏
     */
    private View mTopView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRootView(R.layout.activity_base_topbar);
        setContentView(getLayoutId());
        initTopBar(mTopView);
        initViewsAndEvents(savedInstanceState);
    }

    protected abstract void initTopBar(View topView);

    private void initRootView(@LayoutRes int layoutResID) {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        LayoutInflater.from(this).inflate(layoutResID, viewGroup, true);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        //super.setContentView(layoutResID);
        mFlTopBar = (FrameLayout) findViewById(R.id.fl_topbar);
        mFlContent = (FrameLayout) findViewById(R.id.fl_content);

        LayoutInflater.from(this).inflate(layoutResID, mFlContent, true);

        mTopView = getTopBarView();
        if (mTopView != null) {
            mFlTopBar.addView(mTopView);
            mFlTopBar.setVisibility(View.VISIBLE);
        } else {
            mFlTopBar.setVisibility(View.GONE);
        }
    }

    protected abstract View getTopBarView();

    protected abstract int getLayoutId();

    protected abstract void initViewsAndEvents(Bundle savedInstanceState);
}
