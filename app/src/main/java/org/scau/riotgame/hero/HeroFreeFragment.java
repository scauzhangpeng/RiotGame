package org.scau.riotgame.hero;

import android.view.View;
import android.widget.AdapterView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshFragment;

import java.util.List;

/**
 * Created by ZP on 2017/7/27.
 */

public class HeroFreeFragment extends SimpleRefreshFragment<Hero, HeroContract.FreeView, HeroContract.FreePresenter> implements AdapterView.OnItemClickListener, HeroContract.FreeView {

    @Override
    protected BasicAdapter<Hero> getAdapter() {
        return new HeroFreeAdapter(mData, getActivity());
    }

    @Override
    protected HeroContract.FreePresenter initPresenter() {
        return new FreeHeroPresenter();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(position);
    }

    @Override
    public void showFreeHeros(List<Hero> heros) {
        mData.clear();
        mData.addAll(heros);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }


    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.getFreeHeros();
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
