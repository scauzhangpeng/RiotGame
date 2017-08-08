package org.scau.riotgame.mall;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;

import org.scau.riotgame.R;
import org.scau.riotgame.base.BaseActivity;

/**
 * Created by ZP on 2017/8/5.
 */

public class UserOrderActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order);
        initTopBar(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order_online_service, menu);
        return true;
    }
}
