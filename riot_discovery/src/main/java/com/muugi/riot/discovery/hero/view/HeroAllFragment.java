package com.muugi.riot.discovery.hero.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.muugi.riot.discovery.hero.presenter.AllHeroPresenter;
import com.muugi.riot.discovery.hero.adapter.HeroAllAdapter;
import com.muugi.riot.discovery.hero.contract.HeroContract;
import com.muugi.riot.discovery.hero.bean.Hero;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshFragment;

import java.util.List;

/**
 * Created by ZP on 2017/7/27.
 */

public class HeroAllFragment extends SimpleRefreshFragment<Hero, HeroContract.View, HeroContract.Presenter> implements HeroContract.View {

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new GridLayoutManager(getActivity(), 2);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getAllHeros();
    }

    @Override
    protected BasicAdapter<Hero> getAdapter() {
        return new HeroAllAdapter(mData, getActivity());
    }

    @Override
    public void showAllHeros(List<Hero> heros) {
        mData.clear();
        mData.addAll(heros);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
        mSmartRefreshLayout.setEnableLoadmore(false);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.getAllHeros();
    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("hero_id", mData.get(position).getId());
        openActivity(HeroDetailActivity.class, bundle);
    }

    @Override
    protected HeroContract.Presenter initPresenter() {
        return new AllHeroPresenter();
    }
}
