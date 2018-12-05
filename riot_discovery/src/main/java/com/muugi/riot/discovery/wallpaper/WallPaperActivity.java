package com.muugi.riot.discovery.wallpaper;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.muugi.riot.discovery.R;
import com.muugi.riot.discovery.R2;
import com.muugi.riot.discovery.hero.adapter.HeroPageAdapter;
import com.muugi.riot.discovery.wallpaper.view.WallPaperCollectionFragment;
import com.muugi.riot.discovery.wallpaper.view.WallPaperHotFragment;
import com.muugi.riot.discovery.wallpaper.view.WallPaperLastFragment;
import com.muugi.riot.discovery.wallpaper.view.WallPaperTypeFragment;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import butterknife.BindView;

/**
 * Created by kevin on 2018/1/29.
 */

public class WallPaperActivity extends SimpleTopBarActivity {


    @BindView(R2.id.rbtn_wallpaper_last)
    RadioButton mRbtnWallpaperLast;
    @BindView(R2.id.rbtn_wallpaper_hot)
    RadioButton mRbtnWallpaperHot;
    @BindView(R2.id.rbtn_wallpaper_type)
    RadioButton mRbtnWallpaperType;
    @BindView(R2.id.rbtn_wallpaper_collection)
    RadioButton mRbtnWallpaperCollection;
    @BindView(R2.id.rg_wallpaper)
    RadioGroup mRgWallpaper;
    @BindView(R2.id.vp_wallpaper)
    ViewPager mVpWallpaper;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        mVpWallpaper.addOnPageChangeListener(mOnPageChangeListener);
        mRgWallpaper.setOnCheckedChangeListener(mOnCheckedChangeListener);

        SparseArray<Fragment> pages = new SparseArray<>();
        pages.put(0, new WallPaperLastFragment());
        pages.put(1, new WallPaperHotFragment());
        pages.put(2, new WallPaperTypeFragment());
        pages.put(3, new WallPaperCollectionFragment());
        HeroPageAdapter adapter = new HeroPageAdapter(getSupportFragmentManager(), pages);
        mVpWallpaper.setAdapter(adapter);

    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mRbtnWallpaperLast.setChecked(true);
                    break;
                case 1:
                    mRbtnWallpaperHot.setChecked(true);
                    break;
                case 2:
                    mRbtnWallpaperType.setChecked(true);
                    break;
                case 3:
                    mRbtnWallpaperCollection.setChecked(true);
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
            if (checkedId == R.id.rbtn_wallpaper_last) {
                mVpWallpaper.setCurrentItem(0);
            }
            if (checkedId == R.id.rbtn_wallpaper_hot) {
                mVpWallpaper.setCurrentItem(1);
            }
            if (checkedId == R.id.rbtn_wallpaper_type) {
                mVpWallpaper.setCurrentItem(2);
            }
            if (checkedId == R.id.rbtn_wallpaper_collection) {
                mVpWallpaper.setCurrentItem(3);
            }
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVpWallpaper.removeOnPageChangeListener(mOnPageChangeListener);
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_wallpaper;
    }

}
