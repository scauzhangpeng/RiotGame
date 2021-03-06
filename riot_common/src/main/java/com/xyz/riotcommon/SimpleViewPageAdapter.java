package com.xyz.riotcommon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;

/**
 * Created by ZP on 2017/8/5.
 */

public class SimpleViewPageAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> mFragments;

    public SimpleViewPageAdapter(FragmentManager fm, SparseArray<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
