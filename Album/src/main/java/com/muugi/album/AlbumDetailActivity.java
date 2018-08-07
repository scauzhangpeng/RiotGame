package com.muugi.album;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.SpacesItemDecoration;
import com.xyz.basiclib.util.ScreenUtil;
import com.xyz.riotcommon.SimpleRefreshActivity;

import java.io.File;
import java.util.List;

/**
 * Created by ZP on 2018/7/18.
 */

public class AlbumDetailActivity extends SimpleRefreshActivity<File, AlbumContract.DetailView, AlbumContract.DetailPresenter> implements AlbumContract.DetailView {

    private String mUri;

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        mSmartRefreshLayout.setEnableLoadmore(false);
        getRecyclerView().addItemDecoration(new SpacesItemDecoration(ScreenUtil.dp2px(this, 10)));
        mUri = getIntent().getStringExtra("dir");
        String title = getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected BasicAdapter<File> getAdapter() {
        return new AlbumDetailAdapter(mData, this);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.getAlbumPictureUnderFolder(mUri);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }

    @Override
    protected AlbumContract.DetailPresenter initPresenter() {
        return new AlbumDetailPresenter(getApplicationContext());
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void showAlbumPictureUnderFolder(List<File> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_photo_album;
    }
}
