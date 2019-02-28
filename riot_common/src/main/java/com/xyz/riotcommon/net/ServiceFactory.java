package com.xyz.riotcommon.net;

/**
 * Created by ZP on 2016/11/16.
 */


import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import com.xyz.basiclib.BaseApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 *
 */
public class ServiceFactory {
    private static final String TAG = "ServiceFactory";
    private static Handler mHandler = new Handler();

    public static <T> T createServiceFrom(Class<T> serviceClass, String endpoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLogClient())
                .build();
        return retrofit.create(serviceClass);
    }

    public static <T> T createServiceRxJava(Class<T> serviceClass, String endpoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLogClient())
                .build();
        return retrofit.create(serviceClass);
    }

    public static <T> T createServiceFrom(Class<T> serviceClass, String endpoint, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                //.addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(serviceClass);
    }

    public static OkHttpClient getLogClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        File cacheDir = getDiskCacheDir(BaseApplication.getContext(), "http");
        Cache cache = new Cache(cacheDir, 1024 * 1024 * 10);//缓存文件为10MB
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(getHttpLoggingInterceptor())
                .cache(cache)
                .addInterceptor(new CacheInterceptor())
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new QueryParameterInterceptor())
                //.addInterceptor(new LoggingInterceptor())
//                .addNetworkInterceptor(new StethoInterceptor())
//                .addInterceptor(new CommonInterceptor())
                .readTimeout(45, TimeUnit.SECONDS)
                .writeTimeout(45, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        return okHttpClient;
    }

    public static OkHttpClient getDownloadClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .build();

        return okHttpClient;
    }

    public static File getDiskCacheDir(Context context, String uniqueName) {
        File cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir();
        } else {
            cachePath = context.getCacheDir();
        }
        Log.d(TAG, "getDiskCacheDir: " + cachePath);
        return new File(cachePath, uniqueName);
    }
}

