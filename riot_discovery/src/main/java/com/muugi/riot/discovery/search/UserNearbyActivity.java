package com.muugi.riot.discovery.search;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.muugi.riot.discovery.R;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;


/**
 * Created by ZP on 2017/8/2.
 * <p>
 * 附近玩家
 * </p>
 */

public class UserNearbyActivity extends SimpleTopBarActivity {

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_user_nearby;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_nearby_more, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_more) {
            Toast.makeText(UserNearbyActivity.this, "more", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
