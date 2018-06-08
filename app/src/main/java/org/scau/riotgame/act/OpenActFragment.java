package org.scau.riotgame.act;

import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshFragment;

import org.scau.riotgame.act.bean.ActDetail;

import java.util.List;

/**
 * Created by ZP on 2018/6/8.
 */

public class OpenActFragment extends SimpleRefreshFragment<ActDetail, ActContract.View, ActContract.Presenter> implements ActContract.View {
    @Override
    protected BasicAdapter<ActDetail> getAdapter() {
        return new ActAdapter(mData, getActivity());
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.getRefresh();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.getLoadMore();
    }

    @Override
    protected ActContract.Presenter initPresenter() {
        return new ActPresenter("open");
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void showRefreshActDetailList(List<ActDetail> actDetails) {
        mData.clear();
        mData.addAll(actDetails);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showLoadMoreActDetailList(List<ActDetail> actDetails) {
        mData.addAll(actDetails);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishLoadmore();
    }

    @Override
    public void setLoadMoreEnable(boolean isEnable) {
        mSmartRefreshLayout.setEnableLoadmore(isEnable);
    }
}
