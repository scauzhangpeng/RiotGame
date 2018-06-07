package org.scau.riotgame.wallpaper;

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

import butterknife.Bind;

/**
 * Created by kevin on 2018/1/29.
 */

public class WallPaperActivity extends SimpleTopBarActivity {


    @Bind(R.id.rbtn_wallpaper_last)
    RadioButton mRbtnWallpaperLast;
    @Bind(R.id.rbtn_wallpaper_hot)
    RadioButton mRbtnWallpaperHot;
    @Bind(R.id.rbtn_wallpaper_type)
    RadioButton mRbtnWallpaperType;
    @Bind(R.id.rbtn_wallpaper_collection)
    RadioButton mRbtnWallpaperCollection;
    @Bind(R.id.rg_wallpaper)
    RadioGroup mRgWallpaper;
    @Bind(R.id.vp_wallpaper)
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

        mVpWallpaper.setOffscreenPageLimit(3);
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
            switch (checkedId) {
                case R.id.rbtn_wallpaper_last:
                    mVpWallpaper.setCurrentItem(0);
                    break;
                case R.id.rbtn_wallpaper_hot:
                    mVpWallpaper.setCurrentItem(1);
                    break;
                case R.id.rbtn_wallpaper_type:
                    mVpWallpaper.setCurrentItem(2);
                    break;
                case R.id.rbtn_wallpaper_collection:
                    mVpWallpaper.setCurrentItem(3);
                    break;
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
