package org.scau.riotgame.wallpaper;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

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
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_wallpaper;
    }

}
