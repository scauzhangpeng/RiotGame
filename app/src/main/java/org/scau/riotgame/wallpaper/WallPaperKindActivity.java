package org.scau.riotgame.wallpaper;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.SpacesItemDecoration;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;
import org.scau.riotgame.utils.ScreenUtil;
import org.scau.riotgame.wallpaper.adapter.HotWallPaperAdapter;
import org.scau.riotgame.wallpaper.bean.WallPaperDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ZP on 2018/6/7.
 */

public class WallPaperKindActivity extends SimpleTopBarActivity<WallPaperContract.View, WallPaperContract.Presenter> implements WallPaperContract.View, OnRefreshListener, OnLoadmoreListener, BasicAdapter.OnItemClickListener {


    @BindView(R.id.rv_layout_refresh)
    RecyclerView mRvLayoutRefresh;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private List<WallPaperDetail> mData;
    private HotWallPaperAdapter mAdapter;
    private String mKind;

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        mKind = getIntent().getStringExtra("kind");
        String title = getIntent().getStringExtra("title");
        if (!TextUtils.isDigitsOnly(title)) {
            setTitle(title);
        }
        initRefreshView();
        initRecycleView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRefreshLayout.autoRefresh();
    }

    private void initRefreshView() {
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    protected void initRecycleView() {
        mData = new ArrayList<>();
        mAdapter = new HotWallPaperAdapter(mData, this);
        mRvLayoutRefresh.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
        mRvLayoutRefresh.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        mRvLayoutRefresh.addItemDecoration(new SpacesItemDecoration((int) ScreenUtil.dip2px(this, 10), true));
    }

    @Override
    public void showRefreshWallPaper(List<WallPaperDetail> wallPapersDetail) {
        mData.clear();
        mData.addAll(wallPapersDetail);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreWallPaper(List<WallPaperDetail> wallPapersDetail) {
        mData.addAll(wallPapersDetail);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void setLoadMoreEnable(boolean isEnable) {
        mRefreshLayout.setEnableLoadmore(isEnable);
    }

    @Override
    protected WallPaperContract.Presenter initPresenter() {
        return new WallPaperPresenter("kind", mKind);
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_wallpaper_kind;
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.getRefreshWallPaper();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.getLoadMoreWallPaper();
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
