package org.scau.riotgame.wallpaper;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshFragment;

import org.scau.riotgame.utils.ScreenUtil;
import org.scau.riotgame.wallpaper.adapter.TypeWallPaperAdapter;
import org.scau.riotgame.wallpaper.bean.WallPaperDetail;

import java.util.List;

/**
 * Created by ZP on 2018/1/29.
 */

public class WallPaperTypeFragment extends SimpleRefreshFragment<WallPaperDetail, WallPaperContract.View, WallPaperContract.Presenter> implements WallPaperContract.View {

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        getRecyclerView().addItemDecoration(new SpacesItemDecoration((int) ScreenUtil.dip2px(getActivity(), 10)));
    }

    @Override
    protected BasicAdapter<WallPaperDetail> getAdapter() {
        return new TypeWallPaperAdapter(mData, getActivity());
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
        return new WallPaperPresenter("type");
    }

    @Override
    public void onItemClick(View view, int position) {
        WallPaperDetail wallPaperDetail = mData.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("kind", wallPaperDetail.getId());
        bundle.putString("title", wallPaperDetail.getName());
        openActivity(WallPaperKindActivity.class, bundle);
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(getActivity(), 3, LinearLayoutManager.VERTICAL, false);
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
