package com.muugi.capture;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.AmbientLightManager;
import com.google.zxing.client.android.CaptureActivityHandler;
import com.google.zxing.client.android.FinishListener;
import com.google.zxing.client.android.InactivityTimer;
import com.google.zxing.client.android.ViewfinderView;
import com.google.zxing.client.android.camera.CameraManager;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by ZP on 2018/6/1.
 */

public class CaptureActivity extends SimpleTopBarActivity implements SurfaceHolder.Callback {

    private CameraManager cameraManager;
    private ViewfinderView viewfinderView;
    private boolean hasSurface;

    private AmbientLightManager ambientLightManager;
    private InactivityTimer inactivityTimer;
    //add because fix bug
    MyOrientationDetector myOrientationDetector;

    private Result lastResult;

    private CaptureActivityHandler handler;

    private Collection<BarcodeFormat> decodeFormats;
    private Map<DecodeHintType, ?> decodeHints;
    private String characterSet;

    private TextView mTvAlbum;
    private TextView mTvFlash;
    private TextView mTvMyBarCode;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_capture;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.initViewsAndEvents(savedInstanceState);


        decodeFormats = null;
        decodeHints = null;
        characterSet = null;

        hasSurface = false;
        inactivityTimer = new InactivityTimer(this);
//    beepManager = new BeepManager(this);
        ambientLightManager = new AmbientLightManager(this);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        //add because fix bug
        myOrientationDetector = new MyOrientationDetector(this);
        myOrientationDetector.setLastOrientation(getWindowManager().getDefaultDisplay().getRotation());
        //add because fix bug

        //相册
        mTvAlbum = (TextView) findViewById(R.id.tv_album);
        mTvAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlbumByRouter();
            }
        });
        //闪光灯
        mTvFlash = (TextView) findViewById(R.id.tv_flash);
        mTvFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFlashLight();
            }
        });
        //二维码
        mTvMyBarCode = (TextView) findViewById(R.id.tv_my_qr);
        mTvMyBarCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQRCode();
            }
        });
    }

    private void openQRCode() {
        openActivity(QRActivity.class);
    }

    private void switchFlashLight() {
        cameraManager.setTorch(true);
    }

    private void openAlbumByRouter() {
        ARouter.getInstance().build("/album/main").navigation();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // CameraManager must be initialized here, not in onCreate(). This is necessary because we don't
        // want to open the camera driver and measure the screen size if we're going to show the help on
        // first launch. That led to bugs where the scanning rectangle was the wrong size and partially
        // off screen.
        cameraManager = new CameraManager(getApplication());

        viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
        viewfinderView.setCameraManager(cameraManager);

        handler = null;
        lastResult = null;

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

//    if (prefs.getBoolean(PreferencesActivity.KEY_DISABLE_AUTO_ORIENTATION, true)) {
//        setRequestedOrientation(getCurrentOrientation());
//      } else {
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
//    }

        //add because fix bug
        if (!ScanClient.getInstance().isAutoOrientation()) {
            setRequestedOrientation(getCurrentOrientation());
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR); // 旋转
            myOrientationDetector.enable(); //启用监听
        }
        //add because fix bug end

        resetStatusView();


//    beepManager.updatePrefs();
        ambientLightManager.start(cameraManager);

        inactivityTimer.onResume();

        Intent intent = getIntent();


