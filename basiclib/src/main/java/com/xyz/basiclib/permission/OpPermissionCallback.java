package com.xyz.basiclib.permission;

import java.util.List;

/**
 * Created by ZP on 2018/5/22.
 */

public interface OpPermissionCallback {

    void onGranted(List<String> permissions);

    void onDenied(List<String> permissions);

}
