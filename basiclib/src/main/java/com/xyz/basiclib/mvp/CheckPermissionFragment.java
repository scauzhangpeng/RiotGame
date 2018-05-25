package com.xyz.basiclib.mvp;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.xyz.basiclib.permission.AndRequestExecutorAdapter;
import com.xyz.basiclib.permission.OpPermissionCallback;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

import java.util.List;

/**
 * Created by ZP on 2018/5/24.
 */

public abstract class CheckPermissionFragment extends Fragment implements CheckPermission {

    protected void checkPermission(String permission, final OpPermissionCallback callback) {

        AndPermission.with(this)
                .permission(permission)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        callback.onGranted(permissions);
                    }
                }).onDenied(new Action() {
            @Override
            public void onAction(List<String> permissions) {
                if (AndPermission.hasAlwaysDeniedPermission(CheckPermissionFragment.this, permissions)) {
                    // 这些权限被用户总是拒绝。
                    showAlwaysDeniedRationale(permissions);
                } else {
                    callback.onDenied(permissions);
                }
            }
        }).rationale(new Rationale() {
            @Override
            public void showRationale(Context context, List<String> permissions, RequestExecutor executor) {
                showRationaleDialog(context, permissions, new AndRequestExecutorAdapter(executor));
            }
        }).start();
    }
}
