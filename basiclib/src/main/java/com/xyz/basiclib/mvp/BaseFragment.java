package com.xyz.basiclib.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ZP on 2017/8/2.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    private Toolbar mToolbar;
    private TextView mTvTitle;
    private ImageView mIvLeft;

    private View mView;

//    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null);
//        unbinder = ButterKnife.bind(this, mView);
        initViewsAndEvents(inflater, container, savedInstanceState);
        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        unbinder.unbind();
    }

    protected abstract void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract int getLayoutId();


    //    protected Toolbar initTopBar(AppCompatActivity activity, View view) {
//        mTvTitle = (TextView) view.findViewById(R.id.toolbar_title);
//        mIvLeft = (ImageView) view.findViewById(R.id.toolbar_left);
//
//        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        mToolbar.setTitle("");
//        //mToolbar.setPadding(0, ScreenUtil.getStatusBarHeight(this), 0, 0);
//        //mToolbar.setNavigationIcon(R.drawable.nav_back_selector);
//
//        activity.setSupportActionBar(mToolbar);
//        //必须设置在setSupportActionBar之后才有用
//        mToolbar.setNavigationIcon(null);
//        return mToolbar;
//    }

    protected Toolbar setTitle(String msg) {
        mTvTitle.setText(msg);
        return mToolbar;
    }

//    protected Toolbar setLeftImage(AbstractImageLoader abstractImageLoader) {
//        mToolbar.setNavigationIcon(null);
//        mIvLeft.setVisibility(View.VISIBLE);
//        abstractImageLoader.loadImage(mIvLeft, abstractImageLoader.getPath());
//        return mToolbar;
//    }


    protected void openActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        getActivity().startActivity(intent);
    }

    protected void openActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        getActivity().startActivity(intent);
    }

//    protected void openWebViewActivity(String url) {
//        Bundle bundle = new Bundle();
//        bundle.putString("url", url);
//        openActivity(WebViewActivity.class, bundle);
//    }

    @Override
    public void showToastLong(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToastShort(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
