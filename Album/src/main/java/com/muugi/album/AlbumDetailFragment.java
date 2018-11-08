package com.muugi.album;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.SpacesItemDecoration;
import com.xyz.basiclib.util.ScreenUtil;
import com.xyz.riotcommon.SimpleRefreshFragment;

import java.util.List;

/**
 * Created by ZP on 2018/9/18.
 */

public class AlbumDetailFragment extends SimpleRefreshFragment<WrapperFile, AlbumContract.DetailView,
        AlbumContract.DetailPresenter> implements AlbumContract.DetailView {

    private static final String TAG = "AlbumDetailFragment";

    private AlbumCallbackContract.AlbumDetailSelectClickListener mAlbumCallbackContract;
    private String mUri;
    private String mCurrentSelectImage;
    private String mCurrentSelectDir;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mSmartRefreshLayout.setEnableLoadmore(false);
        getRecyclerView().addItemDecoration(
                new SpacesItemDecoration(
                        ScreenUtil.dp2px(getActivity().getApplicationContext(), 10),
                        true));
        mSmartRefreshLayout.autoRefresh();
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    public void showAlbumPictureUnderFolder(List<WrapperFile> data) {
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
    protected BasicAdapter<WrapperFile> getAdapter() {
        return new AlbumDetailAdapter(mData, getActivity());
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.getAlbumPictureUnderFolder(mUri, mCurrentSelectImage, mCurrentSelectDir);
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
        if (mAlbumCallbackContract != null) {
            WrapperFile wrapperFile = mData.get(position);
            boolean selected = wrapperFile.isSelected();
            if (selected) {
                wrapperFile.setSelected(false);
                mCurrentSelectImage = null;
                mCurrentSelectDir = null;
                mAdapter.notifyDataSetChanged();
                mAlbumCallbackContract.onUnSelected();
            } else {
                if (TextUtils.isEmpty(mCurrentSelectDir) || TextUtils.isEmpty(mCurrentSelectImage)) {
                    wrapperFile.setSelected(true);
                    mAdapter.notifyDataSetChanged();
                    mCurrentSelectImage = wrapperFile.getAbsolutePath();
                    mCurrentSelectDir = wrapperFile.getParent();
                    mAlbumCallbackContract.onClick(wrapperFile.getParent(), wrapperFile.getAbsolutePath(),
                            android.text.format.Formatter.formatFileSize(getContext(), wrapperFile.getFile().length()));
                } else {
                    Toast.makeText(getActivity(), "只能选取一张", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void setFragmentCallback(AlbumCallbackContract.AlbumDetailSelectClickListener callback) {
        mAlbumCallbackContract = callback;
    }

    public void setCurrentUri(String dir, String currentSelectImage, String currentSelectDir) {
        mUri = dir;
        mCurrentSelectImage = currentSelectImage;
        mCurrentSelectDir = currentSelectDir;
    }
}
