package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xyz.basiclib.mvp.MvpFragment;

import org.scau.riotgame.home.bean.Card;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.HeroCommunityContract;

import java.util.List;

/**
 * Created by ZP on 2018/1/24.
 */

public class HeroCommunityFragment extends MvpFragment<HeroCommunityContract.View, HeroCommunityContract.Presenter> implements HeroCommunityContract.View {
    @Override
    public void showNewsList(List<News> news) {

    }

    @Override
    public void showMoreNewsList(int currentPage, List<News> news) {

    }

    @Override
    public void showBattleVideo(List<Card> battleVideoCard) {

    }

    @Override
    public void showRecentHero(List<Card> recentHero) {

    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected HeroCommunityContract.Presenter initPresenter() {
        return null;
    }
}
