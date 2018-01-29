package org.scau.riotgame.setting;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import org.scau.riotgame.R;
import org.scau.riotgame.http.DownloadManager;
import org.scau.riotgame.http.HttpCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by ZP on 2018/1/29.
 */

public class DownloadService extends Service {
    private static final String TAG = "DownloadService";

    private HandlerThread mHandlerThread;
    private Handler mHandler;


    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();
        mHandlerThread = new HandlerThread("download");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        startDownload();
        return super.onStartCommand(intent, flags, startId);
    }

    private void startDownload() {
        DownloadManager.getInstance().downloadApk("http://down.qq.com/qqtalk/lol_3498.apk", new HttpCallback<ResponseBody>() {
            @Override
            public void doOnSuccess(final Response<ResponseBody> response) {
                Log.d(TAG, "doOnSuccess: " + Thread.currentThread().getName());
                if (response.isSuccessful()) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            boolean downloadSuccess = writeResponseBodyToDisk(response.body());
                            if (downloadSuccess) {
                                //
                                Log.d(TAG, "run: 下载完成");
                                installApk(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "lol.apk"));
                            }
                        }
                    });
                } else {
                    Log.d(TAG, "doOnSuccess: " + response.code());
                }
            }

            @Override
            public void doOnError(Response<ResponseBody> response, String statusCode, String message) {
                Log.d(TAG, "doOnError: ");
            }

            @Override
            public void doOnFailure(int httpCode, String message) {
                Log.d(TAG, "doOnFailure: ");
            }
        });
    }

    private boolean writeResponseBodyToDisk(ResponseBody body) {
        Log.d(TAG, "writeResponseBodyToDisk: ");
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "lol.apk");
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];
                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;
                inputStream = body.byteStream();
                outputStream = new FileOutputStream(file);
                while (true) {
                    int read = inputStream.read(fileReader);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                    Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize);
                    showNotification(fileSizeDownloaded, fileSize);
                }
                outputStream.flush();
                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    private void showNotification(long fileSizeDownloaded, long fileSize) {
        Log.d(TAG, "showNotification: " + Thread.currentThread().getName());
        int progress = (int) (fileSizeDownloaded * 1.0 / fileSize * 100);
        Log.d(TAG, "showNotification: " + progress);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("下载")
                .setContentText(progress + "/100")
                .setProgress(100, progress, false)
                .build();

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(1000, notification);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        if (mHandlerThread != null) {
            mHandlerThread.quit();
        }
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void installApk(File file) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
