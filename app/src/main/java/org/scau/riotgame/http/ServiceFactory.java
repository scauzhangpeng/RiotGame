package org.scau.riotgame.http;

/**
 * Created by ZP on 2016/11/16.
 */


import android.os.Handler;

import org.scau.riotgame.RiotGameApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class ServiceFactory {
    private static Handler mHandler = new Handler();

    public static <T> T createServiceFrom(Class<T> serviceClass, String endpoint) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                //.addConverterFactory(ScalarsConverterFactory.create())
                .client(getLogClient())
                .build();
        return retrofit.create(serviceClass);
    }


    public static OkHttpClient getLogClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        File cacheFile = new File(RiotGameApplication.getContext().getExternalCacheDir(), "HttpCache");
        System.out.println("path:" + RiotGameApplication.getContext().getExternalCacheDir());
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 10);//缓存文件为10MB
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
}

