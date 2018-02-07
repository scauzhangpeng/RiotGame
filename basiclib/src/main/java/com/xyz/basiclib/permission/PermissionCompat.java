package com.xyz.basiclib.permission;

import android.content.Context;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.SettingService;

import java.util.List;

/**
 * 运行时权限工具类.
 * <p>
 * {@link PermissionCompat#toPermissionSetting(Context)} 跳转至系统权限设置界面
 * {@link PermissionCompat#transformText(Context, List)} 权限转化为文字信息
 * </p>
 * Created by ZP on 2018/1/31.
 */

public class PermissionCompat {


    public static boolean toPermissionSetting(Context context) {
        try {
            SettingService settingService = AndPermission.permissionSetting(context);
            settingService.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<String> transformText(Context context, String... text) {
        return Permission.transformText(context, text);
    }

    public static List<String> transformText(Context context, List<String> text) {
        return Permission.transformText(context, text);
    }
}
