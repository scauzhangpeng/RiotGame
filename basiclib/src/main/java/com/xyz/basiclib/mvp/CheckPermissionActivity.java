package com.xyz.basiclib.mvp;

import android.content.Context;
import android.util.Log;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

import java.util.List;

/**
 * Created by ZP on 2018/1/30.
 * <p>
 * 检查权限
 * </p>
 */

public abstract class CheckPermissionActivity extends BaseActivity {

    protected void checkPermission(String permission) {

        AndPermission.with(this)
                .permission(permission)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Log.d(TAG, "onAction:1 ");

                    }
                }).onDenied(new Action() {
            @Override
            public void onAction(List<String> permissions) {
                Log.d(TAG, "onAction: 0");
                if (AndPermission.hasAlwaysDeniedPermission(CheckPermissionActivity.this, permissions)) {
                    // 这些权限被用户总是拒绝。
                    Log.d(TAG, "onAction:2");
                }
            }
        }).rationale(new Rationale() {
            @Override
            public void showRationale(Context context, List<String> permissions, RequestExecutor executor) {
                Log.d(TAG, "showRationale: ");
            }
        }).start();
    }
}
