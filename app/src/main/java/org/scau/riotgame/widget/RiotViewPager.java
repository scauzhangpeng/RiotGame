package org.scau.riotgame.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/8/3.
 */

public class RiotViewPager extends LinearLayout {

    private RadioGroup mRadioGroup;
    private ViewPager mViewPager;


    public RiotViewPager(Context context) {
        this(context, null);
    }

    public RiotViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);


        LayoutInflater.from(context).inflate(R.layout.view_riot_viewpager, this);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        mViewPager = (ViewPager) findViewById(R.id.vp_tab);


        for (int i = 0; i < 3; i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setButtonDrawable(null);
            radioButton.setText("A:" + i);
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f);
            radioButton.setLayoutParams(lp);
            mRadioGroup.addView(radioButton);
        }


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                System.out.println(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
