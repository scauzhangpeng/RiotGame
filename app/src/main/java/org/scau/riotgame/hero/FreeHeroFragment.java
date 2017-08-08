package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseRecyclerAdapter;
import org.scau.riotgame.base.SmartViewHolder;
import org.scau.riotgame.utils.ImageLoadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ZP on 2017/7/27.
 */

public class FreeHeroFragment extends Fragment implements AdapterView.OnItemClickListener {

    @Bind(R.id.rv_hero_free)
    RecyclerView mRvHeroFree;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private View mView;
    private BaseRecyclerAdapter<Hero> mAdapter;
    private List<Hero> mHeros;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_hero_free, null);
        ButterKnife.bind(this, mView);
        initViewAndEvents();
        return mView;
    }

    private void initViewAndEvents() {
        mRvHeroFree.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvHeroFree.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mHeros = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Hero hero = new Hero();
            hero.setUrl("http://ossweb-img.qq.com/images/lol/web201310/skin/small62000.jpg");
            hero.setName("齐天大圣" + i);
            hero.setNickName("孙悟空" + i);
            hero.setTag("战士");
            hero.setRate(55);
            mHeros.add(hero);
        }
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
                mRefreshLayout.finishRefresh(5000);
            }
        });

        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mRefreshLayout.finishLoadmore(5000);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(position);
    }
}
