package com.muugi.album;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshFragment;

import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Created by ZP on 2018/9/18.
 */

public class AlbumListFragment extends SimpleRefreshFragment<ImageFolder, AlbumContract.View,
        AlbumContract.Presenter> implements AlbumContract.View {

    private AlbumCallbackContract.AlbumListItemClickListener mAlbumCallbackContract;

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mSmartRefreshLayout.setEnableLoadmore(false);
        if (getActivity() != null) {
            getRecyclerView().addItemDecoration(new DividerItemDecoration(getActivity(), VERTICAL));
        }
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    public void showAlbumListData(List<ImageFolder> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    protected BasicAdapter<ImageFolder> getAdapter() {
        return new AlbumAdapter(mData, getActivity());
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
    protected AlbumContract.Presenter initPresenter() {
        if (getActivity() != null) {
            return new AlbumPresenter(getActivity().getApplicationContext());
        }
        return null;
    }

    @Override
    public void onItemClick(View view, int position) {
        if (mAlbumCallbackContract != null) {
            mAlbumCallbackContract.onClick(mData.get(position).getDir(), mData.get(position).getName());
        }
    }


    public void setFragmentCallback(AlbumCallbackContract.AlbumListItemClickListener callback) {
        mAlbumCallbackContract = callback;
    }

}
