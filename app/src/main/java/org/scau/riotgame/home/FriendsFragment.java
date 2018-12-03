package org.scau.riotgame.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.CommonFragment;

import org.scau.riotgame.R;

import butterknife.BindView;

/**
 * Created by ZP on 2017/7/27.
 */

public class FriendsFragment extends CommonFragment {

    @BindView(R.id.rbtn_friends)
    RadioButton mRbtnFriends;
    @BindView(R.id.rbtn_message)
    RadioButton mRbtnMessage;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_friends;
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        initTopBar();
    }

    private void initTopBar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        mToolbar.setTitle("");
        activity.setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
        mToolbar.setNavigationIcon(null);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.friends_add_friend, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add_friedn) {
            showToastLong("menu_add_friedn");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
