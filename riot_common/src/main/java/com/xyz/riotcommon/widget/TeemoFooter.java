package com.xyz.riotcommon.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.xyz.riotcommon.R;


/**
 * Created by ZP on 2017/8/7.
 */

public class TeemoFooter extends LinearLayout implements RefreshFooter {

    private ImageView mImageView;
    private TextView mTextView;
    private AnimationDrawable mAnimationDrawable;

    public TeemoFooter(Context context) {
        this(context, null);
    }

    public TeemoFooter(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TeemoFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    private void initViews(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.refresh_header_teemo, this);
        mImageView = (ImageView) view.findViewById(R.id.header_frame_icon);
        mTextView = (TextView) view.findViewById(R.id.header_msg);
        mAnimationDrawable = (AnimationDrawable) mImageView.getDrawable();
    }

    @Override
    public void onPullingUp(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public void onPullReleasing(float percent, int offset, int footerHeight, int extendHeight) {

    }

    @Override
    public boolean setLoadmoreFinished(boolean finished) {
        return false;
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {
        mAnimationDrawable.start();
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        mAnimationDrawable.stop();
        if (success) {
            mTextView.setText("加载完成");
        } else {
            mTextView.setText("加载失败");
        }
        return 500;
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case None:
            case PullToUpLoad:
                mTextView.setText("上拉加载");
                break;
            case ReleaseToLoad:
                mTextView.setText("释放加载");
                break;
            case Loading:
                mTextView.setText("正在加载");
                mAnimationDrawable.start();
                break;
        }
    }
}
