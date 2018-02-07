package org.scau.riotgame.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xyz.basiclib.mvp.MvpFragment;
import com.xyz.basiclib.recyclerview.BasicAdapter;

import org.scau.riotgame.R;
import org.scau.riotgame.hero.HeroInfoActivity;
import org.scau.riotgame.home.bean.DiscoveryMenu;
import org.scau.riotgame.search.UserNearbyActivity;
import org.scau.riotgame.search.UserSearchActivity;
import org.scau.riotgame.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ZP on 2017/7/27.
 * <p>
 * 发现界面
 * </p>
 */

public class DiscoveryFragment extends MvpFragment<DiscoveryContract.View, DiscoveryContract.Presenter> implements DiscoveryContract.View {

    private static final String TAG = "DiscoveryFragment";
    @Bind(R.id.rv_club)
    RecyclerView mRvClub;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.toolbar_title)
    TextView mToolbarTitle;
    @Bind(R.id.rv_discovery)
    RecyclerView mRvDiscovery;


    private ClubAdapter mAdapter;
    private List<Club.ClubsBean> mClubs;

    //列表菜单
    private List<DiscoveryMenu> mDiscoveryIndices;
    private DiscoveryMenuAdapter mDiscoveryMenuAdapter;

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        initTopBar();
        initDiscoveryRv();
        initViewClub();
    }

    private void initDiscoveryRv() {
        mDiscoveryIndices = new ArrayList<>();
        mDiscoveryMenuAdapter = new DiscoveryMenuAdapter(mDiscoveryIndices, getActivity());
        mRvDiscovery.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRvDiscovery.setAdapter(mDiscoveryMenuAdapter);
        mRvDiscovery.setNestedScrollingEnabled(false);
        mDiscoveryMenuAdapter.setOnItemClickListener(new BasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                DiscoveryMenu discoveryMenu = mDiscoveryIndices.get(position);
                if ("1".equals(discoveryMenu.getIs_web())) {
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", discoveryMenu.getArticle_url());
                    startActivity(intent);
                }
            }
        });
    }

    private void initTopBar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        mToolbar.setTitle("");
        mToolbar.setBackgroundColor(Color.TRANSPARENT);
        activity.setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
        mToolbar.setNavigationIcon(null);
        mToolbarTitle.setText("发现");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_bar_code) {
            showToastLong("scan");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.discovery_barcode, menu);
//        super.onCreateOptionsMenu(menu, inflater);
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
        Log.d(TAG, "setUserVisibleHint: " + isVisibleToUser);
        if (isVisibleToUser) {
            mPresenter.getClubs();
            mPresenter.getDiscoveryMenu();
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

    @Override
    public void showDiscoveryMenu(List<DiscoveryMenu> menu) {
        mDiscoveryIndices.clear();
        mDiscoveryIndices.addAll(menu);
        mDiscoveryMenuAdapter.notifyDataSetChanged();
    }
}
