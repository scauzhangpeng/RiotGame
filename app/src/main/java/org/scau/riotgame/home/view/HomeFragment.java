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

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.CommonFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.hero.HeroPageAdapter;

import butterknife.Bind;

/**
 * Created by ZP on 2018/1/24.
 */

public class HomeFragment extends CommonFragment implements RadioGroup.OnCheckedChangeListener {


    @Bind(R.id.rbtn_last)
    RadioButton mRbtnLast;
    @Bind(R.id.rbtn_new_version)
    RadioButton mRbtnNewVersion;
    @Bind(R.id.rbtn_hero)
    RadioButton mRbtnHero;
    @Bind(R.id.rbtn_video)
    RadioButton mRbtnVideo;
    @Bind(R.id.rbtn_match)
    RadioButton mRbtnMatch;
    @Bind(R.id.rbtn_column)
    RadioButton mRbtnColumn;
    @Bind(R.id.rg_main_tab)
    RadioGroup mRgMainTab;
    @Bind(R.id.vp_main)
    ViewPager mVpMain;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    private SparseArray<Fragment> mPages;

    private FragmentPagerAdapter mAdapter;

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mRbtnLast.setChecked(true);
                    break;
                case 1:
                    mRbtnNewVersion.setChecked(true);
                    break;
                case 2:
                    mRbtnHero.setChecked(true);
                    break;
                case 3:
                    mRbtnVideo.setChecked(true);
                    break;
                case 4:
                    mRbtnMatch.setChecked(true);
                    break;
                case 5:
                    mRbtnColumn.setChecked(true);
                    break;
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
        mPages.put(0, new NewsFragment());
        mPages.put(1, new NewVersionFragment());
        mPages.put(2, new HeroCommunityFragment());
        mPages.put(3, new VideoFragment());
        mPages.put(4, new MatchFragment());
        mPages.put(5, new ColumnListFragment());
        mAdapter = new HeroPageAdapter(getActivity().getSupportFragmentManager(), mPages);
        mVpMain.setAdapter(mAdapter);
        mVpMain.addOnPageChangeListener(mOnPageChangeListener);
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
                mVpMain.setCurrentItem(0);
                break;
            case R.id.rbtn_new_version:
                mVpMain.setCurrentItem(1);
                break;
            case R.id.rbtn_hero:
                mVpMain.setCurrentItem(2);
                break;
            case R.id.rbtn_video:
                mVpMain.setCurrentItem(3);
                break;
            case R.id.rbtn_match:
                mVpMain.setCurrentItem(4);
                break;
            case R.id.rbtn_column:
                mVpMain.setCurrentItem(5);
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
