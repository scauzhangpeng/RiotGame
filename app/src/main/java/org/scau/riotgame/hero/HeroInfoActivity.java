package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ZP on 2017/8/2.
 */

public class HeroInfoActivity extends SimpleTopBarActivity {


    @Bind(R.id.rbtn_hero_free)
    RadioButton mRbtnHeroFree;
    @Bind(R.id.rbtn_hero_owner)
    RadioButton mRbtnHeroOwner;
    @Bind(R.id.rbtn_hero_all)
    RadioButton mRbtnHeroAll;
    @Bind(R.id.rg_hero)
    RadioGroup mRgHero;
    @Bind(R.id.vp_hero)
    ViewPager mVpHero;


    private SparseArray<Fragment> mFragments;
    private HeroPageAdapter mPagerAdapter;
    private HeroFreeFragment mHeroFreeFragment;
    private HeroOwnerFragment mHeroOwnerFragment;
    private HeroAllFragment mHeroAllFragment;

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_hero_info;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        mVpHero.addOnPageChangeListener(mOnPageChangeListener);
        mRgHero.setOnCheckedChangeListener(mOnCheckedChangeListener);

        mFragments = new SparseArray<>();
        mHeroFreeFragment = new HeroFreeFragment();
        mHeroOwnerFragment = new HeroOwnerFragment();
        mHeroAllFragment = new HeroAllFragment();
        mFragments.put(0, mHeroFreeFragment);
        mFragments.put(1, mHeroOwnerFragment);
        mFragments.put(2, mHeroAllFragment);
        mPagerAdapter = new HeroPageAdapter(getSupportFragmentManager(), mFragments);
        mVpHero.setAdapter(mPagerAdapter);
    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mRbtnHeroFree.setChecked(true);
                    break;
                case 1:
                    mRbtnHeroOwner.setChecked(true);
                    break;
                case 2:
                    mRbtnHeroAll.setChecked(true);
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
                case R.id.rbtn_hero_free:
                    mVpHero.setCurrentItem(0);
                    break;
                case R.id.rbtn_hero_owner:
                    mVpHero.setCurrentItem(1);
                    break;
                case R.id.rbtn_hero_all:
                    mVpHero.setCurrentItem(2);
                    break;
            }
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVpHero.removeOnPageChangeListener(mOnPageChangeListener);
    }

    @OnClick(R.id.tv_prop)
    public void openProp(View view) {
        openActivity(GoogsListActivity.class);
    }
}
