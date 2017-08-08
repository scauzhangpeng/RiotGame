package org.scau.riotgame.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/7/28.
 */

public class SettingItemView extends RelativeLayout {

    TextView mTvLeftTip;
    TextView mTvRightTip;
    ImageView mIvSettingNext;
    View mLineBottom;

    public SettingItemView(Context context) {
        this(context, null);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_next_item, this);
        mTvLeftTip = (TextView) findViewById(R.id.tv_left_tip);
        mTvRightTip = (TextView) findViewById(R.id.tv_right_tip);
        mIvSettingNext = (ImageView) findViewById(R.id.ic_setting_arrow);
        mLineBottom = findViewById(R.id.line_bottom);

        TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.nt_view);

        String leftTip = typedArray.getString(R.styleable.nt_view_left_tip);
        String rightTip = typedArray.getString(R.styleable.nt_view_right_tip);
        setLeftTip(leftTip);
        setRightTip(rightTip);

        int visibility = typedArray.getInteger(R.styleable.nt_view_line_bottom_visible, 0);
        setBottomLineVisibility(visibility);

        typedArray.recycle();
    }

    public void setRightTip(String rightTip) {
        mTvRightTip.setText(rightTip);
    }

    public void setLeftTip(String leftTip) {
        mTvLeftTip.setText(leftTip);
    }

    public void setBottomLineVisibility(int visibility) {
        if (visibility == 0) {
            mLineBottom.setVisibility(VISIBLE);
        }

        if (visibility == 8) {
            mLineBottom.setVisibility(GONE);
        }

        if (visibility == 4) {
            mLineBottom.setVisibility(INVISIBLE);
        }
    }
}
