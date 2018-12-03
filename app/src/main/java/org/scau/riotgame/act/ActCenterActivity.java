package org.scau.riotgame.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;
import org.scau.riotgame.hero.HeroPageAdapter;

import butterknife.BindView;

/**
 * Created by ZP on 2018/6/8.
 */

public class ActCenterActivity extends SimpleTopBarActivity {


    @BindView(R.id.rg_act)
    RadioGroup mRgAct;
    @BindView(R.id.vp_act)
    ViewPager mVpAct;
    @BindView(R.id.rbtn_act_open)
    RadioButton mRbtnActOpen;
    @BindView(R.id.rbtn_act_close)
    RadioButton mRbtnActClose;

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        mRgAct.setOnCheckedChangeListener(mOnCheckedChangeListener);
        mVpAct.addOnPageChangeListener(mOnPageChangeListener);

        SparseArray<Fragment> pages = new SparseArray<>();
        pages.put(0, new OpenActFragment());
        pages.put(1, new CloseActFragment());
        mVpAct.setAdapter(new HeroPageAdapter(getSupportFragmentManager(), pages));
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_act_center;
    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mRbtnActOpen.setChecked(true);
                    break;
                case 1:
                    mRbtnActClose.setChecked(true);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rbtn_act_open:
                    mVpAct.setCurrentItem(0);
                    break;
                case R.id.rbtn_act_close:
                    mVpAct.setCurrentItem(1);
                    break;
            }
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVpAct.removeOnPageChangeListener(mOnPageChangeListener);
    }
}
