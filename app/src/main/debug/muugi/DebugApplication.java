package muugi;

import android.util.Log;

import com.muugi.debugtools.helper.ToolsHelper;

import com.xyz.riotcommon.RiotGameApplication;

/**
 * Created by ZP on 2018/7/11.
 */

public class DebugApplication extends RiotGameApplication {

    private static final String TAG = "muugi.DebugApplication";
    private ToolsHelper mHelper;

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
        mHelper = new ToolsHelper();
        initStetho();
        initEleUeTool();
        initLeakCanary();
        initBlockCanary();
//        initGT();
    }

    /**
     * 初始化facebook 数据库调试工具.
     */
    private void initStetho() {
        mHelper.initStetho(this);
    }

    /**
     * 初始化GT性能检测工具.
     */
    private void initGT() {
        mHelper.initGT(this);
    }

    /**
     * 初始化页面卡顿检测工具.
     */
    private void initBlockCanary() {
        mHelper.initBlockCanary(this);
    }

    /**
     * 初始化内存泄漏检测工具.
     */
    private void initLeakCanary() {
        mHelper.initLeakCanary(this);
    }

    /**
     * 初始化饿了么UE调试工具.
     */
    private void initEleUeTool() {
        mHelper.initEleUeTool(this);
    }

}
