package com.xyz.basiclib.util;

import android.content.Context;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import java.lang.reflect.Field;

/**
 * Created by ZP on 2018/12/3.
 */
public class FixMemoryLeak {

    private static Field field;
    private static boolean hasField = true;

    public static void fixHuaweiLeak(Context context) {
        Log.d("BaseActivity", "开始修复华为7.0内存泄漏");
        if (!hasField) {
            Log.d("BaseActivity", "无需修复华为7.0内存泄漏，没有mLastSrvView字段");
            return;
        }
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }

        String[] arr = new String[]{"mLastSrvView"};
        for (String param : arr) {
            try {
                if (field == null) {
                    field = imm.getClass().getDeclaredField(param);
                }
                if (field == null) {
                    hasField = false;
                }
                if (field != null) {
                    field.setAccessible(true);
                    field.set(imm, null);
                }
            } catch (Throwable t) {
                Log.d("BaseActivity", "修复华为7.0内存泄漏失败");
                t.printStackTrace();
            }
        }
    }
}
