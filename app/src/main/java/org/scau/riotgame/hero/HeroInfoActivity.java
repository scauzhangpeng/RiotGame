package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZP on 2017/8/2.
 */

public class HeroInfoActivity extends BaseActivity {


    @BindView(R.id.rbtn_hero_free)
    RadioButton mRbtnHeroFree;
    @BindView(R.id.rbtn_hero_owner)
    RadioButton mRbtnHeroOwner;
    @BindView(R.id.rbtn_hero_all)
    RadioButton mRbtnHeroAll;
    @BindView(R.id.rg_hero)
    RadioGroup mRgHero;
    @BindView(R.id.vp_hero)
    ViewPager mVpHero;


    private SparseArray<Fragment> mFragments;
    private HeroPageAdapter mPagerAdapter;
    private FreeHeroFragment mFreeHeroFragment;
    private OwnerHeroFragment mOwnerHeroFragment;
    private AllHeroFragment mAllHeroFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_info);
        ButterKnife.bind(this);
        initTopBar(this);
        initViewAndEvents();
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


    private void initViewAndEvents() {
        mVpHero.addOnPageChangeListener(mOnPageChangeListener);
        mRgHero.setOnCheckedChangeListener(mOnCheckedChangeListener);

        mFragments = new SparseArray<>();
        mFreeHeroFragment = new FreeHeroFragment();
        mOwnerHeroFragment = new OwnerHeroFragment();
        mAllHeroFragment = new AllHeroFragment();
        mFragments.put(0, mFreeHeroFragment);
        mFragments.put(1, mOwnerHeroFragment);
        mFragments.put(2, mAllHeroFragment);
        mPagerAdapter = new HeroPageAdapter(getSupportFragmentManager(), mFragments);
        mVpHero.setAdapter(mPagerAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVpHero.removeOnPageChangeListener(mOnPageChangeListener);
    }
}
