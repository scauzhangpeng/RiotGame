package com.xyz.basiclib.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xyz.basiclib.R;

import butterknife.ButterKnife;

/**
 * Created by ZP on 2018/1/25.
 */

public abstract class TopBarActivity extends BaseActivity {

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
    private int mTopBarLayoutId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: TopBarActivity");
        //首先获取顶部标题布局
        mTopBarLayoutId = getTopBarHeaderId();
        super.onCreate(savedInstanceState);
        if (mTopBarLayoutId != 0) {
            initRootView(R.layout.activity_base_topbar);
            setContentView(getTopBarContentId());
            ButterKnife.bind(this);
            initTopBar(mTopView);
            initViewsAndEvents(savedInstanceState);
        }
    }

    protected abstract void initTopBar(View topView);

    private void initRootView(@LayoutRes int layoutResID) {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        LayoutInflater.from(this).inflate(layoutResID, viewGroup, true);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        //如果没有顶部布局则直接按照正常系统设置
        if (mTopBarLayoutId == 0) {
            super.setContentView(layoutResID);
        } else {
            mFlTopBar = (FrameLayout) findViewById(R.id.fl_topbar);
            mFlContent = (FrameLayout) findViewById(R.id.fl_content);
            if (layoutResID != 0) {
                LayoutInflater.from(this).inflate(layoutResID, mFlContent, true);
            }

            mTopView = LayoutInflater.from(this).inflate(mTopBarLayoutId, mFlTopBar, false);
            if (mTopView != null) {
                mFlTopBar.addView(mTopView);
                mFlTopBar.setVisibility(View.VISIBLE);
            } else {
                mFlTopBar.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected int getLayoutId() {
        if (mTopBarLayoutId == 0) {
            return getTopBarContentId();
        } else {
            return 0;
        }
    }

    protected abstract int getTopBarHeaderId();
    protected abstract int getTopBarContentId();
}
