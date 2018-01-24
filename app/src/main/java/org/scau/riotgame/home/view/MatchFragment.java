package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xyz.basiclib.mvp.MvpFragment;

import org.scau.riotgame.home.bean.Feature;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.MatchContract;

import java.util.List;

/**
 * Created by ZP on 2018/1/24.
 */

public class MatchFragment extends MvpFragment<MatchContract.View, MatchContract.Presenter> implements MatchContract.View {
    @Override
    public void showMatchHeaderMenu(List<Feature> features) {

    }

    @Override
    public void showMatchHeaderGallery(List<Feature> features) {

    }

    @Override
    public void showRefreshMatchNews(List<News> news) {

    }

    @Override
    public void showMoreMatchNews(List<News> news) {

    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected MatchContract.Presenter initPresenter() {
        return null;
    }
}
