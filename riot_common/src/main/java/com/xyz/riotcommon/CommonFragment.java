package com.xyz.riotcommon;

import android.content.Context;
import android.view.View;

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
}
