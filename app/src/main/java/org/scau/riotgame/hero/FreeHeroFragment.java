package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.mvp.MvpFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseRecyclerAdapter;
import org.scau.riotgame.base.SmartViewHolder;
import org.scau.riotgame.utils.ImageLoadUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by ZP on 2017/7/27.
 */

public class FreeHeroFragment extends MvpFragment<HeroContract.FreeView, HeroContract.FreePresenter> implements AdapterView.OnItemClickListener, HeroContract.FreeView {

    @BindView(R.id.rv_hero_free)
    RecyclerView mRvHeroFree;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private BaseRecyclerAdapter<Hero> mAdapter;
    private List<Hero> mHeros;


    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initFreeHeros();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hero_free;
    }

    private void initFreeHeros() {
        mRvHeroFree.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvHeroFree.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mAdapter = new BaseRecyclerAdapter<Hero>(mHeros, R.layout.item_hero, this) {
            @Override
            protected void onBindViewHolder(SmartViewHolder holder, Hero hero, int position) {
                holder.text(R.id.tv_hero_name, hero.getName());
                holder.text(R.id.tv_hero_nickname, hero.getNickName());
                holder.text(R.id.tv_rate, hero.getRate() + "");
                holder.text(R.id.tv_tag, hero.getTag());
                ImageView imageView = (ImageView) holder.findViewById(R.id.iv_header);
                ImageLoadUtil.loadCircleImage(getActivity(), hero.getUrl(), imageView);
            }
        };
        mRvHeroFree.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.getFreeHeros();
            }
        });
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
        mHeros.clear();
        mHeros.addAll(heros);
        mAdapter.notifyDataSetChanged();
    }
}
