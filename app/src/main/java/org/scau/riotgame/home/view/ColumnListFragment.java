package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.SimpleRefreshFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.home.ColumnListAdapter;
import org.scau.riotgame.home.SpecialColumnListBean;
import org.scau.riotgame.home.contract.ColumnContract;
import org.scau.riotgame.home.presenter.ColumnListPresenter;

import java.util.List;

/**
 * Created by ZP on 2018/1/24.
 * <p>
 * 专栏
 * </p>
 */

public class ColumnListFragment extends SimpleRefreshFragment<SpecialColumnListBean, ColumnContract.View, ColumnContract.Presenter> implements ColumnContract.View, OnRefreshListener, OnLoadmoreListener {


    @Override
    public void showColumnList(List<SpecialColumnListBean> news) {
        mData.clear();
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreColumnList(int currentPage, List<SpecialColumnListBean> news) {
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishLoadmore();
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
    }

    @Override
    protected BasicAdapter<SpecialColumnListBean> getAdapter() {
        return new ColumnListAdapter(mData, getActivity(), mMultipleTypeSupport);
    }

    private MultipleTypeSupport<SpecialColumnListBean> mMultipleTypeSupport = new MultipleTypeSupport<SpecialColumnListBean>() {
        @Override
        public int getLayoutId(SpecialColumnListBean specialColumnListBean, int position) {
            int type = specialColumnListBean.getType();
            if (type == 0) {
                return R.layout.item_columlist_unbook;
            } else if (type == 1) {
                return R.layout.item_columlist_book;
            } else if (type == 2) {
                return R.layout.item_columlist_recommend;
            } else if (type == 3 || type == 4 || type == 5) {
                return R.layout.item_columnlist_desc;
            } else {
                return R.layout.item_columlist_unbook;
            }
        }
    };

    @Override
    protected ColumnContract.Presenter initPresenter() {
        return new ColumnListPresenter();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.refreshNews();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNews();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
