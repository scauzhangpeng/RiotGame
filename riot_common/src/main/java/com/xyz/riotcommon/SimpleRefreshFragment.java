package com.xyz.riotcommon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.MvpFragment;
import com.xyz.basiclib.recyclerview.BasicAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZP on 2018/2/8.
 */

public abstract class SimpleRefreshFragment<T, V, P extends BasePresenter<V>> extends MvpFragment<V, P> implements OnRefreshListener, OnLoadmoreListener, BasicAdapter.OnItemClickListener {

    protected RecyclerView mRecyclerView;
    protected SmartRefreshLayout mSmartRefreshLayout;

    protected List<T> mData;
    protected BasicAdapter<T> mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return mView;
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        initRefreshView();
        initRecycleView();
    }

    private void initRefreshView() {
        mSmartRefreshLayout = (SmartRefreshLayout) mView.findViewById(R.id.refreshLayout);
        mSmartRefreshLayout.setOnRefreshListener(this);
        mSmartRefreshLayout.setOnLoadmoreListener(this);
    }

    protected void initRecycleView() {
        mData = new ArrayList<>();
        mAdapter = getAdapter();
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.rv_base);
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    }

    protected abstract BasicAdapter<T> getAdapter();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_base_fresh;
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        if (mData != null && mData.size() != 0) {
            mData.clear();
        }
    }
}
