package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.scau.riotgame.R;
import org.scau.riotgame.base.MultipleTypeSupport;
import org.scau.riotgame.base.RiotGameAdapter;
import org.scau.riotgame.base.RiotGameViewHolder;
import org.scau.riotgame.utils.ImageLoadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ZP on 2017/7/27.
 */

public class AllHeroFragment extends Fragment {

    @Bind(R.id.rv_hero_all)
    RecyclerView mRvHeroAll;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private View mView;
    private List<Hero> mHeros;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_hero_all, null);
        ButterKnife.bind(this, mView);
        initViewsAndEvents();
        return mView;
    }

    private void initViewsAndEvents() {
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
        mRvHeroAll.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRvHeroAll.setAdapter(new RiotGameAdapter<Hero>(mHeros, getActivity(), mMultipleTypeSupport) {

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
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
}
