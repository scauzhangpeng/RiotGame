package org.scau.riotgame.http;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ZP on 2016/11/23.
 */

public abstract class HttpCallback<T> implements Callback<T> {

    private static final String TAG = "HttpCallback";


    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.code() == 200) {//http响应成功
            T body = response.body();
            if (body != null) {
                doOnSuccess(body, response);
            } else {
                try {
                    doOnFailure(-1, response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                    doOnFailure(-1, e.getMessage());
                }
            }
        } else if ((response.code() + "").startsWith("5")) {
            doOnFailure(response.code(), "服务器异常!");
        } else {
            //http响应失败
            Log.i(TAG, "onFailure");
            try {
                doOnFailure(response.code(), response.errorBody().string());
            } catch (IOException e) {
                doOnFailure(response.code(), "数据转换出错");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.i(TAG, "onFailure");
        t.printStackTrace();
        if (!call.isCanceled()) {
            String failureMsg = t.getMessage();
            if (t instanceof InterruptedIOException) {
                failureMsg = "连接超时！";
            } else if (t instanceof UnknownServiceException) {
                failureMsg = "服务异常！";
            } else if (t instanceof UnknownHostException) {
                //            failureMsg = "服务器异常！";
                failureMsg = "服务器连接失败，请检查网络！";
            } else if (t instanceof ConnectException) {
                failureMsg = "服务器连接失败，请检查网络！";
            } else if (t instanceof SocketException) {
                failureMsg = "网络异常！";
            } else if (t instanceof JsonSyntaxException) {
                failureMsg = "数据转换出错！";
            }
            doOnFailure(0, failureMsg);
        }
    }


    public abstract void doOnSuccess(@NonNull T t, Response<T> response);

    public abstract void doOnError(Response<T> response, String statusCode, String message);

    public abstract void doOnFailure(int httpCode, String message);
}
