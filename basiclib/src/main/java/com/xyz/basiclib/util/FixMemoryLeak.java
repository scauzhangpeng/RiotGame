package com.xyz.basiclib.util;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.lang.reflect.Field;

/**
 * 华为6.0、7.0出现的mLastSrvView出现的内存泄漏.
 * <a href = "https://github.com/square/leakcanary/issues/572">官方issue</a>
 * <a href = "https://www.jianshu.com/p/95242060320f">解决方案</a>
 * <a href = "https://www.jianshu.com/p/bc79e01da6b0">分析方案</a>
 * Created by ZP on 2018/12/3.
 */
public class FixMemoryLeak {

    public static void fixHWInputMethodManagerLeak(Context destContext) {
        Log.d("fixHWInputMethodManager", "开始修复华为7.0内存泄漏");
        if (destContext == null) {
            return;
        }

        InputMethodManager imm = (InputMethodManager) destContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }
        String[] arr = new String[]{"mLastSrvView"};
        Field f = null;
        Object obj_get = null;
        for (String param : arr) {
            try {
                f = imm.getClass().getDeclaredField(param);
                if (f == null) {
                    Log.d("BaseActivity", "无需修复华为7.0内存泄漏，没有mLastSrvView字段");
                    return;
                }
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                obj_get = f.get(imm);
                if (obj_get != null && obj_get instanceof View) {
                    f.set(imm, null);
                } else {
                    Log.d("BaseActivity", "无需修复华为7.0内存泄漏，mLastSrvView为空");
                }
            } catch (Throwable t) {
                Log.d("BaseActivity", "修复华为7.0内存泄漏失败," + t.getMessage());
                t.printStackTrace();
            }
        }

    }

    public static void fixInputMethodManagerLeak(Context destContext) {
        Log.d("fixInputMethodManager", "开始修复内存泄漏");
        if (destContext == null) {
            return;
        }

        InputMethodManager imm = (InputMethodManager) destContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) {
            return;
        }

        String[] arr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
        Field f = null;
        Object obj_get = null;
        for (String param : arr) {
            try {
                f = imm.getClass().getDeclaredField(param);
                if (f == null) {
                    Log.d("BaseActivity", "无需修复内存泄漏，没有" + param + "字段");
                    return;
                }
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                obj_get = f.get(imm);
                if (obj_get != null && obj_get instanceof View) {
                    View v_get = (View) obj_get;
                    if (v_get.getContext() == destContext) { // 被InputMethodManager持有引用的context是想要目标销毁的
                        f.set(imm, null); // 置空，破坏掉path to gc节点
                    } else {
                        // 不是想要目标销毁的，即为又进了另一层界面了，不要处理，避免影响原逻辑,也就不用继续for循环了
                        break;
                    }
                } else {
                    Log.d("BaseActivity", "无需修复内存泄漏，" + param + "为空");
                }
            } catch (Throwable t) {
                Log.d("BaseActivity", "修复内存泄漏失败，" + t.getMessage());
                t.printStackTrace();
            }
        }
    }
}
