package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.CommonFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.ColumnList;
import org.scau.riotgame.home.contract.ColumnContract;
import org.scau.riotgame.home.presenter.ColumnListPresenter;
import org.scau.riotgame.utils.ImageLoadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ZP on 2018/1/24.
 * <p>
 * 专栏
 * </p>
 */

public class ColumnListFragment extends CommonFragment<ColumnContract.View, ColumnContract.Presenter> implements ColumnContract.View, OnRefreshListener, OnLoadmoreListener {


    @Bind(R.id.rv_hero_free)
    RecyclerView mRvHeroFree;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private List<ColumnList> mColumnLists;
    private BasicAdapter<ColumnList> mAdapter;

    @Override
    public void showColumnList(List<ColumnList> news) {
        mColumnLists.clear();
        mColumnLists.addAll(news);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreColumnList(int currentPage, List<ColumnList> news) {
        mColumnLists.addAll(news);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mRvHeroFree.setLayoutManager(new LinearLayoutManager(getActivity()));
        mColumnLists = new ArrayList<>();
        mAdapter = new BasicAdapter<ColumnList>(R.layout.item_columlist_unbook, mColumnLists, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, ColumnList columnList, int position) {
                holder.setText(R.id.tv_col_title, columnList.getCol_title());
                holder.setText(R.id.tv_col_author, columnList.getAuthor());
                holder.setText(R.id.tv_col_book_num, columnList.getBook_num());
                holder.setText(R.id.tv_col_des, columnList.getCol_des());
                holder.setImagePath(R.id.iv_col_logo, new AbstractImageLoader(columnList.getLogo()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadCircleImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                    }
                });
                if (columnList.getCol_from() != null && !TextUtils.isEmpty(columnList.getCol_from())) {
                    holder.setVisibility(R.id.iv_col_video_tag, View.VISIBLE);
                } else {
                    holder.setVisibility(R.id.iv_col_video_tag, View.GONE);
                }
            }
        };
        mRvHeroFree.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_refresh;
    }

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
    public void setUserVisibleHint(boolean isVisibleToUser) {
//        if (isVisibleToUser) {
//            mRefreshLayout.autoRefresh();
//        }
    }
}
