package com.muugi.capture;

import com.google.zxing.client.android.camera.FrontLightMode;

/**
 * Created by ZP on 2018/8/28.
 */

public class ScanClient {

    /**
     * 一维码：商品.
     */
    private boolean decode1DProduct;
    /**
     * 一维码：工业.
     */
    private boolean decode1DIndustrial;
    /**
     * 二维码.
     */
    private boolean decodeQR;
    /**
     * Data Matrix.
     */
    private boolean decodeDataMatrix;
    /**
     * Aztec.
     */
    private boolean decodeAztec;
    /**
     * PDF417(测试).
     */
    private boolean decodePDF417;
    /**
     * 播放提示音.
     */
    private boolean playBeep;
    /**
     * 振动.
     */
    private boolean vibrate;
    /**
     * 自动复制剪切板.
     */
    private boolean copyToClipBoard;
    /**
     * 闪光灯.
     */
    private String frontLightMode;
    /**
     * 自动对焦.
     */
    private boolean autoFocus;
    /**
     * 反色.
     * 扫描黑色背景上的白色条码。仅适用于部分设备
     */
    private boolean invertScan;
    /**
     * 自动旋转.
     */
    private boolean autoOrientation;
    /**
     * 不持续对焦.
     */
    private boolean disableContinueFocus;
    /**
     * 不曝光.
     */
    private boolean disableExposure;
    /**
     * 不使用距离测量.
     */
    private boolean disableMetering;
    /**
     * 不进行条形码场景匹配.
     */
    private boolean disableBarcodeSceneMode;

    private ScanClient() {
        this(new Builder());
    }

    private ScanClient(Builder builder) {
        decode1DProduct = builder.decode1DProduct;
        decode1DIndustrial = builder.decode1DIndustrial;
        decodeQR = builder.decodeQR;
        decodeDataMatrix = builder.decodeDataMatrix;
        decodeAztec = builder.decodeAztec;
        decodePDF417 = builder.decodePDF417;
        playBeep = builder.playBeep;
        vibrate = builder.vibrate;
        copyToClipBoard = builder.copyToClipBoard;
        frontLightMode = builder.frontLightMode;
        autoFocus = builder.autoFocus;
        invertScan = builder.invertScan;
        autoOrientation = builder.autoOrientation;
        disableContinueFocus = builder.disableContinueFocus;
        disableExposure = builder.disableExposure;
        disableMetering = builder.disableMetering;
        disableBarcodeSceneMode = builder.disableBarcodeSceneMode;
    }

    public static ScanClient getInstance() {
        return InnerClazz.instance;
    }

    private static class InnerClazz {
        private static ScanClient instance = new ScanClient();
    }


    public static final class Builder {
        private boolean decode1DProduct;
        private boolean decode1DIndustrial;
        private boolean decodeQR;
        private boolean decodeDataMatrix;
        private boolean decodeAztec;
        private boolean decodePDF417;
        private boolean playBeep;
        private boolean vibrate;
        private boolean copyToClipBoard;
        private String frontLightMode;
        private boolean autoFocus;
        private boolean invertScan;
        private boolean autoOrientation;
        private boolean disableContinueFocus;
        private boolean disableExposure;
        private boolean disableMetering;
        private boolean disableBarcodeSceneMode;

        public Builder() {
            decode1DProduct = true;
            decode1DIndustrial = true;
            decodeQR = true;
            decodeDataMatrix = true;
            decodeAztec = false;
            decodePDF417 = false;
            playBeep = true;
            vibrate = false;
            copyToClipBoard = true;
            frontLightMode = FrontLightMode.OFF.toString();
            autoFocus = true;
            invertScan = false;
            autoOrientation = false;
            disableContinueFocus = true;
            disableExposure = true;
            disableMetering = true;
            disableBarcodeSceneMode = true;
        }

        public Builder decode1DProduct(boolean val) {
            decode1DProduct = val;
            return this;
        }

        public Builder decode1DIndustrial(boolean val) {
            decode1DIndustrial = val;
            return this;
        }

        public Builder decodeQR(boolean val) {
            decodeQR = val;
            return this;
        }

        public Builder decodeDataMatrix(boolean val) {
            decodeDataMatrix = val;
            return this;
        }

        public Builder decodeAztec(boolean val) {
            decodeAztec = val;
            return this;
        }

        public Builder decodePDF417(boolean val) {
            decodePDF417 = val;
            return this;
        }

