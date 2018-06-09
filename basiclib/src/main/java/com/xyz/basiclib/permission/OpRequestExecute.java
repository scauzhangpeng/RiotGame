package com.xyz.basiclib.permission;

/**
 * Created by ZP on 2018/5/22.
 */

public interface OpRequestExecute {

    /**
     * Go request permission.
     */
    void execute();

    /**
     * Cancel the operation.
     */
    void cancel();
}
