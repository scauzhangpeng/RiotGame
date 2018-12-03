package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.muugi.riot.news.view.NewsFragment;
import com.muugi.riot.news.view.ColumnListFragment;
import com.muugi.riot.news.view.HeroCommunityFragment;
import com.muugi.riot.news.view.HotNewsFragment;
import com.muugi.riot.news.view.NewVersionFragment;
import com.muugi.riot.news.view.OfficialNewsFragment;
import com.muugi.riot.news.view.VideoFragment;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.CommonFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.hero.HeroPageAdapter;

import butterknife.BindView;

/**
 * Created by ZP on 2018/1/24.
 */

public class HomeFragment extends CommonFragment implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.rbtn_last)
    RadioButton mRbtnLast;
    @BindView(R.id.rbtn_new_version)
    RadioButton mRbtnNewVersion;
    @BindView(R.id.rbtn_hero)
    RadioButton mRbtnHero;
    @BindView(R.id.rbtn_video)
    RadioButton mRbtnVideo;
    //    @BindView(R.id.rbtn_match)
//    RadioButton mRbtnMatch;
    @BindView(R.id.rbtn_column)
    RadioButton mRbtnColumn;
    @BindView(R.id.rg_main_tab)
    RadioGroup mRgMainTab;
    @BindView(R.id.rbtn_hot)
    RadioButton mRbtnHot;
    @BindView(R.id.rbtn_office)
    RadioButton mRbtnOffice;

    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private SparseArray<Fragment> mPages;

    private FragmentPagerAdapter mAdapter;

    public static final int PAGE_LAST = 0;
    public static final int PAGE_HOT = 1;
    public static final int PAGE_COLUMN = 2;
    public static final int PAGE_VIDEO = 3;
    public static final int PAGE_NEW_VERSION = 4;
    public static final int PAGE_OFFICE = 5;
    public static final int PAGE_HERO = 6;

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case PAGE_LAST:
                    mRbtnLast.setChecked(true);
                    break;
                case PAGE_HOT:
                    mRbtnHot.setChecked(true);
                    break;
                case PAGE_COLUMN:
                    mRbtnColumn.setChecked(true);
                    break;
                case PAGE_VIDEO:
                    mRbtnVideo.setChecked(true);
                    break;
                case PAGE_NEW_VERSION:
                    mRbtnNewVersion.setChecked(true);
                    break;
                case PAGE_OFFICE:
                    mRbtnOffice.setChecked(true);
                    break;
                case PAGE_HERO:
                    mRbtnHero.setChecked(true);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        initTopBar();
        mRgMainTab.setOnCheckedChangeListener(this);

        mPages = new SparseArray<>();
        mPages.put(PAGE_LAST, new NewsFragment());
        mPages.put(PAGE_HOT, new HotNewsFragment());
        mPages.put(PAGE_COLUMN, new ColumnListFragment());
        mPages.put(PAGE_VIDEO, new VideoFragment());
        mPages.put(PAGE_NEW_VERSION, new NewVersionFragment());
        mPages.put(PAGE_OFFICE, new OfficialNewsFragment());
        mPages.put(PAGE_HERO, new HeroCommunityFragment());
        mAdapter = new HeroPageAdapter(getActivity().getSupportFragmentManager(), mPages);
        mVpMain.setAdapter(mAdapter);
        mVpMain.addOnPageChangeListener(mOnPageChangeListener);
        mVpMain.setOffscreenPageLimit(6);
    }

    private void initTopBar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        mToolbar.setTitle("");
        activity.setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
        mToolbar.setNavigationIcon(null);
        mToolbarTitle.setText("英雄联盟");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_news_search) {
            showToastLong("search");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.news_search, menu);
//        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rbtn_last:
                mVpMain.setCurrentItem(PAGE_LAST);
                break;
            case R.id.rbtn_new_version:
                mVpMain.setCurrentItem(PAGE_NEW_VERSION);
                break;
            case R.id.rbtn_hero:
                mVpMain.setCurrentItem(PAGE_HERO);
                break;
            case R.id.rbtn_video:
                mVpMain.setCurrentItem(PAGE_VIDEO);
                break;
            case R.id.rbtn_hot:
                mVpMain.setCurrentItem(PAGE_HOT);
                break;
            case R.id.rbtn_column:
                mVpMain.setCurrentItem(PAGE_COLUMN);
                break;
            case R.id.rbtn_office:
                mVpMain.setCurrentItem(PAGE_OFFICE);
                break;
        }
    }

    @Override
    public void onDestroy() {
        if (mOnPageChangeListener != null) {
            mVpMain.removeOnPageChangeListener(mOnPageChangeListener);
        }
        super.onDestroy();
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
