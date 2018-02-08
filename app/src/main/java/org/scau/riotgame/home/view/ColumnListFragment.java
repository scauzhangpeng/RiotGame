package org.scau.riotgame.home.view;

import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshFragment;

import org.scau.riotgame.home.ColumnListAdapter;
import org.scau.riotgame.home.bean.ColumnList;
import org.scau.riotgame.home.contract.ColumnContract;
import org.scau.riotgame.home.presenter.ColumnListPresenter;

import java.util.List;

/**
 * Created by ZP on 2018/1/24.
 * <p>
 * 专栏
 * </p>
 */

public class ColumnListFragment extends SimpleRefreshFragment<ColumnList, ColumnContract.View, ColumnContract.Presenter> implements ColumnContract.View {
    @Override
    public void showColumnList(List<ColumnList> news) {
        mData.clear();
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreColumnList(int currentPage, List<ColumnList> news) {
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishLoadmore();
    }

    @Override
    protected BasicAdapter<ColumnList> getAdapter() {
        return new ColumnListAdapter(mData, getActivity());
    }

    @Override
    protected ColumnContract.Presenter initPresenter() {
        return new ColumnListPresenter();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.refreshNews();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNews();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
