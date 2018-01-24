package com.xyz.basiclib.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by ZP on 2017/8/16.
 */

public abstract class MvpFragment<V, P extends BasePresenter<V>> extends BaseFragment {


    protected P mPresenter;
    protected View mView;

    /**
     * 布局
     */
    private FrameLayout mFlTopBar;
    private FrameLayout mFlContent;
    private View mTopView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        mView = inflater.inflate(R.layout.fragment_base_topbar, null);
//        //init top bar
//        mFlTopBar = (FrameLayout) mView.findViewById(R.id.f_fl_topbar);
//        mFlContent = (FrameLayout) mView.findViewById(R.id.f_fl_content);
//        mTopView = getTopBarView();
//        if (mTopView != null) {
//            mFlTopBar.addView(mTopView);
//            mFlTopBar.setVisibility(View.VISIBLE);
//        } else {
//            mFlTopBar.setVisibility(View.GONE);
//        }
//        //init content view
//        inflater.inflate(getLayoutId(), mFlContent, true);
//        //bind view
//        binder = ButterKnife.bind(this, mView);
//        initRootView(inflater, container, savedInstanceState);
        //
//        initViewsAndEvents(container, savedInstanceState);
//        initTopBar(mTopView);
        mPresenter = initPresenter();
        mPresenter.attachView((V) this);
        return mView;
    }

//    protected abstract void initRootView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

//    protected abstract void initTopBar(View topView);

//    protected abstract View getTopBarView();


//    protected abstract void initViewsAndEvents(ViewGroup container, Bundle savedInstanceState);

//    protected abstract int getLayoutId();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detachView();
    }

    protected abstract P initPresenter();

}
