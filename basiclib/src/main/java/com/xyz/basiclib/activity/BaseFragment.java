package com.xyz.basiclib.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xyz.basiclib.mvp.BaseView;

/**
 * Created by ZP on 2017/8/2.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    private static final String TAG = "BaseFragment";

    protected View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        initViewsAndEvents(inflater, container, savedInstanceState);
        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract int getLayoutId();


    protected void openActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        getActivity().startActivity(intent);
    }

    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

    @Override
    public void showToastLong(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToastShort(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
