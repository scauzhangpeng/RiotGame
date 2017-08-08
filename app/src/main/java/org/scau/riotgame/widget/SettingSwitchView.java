package org.scau.riotgame.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/7/28.
 */

public class SettingSwitchView extends RelativeLayout {

    private TextView mTvMain;
    private TextView mTvSub;
    private Switch mIvSwitch;
    private View mLineBottom;
    private TextView mTvSubRight;

    public SettingSwitchView(Context context) {
        this(context, null);
    }

    public SettingSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.view_switch_setting, this);

        mTvMain = (TextView) findViewById(R.id.tv_main);
        mTvSub = (TextView) findViewById(R.id.tv_sub);
        mIvSwitch = (Switch) findViewById(R.id.iv_switch);
        mLineBottom = findViewById(R.id.line_bottom);
        mTvSubRight = (TextView) findViewById(R.id.tv_sub_right);

        TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.switch_view);

        String mainTip = typedArray.getString(R.styleable.switch_view_main_text);
        String subTip = typedArray.getString(R.styleable.switch_view_sub_text);
        setMainTip(mainTip);
        setSubTip(subTip);

        int visibility = typedArray.getInteger(R.styleable.switch_view_line_visible, 0);
        setBottomLineVisibility(visibility);

        boolean isCheck = typedArray.getBoolean(R.styleable.switch_view_check, false);
        setCheck(isCheck);

        typedArray.recycle();
    }

    public void setMainTip(String mainTip) {
        mTvMain.setText(mainTip);
    }

    public void setSubTip(String subTip) {
        if (TextUtils.isEmpty(subTip)) {
            mTvSub.setVisibility(GONE);
        } else {
            mTvSub.setText(subTip);
        }
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

    public void setCheck(boolean isCheck) {
        mIvSwitch.setChecked(isCheck);
    }

    public void setRightSubText(String text) {
        mTvSubRight.setVisibility(VISIBLE);
        mTvSubRight.setText(text);
    }
}
