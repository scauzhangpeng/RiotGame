package muugi;

import android.util.Log;

import com.github.moduth.blockcanary.BlockCanary;
import com.muugi.debugtools.block.AppBlockCanaryContext;
import com.muugi.debugtools.ele.EleActivityLifecycleCallbacks;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.wstt.gt.controller.GTRController;

import org.scau.riotgame.RiotGameApplication;

/**
 * Created by ZP on 2018/7/11.
 */

public class DebugApplication extends RiotGameApplication {

    private static final String TAG = "muugi.DebugApplication";

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();

        initEleUeTool();
        initLeakCanary();
        initBlockCanary();
        initGT();
    }

    /**
     * 初始化GT性能检测工具.
     */
    private void initGT() {
        GTRController.init(this);
    }

    /**
     * 初始化页面卡顿检测工具.
     */
    private void initBlockCanary() {
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
    }

    /**
     * 初始化内存泄漏检测工具.
     */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    /**
     * 初始化饿了么UE调试工具.
     */
    private void initEleUeTool() {
//        UETool.putFilterClass(FilterOutView.class);
//        UETool.putAttrsProviderClass(CustomAttribution.class);

        registerActivityLifecycleCallbacks(new EleActivityLifecycleCallbacks());
    }

}
