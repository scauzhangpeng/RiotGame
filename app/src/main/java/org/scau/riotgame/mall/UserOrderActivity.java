package org.scau.riotgame.mall;

import android.os.Bundle;
import android.view.Menu;

import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/8/5.
 */

public class UserOrderActivity extends SimpleTopBarActivity {

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_user_order;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order_online_service, menu);
        return true;
    }
}
