package com.xyz.basiclib.permission;

import com.yanzhenjie.permission.RequestExecutor;

/**
 * 运行时权限接口包装类.
 * Created by ZP on 2018/1/31.
 */

public interface PermissionExecutor extends RequestExecutor {

    /**
     * Go request permission.
     */
    void execute();

    /**
     * Cancel the operation.
     */
    void cancel();
}