//        source = IntentSource.NONE;
//        sourceUrl = null;
//        scanFromWebPageManager = null;
//        decodeFormats = null;
//        characterSet = null;
//
//        if (intent != null) {
//
//            String action = intent.getAction();
//            String dataString = intent.getDataString();
//
//            if (Intents.Scan.ACTION.equals(action)) {
//
//                // Scan the formats the intent requested, and return the result to the calling activity.
//                source = IntentSource.NATIVE_APP_INTENT;
//                decodeFormats = DecodeFormatManager.parseDecodeFormats(intent);
//                decodeHints = DecodeHintManager.parseDecodeHints(intent);
//
//                if (intent.hasExtra(Intents.Scan.WIDTH) && intent.hasExtra(Intents.Scan.HEIGHT)) {
//                    int width = intent.getIntExtra(Intents.Scan.WIDTH, 0);
//                    int height = intent.getIntExtra(Intents.Scan.HEIGHT, 0);
//                    if (width > 0 && height > 0) {
//                        cameraManager.setManualFramingRect(width, height);
//                    }
//                }
//
//                if (intent.hasExtra(Intents.Scan.CAMERA_ID)) {
//                    int cameraId = intent.getIntExtra(Intents.Scan.CAMERA_ID, -1);
//                    if (cameraId >= 0) {
//                        cameraManager.setManualCameraId(cameraId);
//                    }
//                }
//
//                String customPromptMessage = intent.getStringExtra(Intents.Scan.PROMPT_MESSAGE);
//                if (customPromptMessage != null) {
//                    statusView.setText(customPromptMessage);
//                }
//
//            } else if (dataString != null &&
//                    dataString.contains("http://www.google") &&
//                    dataString.contains("/m/products/scan")) {
//
//                // Scan only products and send the result to mobile Product Search.
//                source = IntentSource.PRODUCT_SEARCH_LINK;
//                sourceUrl = dataString;
//                decodeFormats = DecodeFormatManager.PRODUCT_FORMATS;
//
//            } else if (isZXingURL(dataString)) {
//
//                // Scan formats requested in query string (all formats if none specified).
//                // If a return URL is specified, send the results there. Otherwise, handle it ourselves.
//                source = IntentSource.ZXING_LINK;
//                sourceUrl = dataString;
//                Uri inputUri = Uri.parse(dataString);
//                scanFromWebPageManager = new ScanFromWebPageManager(inputUri);
//                decodeFormats = DecodeFormatManager.parseDecodeFormats(inputUri);
//                // Allow a sub-set of the hints to be specified by the caller.
//                decodeHints = DecodeHintManager.parseDecodeHints(inputUri);
//
//            }
//
//            characterSet = intent.getStringExtra(Intents.Scan.CHARACTER_SET);
//
//        }

        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        if (hasSurface) {
            // The activity was paused but not stopped, so the surface still exists. Therefore
            // surfaceCreated() won't be called, so init the camera here.
            initCamera(surfaceHolder);
        } else {
            // Install the callback and wait for surfaceCreated() to init the camera.
            surfaceHolder.addCallback(this);
        }
    }

    @Override
    protected void onPause() {
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        inactivityTimer.onPause();
        ambientLightManager.stop();
//    beepManager.close();
        cameraManager.closeDriver();
//    historyManager = null; // Keep for onActivityResult
        if (!hasSurface) {
            SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
            SurfaceHolder surfaceHolder = surfaceView.getHolder();
            surfaceHolder.removeCallback(this);
        }

        //add because fix bug
        myOrientationDetector.disable();
        //add because fix bug
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        inactivityTimer.shutdown();
        super.onDestroy();
    }

    public Handler getHandler() {
        return handler;
    }

    public CameraManager getCameraManager() {
        return cameraManager;
    }

    public ViewfinderView getViewfinderView() {
        return viewfinderView;
    }

    public void drawViewfinder() {
        viewfinderView.drawViewfinder();
    }


    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (cameraManager.isOpen()) {
            Log.w(TAG, "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            cameraManager.openDriver(surfaceHolder);
            // Creating the handler starts the preview, which can also throw a RuntimeException.
            if (handler == null) {
                handler = new CaptureActivityHandler(this, decodeFormats, decodeHints, characterSet, cameraManager);
            }
//            decodeOrStoreSavedBitmap(null, null);
        } catch (IOException ioe) {
            Log.w(TAG, ioe);
            displayFrameworkBugMessageAndExit();
        } catch (RuntimeException e) {
            // Barcode Scanner has seen crashes in the wild of this variety:
            // java.?lang.?RuntimeException: Fail to connect to camera service
            Log.w(TAG, "Unexpected error initializing camera", e);
            displayFrameworkBugMessageAndExit();
        }
    }

    /**
     * A valid barcode has been found, so give an indication of success and show the results.
     *
     * @param rawResult   The contents of the barcode.
     * @param scaleFactor amount by which thumbnail was scaled
     * @param barcode     A greyscale bitmap of the camera data which was decoded.
     */
    public void handleDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        inactivityTimer.onActivity();
        lastResult = rawResult;
//        Toast.makeText(this, rawResult.getText(), Toast.LENGTH_LONG).show();
//        ResultHandler resultHandler = ResultHandlerFactory.makeResultHandler(this, rawResult);

        boolean fromLiveScan = barcode != null;
        if (fromLiveScan) {
//            historyManager.addHistoryItem(rawResult, resultHandler);
            // Then not from history, so beep/vibrate and we have an image to draw on
//      beepManager.playBeepSoundAndVibrate();
            drawResultPoints(barcode, scaleFactor, rawResult);
        }

        if (barcode != null) {
            viewfinderView.drawResultBitmap(barcode);
        }

        openScanTip(rawResult, barcode);

