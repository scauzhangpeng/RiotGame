package com.xyz.riotcommon;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.recyclerview.BasicAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZP on 2018/7/18.
 */

public abstract class SimpleRefreshActivity<T, V, P extends BasePresenter<V>> extends SimpleTopBarActivity<V, P> implements OnRefreshListener, OnLoadmoreListener, BasicAdapter.OnItemClickListener {

    protected RecyclerView mRecyclerView;
    protected SmartRefreshLayout mSmartRefreshLayout;

    protected List<T> mData;
    protected BasicAdapter<T> mAdapter;


    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        initRefreshView();
        initRecycleView();
    }

    private void initRefreshView() {
        mSmartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.base_smart_refresh);
        mSmartRefreshLayout.setOnRefreshListener(this);
        mSmartRefreshLayout.setOnLoadmoreListener(this);
    }

    protected void initRecycleView() {
        mData = new ArrayList<>();
        mAdapter = getAdapter();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_base);
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.setAdapter(mAdapter);
        if (mAdapter != null) {
            mAdapter.setOnItemClickListener(this);
        }
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }

    protected abstract BasicAdapter<T> getAdapter();

    @Override
    protected int getTopBarContentId() {
        return R.layout.base_refresh;
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        if (mData != null && mData.size() != 0) {
            mData.clear();
        }
    }

    protected RecyclerView getRecyclerView() {
        return mRecyclerView;
    }
}
