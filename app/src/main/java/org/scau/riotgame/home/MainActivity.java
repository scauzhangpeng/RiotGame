package org.scau.riotgame.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseActivity;
import org.scau.riotgame.favorite.FavoriteActivity;
import org.scau.riotgame.mall.UserOrderActivity;
import org.scau.riotgame.setting.SettingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.tabcontent)
    FrameLayout mTabcontent;
    @BindView(R.id.rbtn_news)
    RadioButton mRbtnNews;
    @BindView(R.id.rbtn_friends)
    RadioButton mRbtnFriends;
    @BindView(R.id.rbtn_mall)
    RadioButton mRbtnMall;
    @BindView(R.id.rbtn_discovery)
    RadioButton mRbtnDiscovery;
    @BindView(R.id.rbtn_me)
    RadioButton mRbtnMe;
    @BindView(R.id.rg_main)
    RadioGroup mRgMain;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.ll_main_content)
    LinearLayout mLlMainContent;
    @BindView(R.id.nav_view)
    LinearLayout mNavView;

    private Fragment mNewsFragment;
    private Fragment mFriendsFragment;
    private Fragment mMallFragment;
    private Fragment mDiscoveryFragment;
    private Fragment mMeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewsAndEvent();
    }

    private void initViewsAndEvent() {
        mRgMain.setOnCheckedChangeListener(this);
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                mLlMainContent.layout(mNavView.getRight(), 0,
                        mNavView.getRight() + display.getWidth(), display.getHeight());
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        SetSelect(0);
    }

    private void SetSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideTransaction(transaction);
        switch (i) {
            case 0:
                if (mNewsFragment == null) {
                    mNewsFragment = new NewsFragment();
                    transaction.add(R.id.tabcontent, mNewsFragment);
                } else {
                    transaction.show(mNewsFragment);
                }
                break;
            case 1:
                if (mFriendsFragment == null) {
                    mFriendsFragment = new FriendsFragment();
                    transaction.add(R.id.tabcontent, mFriendsFragment);
                } else {
                    transaction.show(mFriendsFragment);
                }
                break;
            case 2:
                if (mMallFragment == null) {
                    mMallFragment = new MallFragment();
                    transaction.add(R.id.tabcontent, mMallFragment);
                } else {
                    transaction.show(mMallFragment);
                }
                break;
            case 3:
                if (mDiscoveryFragment == null) {
                    mDiscoveryFragment = new DiscoveryFragment();
                    transaction.add(R.id.tabcontent, mDiscoveryFragment);
                } else {
                    transaction.show(mDiscoveryFragment);
                }
                break;
            case 4:
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                    transaction.add(R.id.tabcontent, mMeFragment);
                } else {
                    transaction.show(mMeFragment);
                }
                break;
        }
        transaction.commit();//事务进行提交
    }

    private void hideTransaction(FragmentTransaction transaction) {
        if (mNewsFragment != null) {
            transaction.hide(mNewsFragment);
        }
        if (mFriendsFragment != null) {
            transaction.hide(mFriendsFragment);
        }
        if (mMallFragment != null) {
            transaction.hide(mMallFragment);
        }
        if (mDiscoveryFragment != null) {
            transaction.hide(mDiscoveryFragment);
        }
        if (mMeFragment != null) {
            transaction.hide(mMeFragment);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int arg1) {
        switch (arg1) {
            case R.id.rbtn_news:
                SetSelect(0);
                break;
            case R.id.rbtn_friends:
                SetSelect(1);
                break;
            case R.id.rbtn_mall:
                SetSelect(2);
                break;
            case R.id.rbtn_discovery:
                SetSelect(3);
                break;
            case R.id.rbtn_me:
                SetSelect(4);
                break;
        }
    }

    @OnClick(R.id.tv_menu_setting)
    public void openSettingActivity(View view) {
        openActivity(SettingActivity.class);
    }

    @OnClick(R.id.tv_menu_favorite)
    public void openMyFavorite(View view) {
        openActivity(FavoriteActivity.class);
    }

    @OnClick(R.id.tv_menu_trade)
    public void openMyOrder(View view) {
        openActivity(UserOrderActivity.class);
    }
}
