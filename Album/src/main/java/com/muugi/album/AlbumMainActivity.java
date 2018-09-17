package com.muugi.album;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.RouterConstants;
import com.xyz.riotcommon.SimpleTopBarActivity;

/**
 * Created by ZP on 2018/7/18.
 */
@Route(path = RouterConstants.ALBUM_MAIN)
public class AlbumMainActivity extends SimpleTopBarActivity {

    private static final int TYPE_LIST = 0;
    private static final int TYPE_DETAIL = 1;
    private static int TYPE = TYPE_LIST;

    private AlbumListFragment mAlbumListFragment;
    private AlbumDetailFragment mAlbumDetailFragment;


    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        showListAlbum();
        setBackIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchListOrFinish();
            }
        });
    }

    private void switchListOrFinish() {
        if (TYPE == TYPE_DETAIL) {
            showListAlbum();
        } else {
            finish();
        }
    }

    private void showListAlbum() {
        TYPE = TYPE_LIST;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideTransaction(transaction);

        if (mAlbumListFragment == null) {
            mAlbumListFragment = new AlbumListFragment();
            transaction.add(R.id.fl_album_content, mAlbumListFragment);
            mAlbumListFragment.setFragmentCallback(new AlbumFragmentCallback() {
                @Override
                public void openAlbumDetailFragment(String dir, String name) {
                    showDetailAlbum(dir, name);
                }

                @Override
                public void selectPicture(String dir, String path) {

                }
            });
        }
        transaction.show(mAlbumListFragment);
        transaction.commit();
    }

    private void showDetailAlbum(String dir, String name) {
        TYPE = TYPE_DETAIL;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideTransaction(transaction);

        if (mAlbumDetailFragment == null) {
            mAlbumDetailFragment = new AlbumDetailFragment();
            transaction.add(R.id.fl_album_content, mAlbumDetailFragment);
            mAlbumDetailFragment.setFragmentCallback(new AlbumFragmentCallback() {
                @Override
                public void openAlbumDetailFragment(String dir, String name) {

                }

                @Override
                public void selectPicture(String dir, String path) {
                    Log.d(TAG, "selectPicture: " + path);
                }
            });
        }
        mAlbumDetailFragment.setCurrentUri(dir);
        transaction.attach(mAlbumDetailFragment);
        setTitle(name);
        transaction.commit();
    }

    private void hideTransaction(FragmentTransaction transaction) {
        if (mAlbumListFragment != null) {
            transaction.hide(mAlbumListFragment);
        }
        if (mAlbumDetailFragment != null) {
            transaction.detach(mAlbumDetailFragment);
        }
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_photo_album;
    }

    @Override
    public void onBackPressed() {
        switchListOrFinish();
    }
}
