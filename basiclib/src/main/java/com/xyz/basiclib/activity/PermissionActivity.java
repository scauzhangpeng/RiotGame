package com.xyz.basiclib.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.xyz.basiclib.permission.AndPermissionAdapter;
import com.xyz.basiclib.permission.PermissionCallback;
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

public class PermissionActivity extends AppCompatActivity {

    /**
     * 检查权限
     *
     * @param callback        {@link PermissionCallback}
     * @param needPermissions 需要申请的权限
     */
    protected void checkPermission(final PermissionCallback callback, final String... needPermissions) {
        AndPermission.with(this)
                .permission(needPermissions)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        callback.onGranted(permissions);
                    }
                }).onDenied(new Action() {
            @Override
            public void onAction(final List<String> permissions) {
                if (AndPermission.hasAlwaysDeniedPermission(PermissionActivity.this, permissions)) {
                    // 这些权限被用户总是拒绝。
                    callback.showAwaysDeniedRationale(permissions);
                } else {
                    callback.onDenied(permissions);
                }
            }
        }).rationale(new Rationale() {
            @Override
            public void showRationale(Context context, final List<String> permissions, final RequestExecutor executor) {
                callback.showRationale(context, permissions, new AndPermissionAdapter(executor));
            }
        }).start();
    }
}
