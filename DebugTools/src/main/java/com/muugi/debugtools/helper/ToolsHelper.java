package com.muugi.debugtools.helper;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.github.moduth.blockcanary.BlockCanary;
import com.muugi.debugtools.block.AppBlockCanaryContext;
import com.muugi.debugtools.ele.EleActivityLifecycleCallbacks;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.wstt.gt.controller.GTRController;

/**
 * @author zhangpeng
 * @date 2018/11/12
 * @since 1.0
 */
public class ToolsHelper {


    /**
     * 初始化GT性能检测工具.
     */
    public void initGT(Context context) {
        GTRController.init(context);
    }

    /**
     * 初始化页面卡顿检测工具.
     */
    public void initBlockCanary(Context context) {
        BlockCanary.install(context, new AppBlockCanaryContext()).start();
    }

    /**
     * 初始化内存泄漏检测工具.
     */
    public void initLeakCanary(Application context) {
        if (LeakCanary.isInAnalyzerProcess(context)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(context);
    }

    /**
     * 初始化饿了么UE调试工具.
     */
    public void initEleUeTool(Application context) {
//        UETool.putFilterClass(FilterOutView.class);
//        UETool.putAttrsProviderClass(CustomAttribution.class);

        context.registerActivityLifecycleCallbacks(new EleActivityLifecycleCallbacks());
    }

    /**
     * 初始化facebook 数据库调试工具.
     */
    public void initStetho(Context context) {
        Stetho.initializeWithDefaults(context);
    }
}
