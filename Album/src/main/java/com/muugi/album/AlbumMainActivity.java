package com.muugi.album;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshActivity;

import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Created by ZP on 2018/7/18.
 */

public class AlbumMainActivity extends SimpleRefreshActivity<ImageFolder, AlbumContract.View, AlbumContract.Presenter>
        implements AlbumContract.View {

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        mSmartRefreshLayout.setEnableLoadmore(false);
        getRecyclerView().addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    protected BasicAdapter<ImageFolder> getAdapter() {
        return new AlbumAdapter(mData, this);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.getAlbumPictureList();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("dir", mData.get(position).getDir());
        bundle.putString("name", mData.get(position).getName());
        openActivity(AlbumDetailActivity.class, bundle);
    }

    @Override
    public void showAlbumListData(List<ImageFolder> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    protected AlbumContract.Presenter initPresenter() {
        return new AlbumPresenter(getApplicationContext());
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_photo_album;
    }
}
