package com.xyz.basiclib.permission;

import android.content.Context;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.SettingService;

/**
 * Created by ZP on 2018/5/22.
 */

public class OpSettingService {

    private static OpSettingService mOpSettingService;
    private SettingService mSettingService;


    private OpSettingService(Context context) {
        mSettingService = AndPermission.permissionSetting(context);
    }

    public static OpSettingService getInstance(Context context) {
        if (mOpSettingService == null) {
            synchronized (OpSettingService.class) {
                if (mOpSettingService == null) {
                    mOpSettingService = new OpSettingService(context);
                }
            }
        }
        return mOpSettingService;
    }

    public void execute() {
        mSettingService.execute();
    }

    public void cancel() {
        mSettingService.cancel();
    }
}
