package com.muugi.album;

import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshActivity;

/**
 * Created by ZP on 2018/7/18.
 */

public class AlbumDetailActivity extends SimpleRefreshActivity<String, AlbumContract.View, AlbumContract.Presenter> {
    @Override
    protected BasicAdapter<String> getAdapter() {
        return null;
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }

    @Override
    protected AlbumContract.Presenter initPresenter() {
        return null;
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
