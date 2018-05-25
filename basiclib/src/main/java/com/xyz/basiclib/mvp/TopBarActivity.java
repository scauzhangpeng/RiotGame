package com.xyz.basiclib.mvp;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xyz.basiclib.R;

/**
 * Created by ZP on 2018/1/25.
 */

public abstract class TopBarActivity extends ButterKnifeActivity {

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
        mTopBarLayoutId = getTopBarLayoutId();
        //如果顶部和内容都是为空则直接跳过本布局
        if (mTopBarLayoutId == 0 && getTopBarContentId() == 0) {
            super.onCreate(savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            initRootView(R.layout.activity_base_topbar);
            setContentView(getTopBarContentId());
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
        if (mTopBarLayoutId == 0 && getTopBarContentId() == 0) {
            super.setContentView(layoutResID);
        } else {
            mFlTopBar = (FrameLayout) findViewById(R.id.fl_topbar);
            mFlContent = (FrameLayout) findViewById(R.id.fl_content);

            LayoutInflater.from(this).inflate(layoutResID, mFlContent, true);

            mTopView = LayoutInflater.from(this).inflate(mTopBarLayoutId, mFlContent, false);
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
        return 0;
    }

    protected abstract int getTopBarContentId();

    protected abstract int getTopBarLayoutId();
}
