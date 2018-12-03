package org.scau.riotgame.home;

import android.Manifest;
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

import com.alibaba.android.arouter.launcher.ARouter;
import com.xyz.basiclib.permission.OpPermissionCallback;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.CommonFragment;
import com.xyz.riotcommon.RouterConstants;

import org.scau.riotgame.R;
import org.scau.riotgame.hero.HeroInfoActivity;
import org.scau.riotgame.home.bean.DiscoveryMenu;
import org.scau.riotgame.search.UserNearbyActivity;
import org.scau.riotgame.search.UserSearchActivity;
import org.scau.riotgame.wallpaper.WallPaperActivity;
import org.scau.riotgame.webview.WebViewActivity;

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

public class DiscoveryFragment extends CommonFragment<DiscoveryContract.View, DiscoveryContract.Presenter> implements DiscoveryContract.View {

    private static final String TAG = "DiscoveryFragment";
    @BindView(R.id.rv_club)
    RecyclerView mRvClub;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.rv_discovery)
    RecyclerView mRvDiscovery;


    private ClubAdapter mAdapter;
    private List<Club.ClubsBean> mClubs;

    private DiscoveryMenuAdapter mDiscoveryMenuAdapter;
    private List<DiscoveryMenu> mMenus;

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        initTopBar();
        initViewClub();
        initMenu();
    }

    private void initMenu() {
        mMenus = new ArrayList<>();
        mRvDiscovery.setLayoutManager(new LinearLayoutManager(getActivity()));
        mDiscoveryMenuAdapter = new DiscoveryMenuAdapter(mMenus, getActivity());
        mRvDiscovery.setAdapter(mDiscoveryMenuAdapter);
        mRvDiscovery.setNestedScrollingEnabled(false);
        mDiscoveryMenuAdapter.setOnItemClickListener(new BasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                DiscoveryMenu discoveryMenu = mMenus.get(position);
                if ("1".equals(discoveryMenu.getIs_web())) {
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", discoveryMenu.getArticle_url());
                    startActivity(intent);
                }
                if ("13121".equals(discoveryMenu.getArticle_id())) {
                    openActivity(WallPaperActivity.class);
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
            checkPermission(Manifest.permission.CAMERA, new OpPermissionCallback() {
                @Override
                public void onGranted(List<String> permissions) {
                    Log.d(TAG, "onGranted: ");
                    ARouter.getInstance().build(RouterConstants.SCAN_MAIN).navigation();
                }

                @Override
                public void onDenied(List<String> permissions) {
                    Log.d(TAG, "onDenied: ");
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.discovery_barcode, menu);
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
        setUserVisibleHint(true);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
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
        mMenus.clear();
        mMenus.addAll(menu);
        mDiscoveryMenuAdapter.notifyDataSetChanged();
    }
}
