package com.muugi.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.RouterConstants;
import com.xyz.riotcommon.SimpleTopBarActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ZP on 2018/7/18.
 */
@Route(path = RouterConstants.ALBUM_MAIN)
public class AlbumMainActivity extends SimpleTopBarActivity {

    @Bind(R.id.cb_real_size)
    CheckBox mCbRealSize;
    @Bind(R.id.btn_ok)
    Button mBtnOk;

    private static final int TYPE_LIST = 0;
    private static final int TYPE_DETAIL = 1;
    private static int TYPE = TYPE_LIST;

    private AlbumListFragment mAlbumListFragment;
    private AlbumDetailFragment mAlbumDetailFragment;

    private String mCurrentSelectImages;
    private String mCurrentSelectDir;


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
            mAlbumListFragment.setFragmentCallback(new AlbumCallbackContract.AlbumListItemClickListener() {
                @Override
                public void onClick(String dir, String name) {
                    showDetailAlbum(dir, name);
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
            mAlbumDetailFragment.setFragmentCallback(new AlbumCallbackContract.AlbumDetailSelectClickListener() {
                @Override
                public void onClick(String dir, String path, String fileSize) {
                    mCurrentSelectImages = path;
                    mCurrentSelectDir = dir;
                    mCbRealSize.setText(mCbRealSize.getText() + "(" + fileSize + ")");
                }

                @Override
                public void onUnSelected() {
                    mCurrentSelectDir = null;
                    mCurrentSelectImages = null;
                    mCbRealSize.setText("原图");
                }
            });
        }
        mAlbumDetailFragment.setCurrentUri(dir, mCurrentSelectImages, mCurrentSelectDir);
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

    @OnClick(R.id.btn_ok)
    public void confirmSelectPicture() {
        if (!TextUtils.isEmpty(mCurrentSelectDir) && !TextUtils.isEmpty(mCurrentSelectImages)) {
            boolean checked = mCbRealSize.isChecked();
            Intent intent = new Intent();
            intent.putExtra("dir", mCurrentSelectDir);
            intent.putExtra("path", mCurrentSelectImages);
            intent.putExtra("isRealSize", checked);
            Log.d(TAG, "confirmSelectPicture: " + mCurrentSelectDir + "-" + mCurrentSelectImages + "-" + checked);
            setResult(Activity.RESULT_OK, intent);
        } else {
            Log.d(TAG, "confirmSelectPicture: " + "failure");
            setResult(Activity.RESULT_FIRST_USER);
        }

        finish();
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
