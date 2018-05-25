package com.xyz.basiclib.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by ZP on 2017/8/1.
 * Activity 基类
 */

public abstract class BaseActivity extends CheckPermissionActivity implements BaseView {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
            initViewsAndEvents(savedInstanceState);
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }

    protected abstract void initViewsAndEvents(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    /**
     * 启动Activity
     *
     * @param cls 需要启动的Activity名称
     */
    protected void openActivity(Class<?> cls) {
        openActivity(cls, null);
    }

    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    public void showToastLong(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToastShort(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
