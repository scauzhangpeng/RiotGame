package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.CommonActivity;

import org.scau.riotgame.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ZP on 2017/8/2.
 */

public class HeroInfoActivity extends CommonActivity {


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
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_layout)
    CollapsingToolbarLayout mCollapsingLayout;
    @BindView(R.id.appbar_layout)
    AppBarLayout mAppbarLayout;


    private SparseArray<Fragment> mFragments;
    private HeroPageAdapter mPagerAdapter;
    private HeroFreeFragment mFreeHeroFragment;
    private HeroOwnerFragment mOwnerHeroFragment;
    private HeroAllFragment mAllHeroFragment;

    @Override
    protected void initTopBar(View topView) {

    }

    @Override
    protected int getTopBarContentId() {
        return 0;
    }

    @Override
    protected int getTopBarLayoutId() {
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hero_info;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbarTitle.setText("我的英雄圈");

        mVpHero.addOnPageChangeListener(mOnPageChangeListener);
        mRgHero.setOnCheckedChangeListener(mOnCheckedChangeListener);

        mFragments = new SparseArray<>();
        mFreeHeroFragment = new HeroFreeFragment();
        mOwnerHeroFragment = new HeroOwnerFragment();
        mAllHeroFragment = new HeroAllFragment();
        mFragments.put(0, mFreeHeroFragment);
        mFragments.put(1, mOwnerHeroFragment);
        mFragments.put(2, mAllHeroFragment);
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

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }


    @OnClick(R.id.tv_prop)
    public void openGoodsList(View view) {
        openActivity(GoodsListActivity.class);
    }
}
