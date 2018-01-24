package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xyz.basiclib.mvp.MvpFragment;

import org.scau.riotgame.home.bean.HotAuthor;
import org.scau.riotgame.home.bean.HotEnter;
import org.scau.riotgame.home.bean.HotMatch;
import org.scau.riotgame.home.bean.HotWpv;
import org.scau.riotgame.home.contract.VideoContract;

import java.util.List;


/**
 * Created by ZP on 2018/1/24.
 */

public class VideoFragment extends MvpFragment<VideoContract.View, VideoContract.Presenter> implements VideoContract.View {
    @Override
    public void showHotAuthorList(List<HotAuthor> hotAuthors) {

    }

    @Override
    public void showHotWpvList(List<HotWpv> hotWpvs) {

    }

    @Override
    public void showHotEnterList(List<HotEnter> hotEnters) {

    }

    @Override
    public void showHotMatchList(List<HotMatch> hotMatches) {

    }

    @Override
    public void showHotMatchTop(HotMatch hotMatch) {

    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected VideoContract.Presenter initPresenter() {
        return null;
    }
}
