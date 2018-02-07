package org.scau.riotgame.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.xyz.basiclib.activity.SimpleButterKnifeFragment;

import org.scau.riotgame.R;

import butterknife.Bind;

/**
 * Created by ZP on 2017/7/27.
 */

public class MallFragment extends SimpleButterKnifeFragment {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mall;
    }

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        initTopBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_news_search) {
            showToastLong("search");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.news_search, menu);
//        super.onCreateOptionsMenu(menu, inflater);
    }

    private void initTopBar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        mToolbar.setTitle("");
        activity.setSupportActionBar(mToolbar);
        setHasOptionsMenu(true);
    }
}
