package muugi;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.muugi.capture.BuildConfig;

/**
 * Created by ZP on 2018/9/17.
 */

public class CaptureApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {
            // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(this); // As early as possible, it is recommended to initialize in the Application
    }
}
