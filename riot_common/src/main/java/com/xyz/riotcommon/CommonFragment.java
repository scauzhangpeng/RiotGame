package com.xyz.riotcommon;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.MvpButterKnifeFragment;
import com.xyz.basiclib.permission.AndRequestExecutorAdapter;
import com.xyz.basiclib.permission.OpSettingService;
import com.xyz.basiclib.util.DefaultDialog;

import java.util.List;

/**
 * 统一业务基类.
 * Created by ZP on 2018/5/23.
 */

public abstract class CommonFragment<V, P extends BasePresenter<V>> extends MvpButterKnifeFragment<V, P> {

    protected DefaultDialog mPermissionDialog;

    protected boolean isViewCreated;
    protected boolean isFirstVisible = true;
    protected boolean isFragmentVisible;


    @Override
    public void showRationaleDialog(Context context, List<String> permissions, final AndRequestExecutorAdapter andRequestExecutorAdapter) {
        showPermissionDialog(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPermissionDialog();
                andRequestExecutorAdapter.cancel();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPermissionDialog();
                andRequestExecutorAdapter.execute();
            }
        });
    }

    @Override
    public void showAlwaysDeniedRationale(List<String> permissions) {
        showPermissionDialog(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPermissionDialog();
                OpSettingService.getInstance(getContext()).cancel();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPermissionDialog();
                OpSettingService.getInstance(getContext()).execute();
            }
        });
    }


    protected void showPermissionDialog(View.OnClickListener cancelListener, View.OnClickListener okListener) {
        dismissPermissionDialog();
        mPermissionDialog = new DefaultDialog(getActivity());
        mPermissionDialog.show();
        mPermissionDialog.setCancelListener(cancelListener);
        mPermissionDialog.setOkListener(okListener);
    }

    protected void dismissPermissionDialog() {
        if (mPermissionDialog != null && mPermissionDialog.isShowing()) {
            mPermissionDialog.dismiss();
            mPermissionDialog = null;
        }
    }

    @Override
    public void showEmptyPage(String msg) {

    }

    @Override
    public void showErrorPage(String msg) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        isViewCreated = true;
        if (isFragmentVisible && isFirstVisible) {
            Log.e(TAG, "Adapter 默认展示的那个 Fragment ，或者隔 tab 选中的时候  requestData 推迟到 onCreateView 后 ");
            requestData();
            isFirstVisible = false;
        }
        return mView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        isFragmentVisible = isVisibleToUser;
        Log.d(TAG, "setUserVisibleHint: " + isViewCreated + isFirstVisible + isFragmentVisible);
        //当 View 创建完成切 用户可见的时候请求 且仅当是第一次对用户可见的时候请求自动数据
        if (isVisibleToUser && isViewCreated && isFirstVisible) {
            Log.e(TAG, "只有自动请求一次数据  requestData");
            requestData();
            isFirstVisible = false;

        }
    }

    protected void requestData() {
        Log.d(TAG, "requestData: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: " + isViewCreated + isFirstVisible + isFragmentVisible);
    }
}
