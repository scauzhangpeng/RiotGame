package org.scau.riotgame.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseFragment;
import org.scau.riotgame.hero.HeroInfoActivity;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;
import org.scau.riotgame.search.UserNearbyActivity;
import org.scau.riotgame.search.UserSearchActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

/**
 * Created by ZP on 2017/7/27.
 * <p>
 * 发现界面
 * </p>
 */

public class DiscoveryFragment extends BaseFragment {

    private static final String TAG = "DiscoveryFragment";

    @Bind(R.id.tv_fan_club)
    TextView mTvFanClub;
    @Bind(R.id.rv_club)
    RecyclerView mRvClub;

    private View mView;
    private ClubAdapter mAdapter;
    private List<Club.ClubsBean> mClubs;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_discovery, null);
        ButterKnife.bind(this, mView);
        initViewClub();
        return mView;
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
            RequestManager.getInstance().getClubInfo("android", 9718, new HttpCallback<Club>() {
                @Override
                public void doOnSuccess(Response<Club> response) {
                    Club club = response.body();
                    List<Club.ClubsBean> clubs = club.getClubs();
                    mClubs.clear();
                    mClubs.addAll(clubs);
                    mAdapter.notifyDataSetChanged();
                }

                @Override
                public void doOnError(Response<Club> response, String statusCode, String message) {
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }

                @Override
                public void doOnFailure(int httpCode, String message) {
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            });
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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
