package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xyz.basiclib.mvp.MvpFragment;

import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.NewsContract;

import java.util.List;

/**
 * Created by ZP on 2017/7/27.
 */

public class NewsFragment extends MvpFragment<NewsContract.View, NewsContract.Presenter> implements NewsContract.View {


    @Override
    public void showNewsList(List<News> news) {

    }

    @Override
    public void showMoreNewsList(int currentPage, List<News> news) {

    }

    @Override
    public void showBannerNewsList(List<News> bannerNews) {

    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected NewsContract.Presenter initPresenter() {
        return null;
    }
}
