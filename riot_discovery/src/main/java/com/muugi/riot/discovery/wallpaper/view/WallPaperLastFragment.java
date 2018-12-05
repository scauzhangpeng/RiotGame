package com.muugi.riot.discovery.wallpaper.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muugi.riot.discovery.wallpaper.WallPaperContract;
import com.muugi.riot.discovery.wallpaper.WallPaperPresenter;
import com.muugi.riot.discovery.wallpaper.adapter.HotWallPaperAdapter;
import com.muugi.riot.discovery.wallpaper.bean.WallPaperDetail;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.SpacesItemDecoration;
import com.xyz.basiclib.util.ScreenUtil;
import com.xyz.riotcommon.SimpleRefreshFragment;

import java.util.List;

/**
 * Created by ZP on 2018/1/29.
 */

public class WallPaperLastFragment extends SimpleRefreshFragment<WallPaperDetail, WallPaperContract.View, WallPaperContract.Presenter> implements WallPaperContract.View {


    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        getRecyclerView().addItemDecoration(new SpacesItemDecoration((int) ScreenUtil.dp2px(getActivity(), 10), true));
    }

    @Override
    protected BasicAdapter<WallPaperDetail> getAdapter() {
        return new HotWallPaperAdapter(mData, getActivity());
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.getRefreshWallPaper();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.getLoadMoreWallPaper();
    }

    @Override
    protected WallPaperContract.Presenter initPresenter() {
        return new WallPaperPresenter("new");
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
    }

    @Override
    public void showRefreshWallPaper(List<WallPaperDetail> wallPapersDetail) {
        mData.clear();
        mData.addAll(wallPapersDetail);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreWallPaper(List<WallPaperDetail> wallPapersDetail) {
        mData.addAll(wallPapersDetail);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishLoadmore();
    }

    @Override
    public void setLoadMoreEnable(boolean isEnable) {
        mSmartRefreshLayout.setEnableLoadmore(isEnable);
    }

    @Override
    protected void requestData() {
        super.requestData();
        mSmartRefreshLayout.autoRefresh();
    }
}
