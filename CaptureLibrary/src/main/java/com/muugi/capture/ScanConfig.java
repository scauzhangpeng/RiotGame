package com.muugi.capture;

/**
 * Created by ZP on 2018/8/28.
 */

public class ScanConfig {

    private ScanConfig() {

    }

    public static ScanConfig getInstance() {
        return InnerClazz.instance;
    }

    private static class InnerClazz {
        private static ScanConfig instance = new ScanConfig();
    }


    private boolean autoFocus = true;


    public boolean isAutoFocus() {
        return autoFocus;
    }

    public void setAutoFocus(boolean autoFocus) {
        this.autoFocus = autoFocus;
    }
}
