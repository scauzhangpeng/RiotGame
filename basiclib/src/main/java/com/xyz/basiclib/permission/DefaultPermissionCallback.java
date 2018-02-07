package com.xyz.basiclib.permission;

import android.content.Context;

import java.util.List;

/**
 * 运行时权限默认回调.
 * Created by ZP on 2018/1/31.
 * <p>
 * 运行时权限在最上层业务层仅需要关注成功与失败。
 * </p>
 * <p>
 * 第一次权限被用户禁止，回调{@link PermissionCallback#showRationale(Context, List, PermissionExecutor)}
 * 被用户勾选“不再询问”并且申请的权限被拒绝，回调{@link PermissionCallback#showAwaysDeniedRationale(List)}
 * 由业务基础层统一封装，例如：统一提示Dialog。
 * </p>
 */

public abstract class DefaultPermissionCallback implements PermissionCallback {

    @Override
    public void showAwaysDeniedRationale(final List<String> permissions) {

    }

    @Override
    public void showRationale(Context context, List<String> permissions, final PermissionExecutor executor) {

    }
}
