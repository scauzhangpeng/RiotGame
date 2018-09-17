package com.muugi.album;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.SpacesItemDecoration;
import com.xyz.basiclib.util.ScreenUtil;
import com.xyz.riotcommon.SimpleRefreshFragment;

import java.io.File;
import java.util.List;

/**
 * Created by ZP on 2018/9/18.
 */

public class AlbumDetailFragment extends SimpleRefreshFragment<File, AlbumContract.DetailView,
        AlbumContract.DetailPresenter> implements AlbumContract.DetailView {

    private static final String TAG = "AlbumDetailFragment";

    private AlbumFragmentCallback mAlbumFragmentCallback;
    private String mUri;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mSmartRefreshLayout.setEnableLoadmore(false);
        getRecyclerView().addItemDecoration(new SpacesItemDecoration(ScreenUtil.dp2px(getActivity().getApplicationContext(), 10)));
        mSmartRefreshLayout.autoRefresh();
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    public void showAlbumPictureUnderFolder(List<File> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected BasicAdapter<File> getAdapter() {
        return new AlbumDetailAdapter(mData, getActivity());
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
        return new AlbumDetailPresenter(getActivity().getApplicationContext());
    }

    @Override
    public void onItemClick(View view, int position) {
        if (mAlbumFragmentCallback != null) {
            mAlbumFragmentCallback.selectPicture(mData.get(position).getParent(), mData.get(position).getAbsolutePath());
        }
    }

    public void setFragmentCallback(AlbumFragmentCallback callback) {
        mAlbumFragmentCallback = callback;
    }

    public void setCurrentUri(String dir) {
        mUri = dir;
    }
}
