package com.xyz.basiclib.mvp;

import android.content.Context;

import com.xyz.basiclib.permission.AndRequestExecutorAdapter;

import java.util.List;

/**
 * Created by ZP on 2018/5/24.
 */

public interface CheckPermission {

    void showRationaleDialog(Context context, List<String> permissions, AndRequestExecutorAdapter andRequestExecutorAdapter);

    void showAlwaysDeniedRationale(List<String> permissions);
}
