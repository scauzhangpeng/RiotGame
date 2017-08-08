package org.scau.riotgame.http;

import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ZP on 2016/5/30.
 * 拦截器--日志打印
 */
public class LoggingInterceptor implements Interceptor {

    private static final String TAG = "Interceptor";
    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();
        Log.i(TAG, "{");
        Log.i(TAG, String.format("Sending request %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        //        Log.i("interceptors",String.format("Received response for %s in %.1fms%n%s",
        //                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        Log.i(TAG, String.format("Received response for %s in %.1fms%n%s",
                response.request().url(), (t2 - t1) / 1e6d, ""));

        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        int code = response.code();
        String message = response.message();
        Log.i(TAG, "http code:" + code);//网络请求响应状态码
        Log.i(TAG, "http body:" + content);//网络请求响应内容
        Log.i(TAG, "http message:" + message);//网络请求响应信息
        Log.i(TAG, "cache:" + response.cacheControl());
        Log.i(TAG, "}");


        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }

}
