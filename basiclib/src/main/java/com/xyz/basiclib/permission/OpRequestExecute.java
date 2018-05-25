package com.xyz.basiclib.permission;

import com.yanzhenjie.permission.RequestExecutor;

/**
 * Created by ZP on 2018/5/22.
 */

public interface OpRequestExecute extends RequestExecutor {

    /**
     * Go request permission.
     */
    void execute();

    /**
     * Cancel the operation.
     */
    void cancel();
}
