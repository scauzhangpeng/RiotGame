package com.muugi.riot.news.view;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muugi.riot.news.R;
import com.muugi.riot.news.adapter.ColumnListAdapter;
import com.muugi.riot.news.bean.SpecialColumnListBean;
import com.muugi.riot.news.contract.ColumnContract;
import com.muugi.riot.news.presenter.ColumnListPresenter;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.RouterConstants;

/**
 * Created by ZP on 2018/1/24.
 * <p>
 * 专栏
 * </p>
 */
@Route(path = RouterConstants.NEWS_COLUMN_LIST)
public class ColumnListFragment extends BaseNewsFragment<SpecialColumnListBean, ColumnContract.View, ColumnContract.Presenter> implements ColumnContract.View, OnRefreshListener, OnLoadmoreListener {

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
        return new ColumnListPresenter("");
    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("title", mData.get(position).getColumnList().getCol_title());
        bundle.putString("author", mData.get(position).getColumnList().getAuthor());
        bundle.putString("desc", mData.get(position).getColumnList().getCol_des());
        bundle.putString("id", mData.get(position).getColumnList().getCol_id());
        bundle.putString("logo", mData.get(position).getColumnList().getLogo());
        bundle.putString("isBook", mData.get(position).getColumnList().getIs_book());
        if (mAdapter instanceof ColumnListAdapter) {
            bundle.putBoolean("isVideo", ((ColumnListAdapter) mAdapter).isVideoColumnList(position));
        }
        openActivity(ColumnListDetailActivity.class, bundle);
    }
}
