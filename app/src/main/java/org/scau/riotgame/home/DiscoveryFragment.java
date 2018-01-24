package org.scau.riotgame.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyz.basiclib.mvp.MvpFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.hero.HeroInfoActivity;
import org.scau.riotgame.search.UserNearbyActivity;
import org.scau.riotgame.search.UserSearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ZP on 2017/7/27.
 * <p>
 * 发现界面
 * </p>
 */

public class DiscoveryFragment extends MvpFragment<DiscoveryContract.View, DiscoveryContract.Presenter> implements DiscoveryContract.View {

    private static final String TAG = "DiscoveryFragment";
    @BindView(R.id.rv_club)
    RecyclerView mRvClub;


    private View mView;
    private ClubAdapter mAdapter;
    private List<Club.ClubsBean> mClubs;


    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initViewClub();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }

    private void initViewClub() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvClub.setLayoutManager(linearLayoutManager);
        mClubs = new ArrayList<>();
        mAdapter = new ClubAdapter(mClubs, getActivity());
        mRvClub.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
        setUserVisibleHint(true);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.d(TAG, "setUserVisibleHint: ");
        if (isVisibleToUser) {
            mPresenter.getClubs();
        }
    }

    @OnClick(R.id.tv_hero_info)
    public void openHeroInfo() {
        openActivity(HeroInfoActivity.class);
    }

    @OnClick(R.id.tv_user_search)
    public void openUserSearch() {
        openActivity(UserSearchActivity.class);
    }

    @OnClick(R.id.tv_nearby)
    public void openNearby() {
        openActivity(UserNearbyActivity.class);
    }

    @Override
    protected DiscoveryContract.Presenter initPresenter() {
        return new DiscoveryPresenter();
    }

    @Override
    public void showClubs(List<Club.ClubsBean> clubs) {
        mClubs.clear();
        mClubs.addAll(clubs);
        mAdapter.notifyDataSetChanged();
    }
}
