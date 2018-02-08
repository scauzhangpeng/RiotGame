package org.scau.riotgame.hero;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    protected HeroContract.Presenter initPresenter() {
        return new AllHeroPresenter();
    }
}