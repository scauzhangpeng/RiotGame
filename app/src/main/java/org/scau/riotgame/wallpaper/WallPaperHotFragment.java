package org.scau.riotgame.wallpaper;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshFragment;

import org.scau.riotgame.utils.ScreenUtil;
import org.scau.riotgame.wallpaper.adapter.HotWallPaperAdapter;
import org.scau.riotgame.wallpaper.bean.WallPaperDetail;

import java.util.List;

/**
 * Created by ZP on 2018/1/29.
 */

public class WallPaperHotFragment extends SimpleRefreshFragment<WallPaperDetail, WallPaperContract.View, WallPaperContract.Presenter> implements WallPaperContract.View {


    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        getRecyclerView().addItemDecoration(new SpacesItemDecoration((int) ScreenUtil.dip2px(getActivity(), 10)));
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
        return new WallPaperPresenter("hot");
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
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
}