        public Builder playBeep(boolean val) {
            playBeep = val;
            return this;
        }

        public Builder vibrate(boolean val) {
            vibrate = val;
            return this;
        }

        public Builder copyToClipBoard(boolean val) {
            copyToClipBoard = val;
            return this;
        }

        public Builder frontLightMode(String val) {
            frontLightMode = val;
            return this;
        }

        public Builder autoFocus(boolean val) {
            autoFocus = val;
            return this;
        }

        public Builder invertScan(boolean val) {
            invertScan = val;
            return this;
        }

        public Builder autoOrientation(boolean val) {
            autoOrientation = val;
            return this;
        }

        public Builder disableContinueFocus(boolean val) {
            disableContinueFocus = val;
            return this;
        }

        public Builder disableExposure(boolean val) {
            disableExposure = val;
            return this;
        }

        public Builder disableMetering(boolean val) {
            disableMetering = val;
            return this;
        }

        public Builder disableBarcodeSceneMode(boolean val) {
            disableBarcodeSceneMode = val;
            return this;
        }

        public ScanClient build() {
            return new ScanClient(this);
        }
    }

    public boolean isDecode1DProduct() {
        return decode1DProduct;
    }

    public void setDecode1DProduct(boolean decode1DProduct) {
        this.decode1DProduct = decode1DProduct;
    }

    public boolean isDecode1DIndustrial() {
        return decode1DIndustrial;
    }

    public void setDecode1DIndustrial(boolean decode1DIndustrial) {
        this.decode1DIndustrial = decode1DIndustrial;
    }

    public boolean isDecodeQR() {
        return decodeQR;
    }

    public void setDecodeQR(boolean decodeQR) {
        this.decodeQR = decodeQR;
    }

    public boolean isDecodeDataMatrix() {
        return decodeDataMatrix;
    }

    public void setDecodeDataMatrix(boolean decodeDataMatrix) {
        this.decodeDataMatrix = decodeDataMatrix;
    }

    public boolean isDecodeAztec() {
        return decodeAztec;
    }

    public void setDecodeAztec(boolean decodeAztec) {
        this.decodeAztec = decodeAztec;
    }

    public boolean isDecodePDF417() {
        return decodePDF417;
    }

    public void setDecodePDF417(boolean decodePDF417) {
        this.decodePDF417 = decodePDF417;
    }

    public boolean isPlayBeep() {
        return playBeep;
    }

    public void setPlayBeep(boolean playBeep) {
        this.playBeep = playBeep;
    }

    public boolean isVibrate() {
        return vibrate;
    }

    public void setVibrate(boolean vibrate) {
        this.vibrate = vibrate;
    }

    public boolean isCopyToClipBoard() {
        return copyToClipBoard;
    }

    public void setCopyToClipBoard(boolean copyToClipBoard) {
        this.copyToClipBoard = copyToClipBoard;
    }

    public String getFrontLightMode() {
        return frontLightMode;
    }

    public void setFrontLightMode(String frontLightMode) {
        this.frontLightMode = frontLightMode;
    }

    public boolean isAutoFocus() {
        return autoFocus;
    }

    public void setAutoFocus(boolean autoFocus) {
        this.autoFocus = autoFocus;
    }

    public boolean isInvertScan() {
        return invertScan;
    }

    public void setInvertScan(boolean invertScan) {
        this.invertScan = invertScan;
    }

    public boolean isAutoOrientation() {
        return autoOrientation;
    }

    public void setAutoOrientation(boolean autoOrientation) {
        this.autoOrientation = autoOrientation;
    }

    public boolean isDisableContinueFocus() {
        return disableContinueFocus;
    }

    public void setDisableContinueFocus(boolean disableContinueFocus) {
        this.disableContinueFocus = disableContinueFocus;
    }

    public boolean isDisableExposure() {
        return disableExposure;
    }

    public void setDisableExposure(boolean disableExposure) {
        this.disableExposure = disableExposure;
    }

    public boolean isDisableMetering() {
        return disableMetering;
    }

    public void setDisableMetering(boolean disableMetering) {
        this.disableMetering = disableMetering;
    }

    public boolean isDisableBarcodeSceneMode() {
        return disableBarcodeSceneMode;
    }

    public void setDisableBarcodeSceneMode(boolean disableBarcodeSceneMode) {
        this.disableBarcodeSceneMode = disableBarcodeSceneMode;
    }
}
