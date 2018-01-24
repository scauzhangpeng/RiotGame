package org.scau.riotgame.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/8/7.
 */

public class TeemoHeader extends LinearLayout implements RefreshHeader {

    private ImageView mImageView;
    private TextView mTextView;
    private AnimationDrawable mAnimationDrawable;


    public TeemoHeader(Context context) {
        this(context, null);
    }

    public TeemoHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TeemoHeader(Context context, AttributeSet attrs, int defStyleAttr) {
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
    public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {

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
            mTextView.setText("刷新完成");
        } else {
            mTextView.setText("刷新失败");
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
            case PullDownToRefresh:
                mTextView.setText("下拉刷新");
                if (mAnimationDrawable.isRunning()) {
                    mAnimationDrawable.stop();
                }
                break;
            case ReleaseToRefresh:
                mTextView.setText("释放刷新");
                break;
            case Refreshing:
                mTextView.setText("正在刷新");
                mAnimationDrawable.start();
                break;
        }
    }
}
