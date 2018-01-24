package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xyz.basiclib.mvp.MvpFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.base.MultipleTypeSupport;
import org.scau.riotgame.base.RiotGameAdapter;
import org.scau.riotgame.base.RiotGameViewHolder;
import org.scau.riotgame.utils.ImageLoadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by ZP on 2017/7/27.
 */

public class AllHeroFragment extends MvpFragment<HeroContract.View, HeroContract.Presenter> implements HeroContract.View {

    @BindView(R.id.rv_hero_all)
    RecyclerView mRvHeroAll;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private List<Hero> mHeros;
    private RiotGameAdapter<Hero> mAdapter;

    @Override
    protected HeroContract.Presenter initPresenter() {
        return new AllHeroPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getAllHeros();
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mHeros = new ArrayList<>();
        mRvHeroAll.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mAdapter = new RiotGameAdapter<Hero>(mHeros, getActivity(), mMultipleTypeSupport) {

            @Override
            protected void bindData(RiotGameViewHolder holder, Hero hero, int position) {
                if (position != 0) {
                    holder.setText(R.id.tv_hero_name, hero.getName())
                            .setImagePath(R.id.iv_header, new RiotGameViewHolder.ImageLoader(hero.getUrl()) {
                                @Override
                                public void loadImage(ImageView imageView, String path) {
                                    ImageLoadUtil.loadCircleImage(getContext(), path, imageView);
                                }
                            })
                            .setText(R.id.tv_hero_nickname, hero.getNickName());
                }
            }
        };
        mRvHeroAll.setAdapter(mAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hero_all;
    }

    private MultipleTypeSupport<Hero> mMultipleTypeSupport = new MultipleTypeSupport<Hero>() {
        @Override
        public int getLayoutId(Hero hero, int position) {
            if (position == 0) {
                return R.layout.item_club;
            } else {
                return R.layout.item_hero;
            }
        }
    };

    @Override
    public void showAllHeros(List<Hero> heros) {
        mHeros.clear();
        mHeros.addAll(heros);
        mAdapter.notifyDataSetChanged();
    }
}
