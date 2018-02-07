package com.xyz.basiclib.permission;

import com.yanzhenjie.permission.RequestExecutor;

/**
 * AndPermission运行时权限开源库接口适配器.
 * Created by ZP on 2018/1/31.
 * <p>
 * 将权限库的执行接口{@link RequestExecutor}进行适配转换
 * </p>
 */

public class AndPermissionAdapter implements PermissionExecutor {

    private RequestExecutor mExecutor;

    public AndPermissionAdapter(RequestExecutor executor) {
        mExecutor = executor;
    }


    @Override
    public void execute() {
        mExecutor.execute();
    }

    @Override
    public void cancel() {
        mExecutor.cancel();
    }
}
