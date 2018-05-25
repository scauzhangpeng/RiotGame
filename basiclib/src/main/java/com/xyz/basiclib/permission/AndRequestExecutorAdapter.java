package com.xyz.basiclib.permission;

import com.yanzhenjie.permission.RequestExecutor;

/**
 * Created by ZP on 2018/5/22.
 */

public class AndRequestExecutorAdapter implements OpRequestExecute {

    private RequestExecutor mRequestExecutor;


    public AndRequestExecutorAdapter(RequestExecutor requestExecutor) {
        mRequestExecutor = requestExecutor;
    }


    @Override
    public void execute() {
        mRequestExecutor.execute();
    }

    @Override
    public void cancel() {
        mRequestExecutor.cancel();
    }
}