//        switch (source) {
//            case NATIVE_APP_INTENT:
//            case PRODUCT_SEARCH_LINK:
//                handleDecodeExternally(rawResult, resultHandler, barcode);
//                break;
//            case ZXING_LINK:
//                if (scanFromWebPageManager == null || !scanFromWebPageManager.isScanFromWebPage()) {
//                    handleDecodeInternally(rawResult, resultHandler, barcode);
//                } else {
//                    handleDecodeExternally(rawResult, resultHandler, barcode);
//                }
//                break;
//            case NONE:
//                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//                if (fromLiveScan && prefs.getBoolean(PreferencesActivity.KEY_BULK_MODE, false)) {
//                    Toast.makeText(getApplicationContext(),
//                            getResources().getString(R.string.msg_bulk_mode_scanned) + " (" + rawResult.getText() + ')',
//                            Toast.LENGTH_SHORT).show();
//                    maybeSetClipboard(resultHandler);
//                    // Wait a moment or else it will scan the same barcode continuously about 3 times
//                    restartPreviewAfterDelay(BULK_MODE_SCAN_DELAY_MS);
//                } else {
//                    handleDecodeInternally(rawResult, resultHandler, barcode);
//                }
//                break;
//        }
    }

    private void openScanTip(Result rawResult, Bitmap barcode) {
        Bundle bundle = new Bundle();
        bundle.putString("result_text", rawResult.getText());
        openActivity(ScanTipActivity.class, bundle);
    }

    /**
     * Superimpose a line for 1D or dots for 2D to highlight the key features of the barcode.
     *
     * @param barcode     A bitmap of the captured image.
     * @param scaleFactor amount by which thumbnail was scaled
     * @param rawResult   The decoded results which contains the points to draw.
     */
    private void drawResultPoints(Bitmap barcode, float scaleFactor, Result rawResult) {
        ResultPoint[] points = rawResult.getResultPoints();
        if (points != null && points.length > 0) {
            Canvas canvas = new Canvas(barcode);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.result_points));
            if (points.length == 2) {
                paint.setStrokeWidth(4.0f);
                drawLine(canvas, paint, points[0], points[1], scaleFactor);
            } else if (points.length == 4 &&
                    (rawResult.getBarcodeFormat() == BarcodeFormat.UPC_A ||
                            rawResult.getBarcodeFormat() == BarcodeFormat.EAN_13)) {
                // Hacky special case -- draw two lines, for the barcode and metadata
                drawLine(canvas, paint, points[0], points[1], scaleFactor);
                drawLine(canvas, paint, points[2], points[3], scaleFactor);
            } else {
                paint.setStrokeWidth(10.0f);
                for (ResultPoint point : points) {
                    if (point != null) {
                        canvas.drawPoint(scaleFactor * point.getX(), scaleFactor * point.getY(), paint);
                    }
                }
            }
        }
    }

    private static void drawLine(Canvas canvas, Paint paint, ResultPoint a, ResultPoint b, float scaleFactor) {
        if (a != null && b != null) {
            canvas.drawLine(scaleFactor * a.getX(),
                    scaleFactor * a.getY(),
                    scaleFactor * b.getX(),
                    scaleFactor * b.getY(),
                    paint);
        }
    }

    private void displayFrameworkBugMessageAndExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.msg_camera_framework_bug));
        builder.setPositiveButton(R.string.button_ok, new FinishListener(this));
        builder.setOnCancelListener(new FinishListener(this));
        builder.show();
    }

    private int getCurrentOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            switch (rotation) {
                case Surface.ROTATION_0:
                case Surface.ROTATION_90:
                    return ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                default:
                    return ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            }
        } else {
            switch (rotation) {
                case Surface.ROTATION_0:
                case Surface.ROTATION_270:
                    return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                default:
                    return ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (holder == null) {
            Log.e(TAG, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!hasSurface) {
            hasSurface = true;
            initCamera(holder);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        hasSurface = false;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // do nothing
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
//                if (source == IntentSource.NATIVE_APP_INTENT) {
//                    setResult(RESULT_CANCELED);
//                    finish();
//                    return true;
//                }
//                if ((source == IntentSource.NONE || source == IntentSource.ZXING_LINK) && lastResult != null) {
//                    restartPreviewAfterDelay(0L);
//                    return true;
//                }
                if (lastResult != null) {
                    restartPreviewAfterDelay(0L);
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_FOCUS:
            case KeyEvent.KEYCODE_CAMERA:
                // Handle these events so they don't launch the Camera app
                return true;
            // Use volume up/down to turn on light
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                cameraManager.setTorch(false);
                return true;
            case KeyEvent.KEYCODE_VOLUME_UP:
                cameraManager.setTorch(true);
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void resetStatusView() {
        viewfinderView.setVisibility(View.VISIBLE);
        lastResult = null;
    }

    public void restartPreviewAfterDelay(long delayMS) {
        if (handler != null) {
            handler.sendEmptyMessageDelayed(R.id.restart_preview, delayMS);
        }
        resetStatusView();
    }

    //add because fix bug
    private class MyOrientationDetector extends OrientationEventListener {

        private int lastOrientation = -1;

        MyOrientationDetector(Context context) {
            super(context);
        }

        void setLastOrientation(int rotation) {
            switch (rotation) {
                case Surface.ROTATION_90:
                    lastOrientation = 270;
                    break;
                case Surface.ROTATION_270:
                    lastOrientation = 90;
                    break;
                default:
                    lastOrientation = -1;
            }
        }

        @Override
        public void onOrientationChanged(int orientation) {
            Log.d(TAG, "orientation:" + orientation);
            if (orientation > 45 && orientation < 135) {
                orientation = 90;
            } else if (orientation > 225 && orientation < 315) {
                orientation = 270;
            } else {
                orientation = -1;
            }
            if ((orientation == 90 && lastOrientation == 270) || (orientation == 270 && lastOrientation == 90)) {
                Log.i(TAG, "orientation:" + orientation + "lastOrientation:" + lastOrientation);
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                lastOrientation = orientation;
                Log.i(TAG, "SUCCESS");
            }
        }
    }
}
