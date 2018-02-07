package com.xyz.basiclib.permission;

import android.content.Context;

import java.util.List;

/**
 * 运行时权限回调接口.
 * Created by ZP on 2018/1/31.
 */

public interface PermissionCallback {

    void onGranted(List<String> permissions);

    void onDenied(List<String> permissions);

    void showAwaysDeniedRationale(List<String> permissions);

    void showRationale(Context context, List<String> permissions, PermissionExecutor executor);
}
