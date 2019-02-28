package com.muugi.riot.news.model;


import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.adapter.rxjava2.HttpException;

/**
 * Created by ZP on 2019/2/24.
 */
public abstract class RequestCallback<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            onException(String.valueOf(((HttpException)e).code()), "网络异常", e);
        } else if (e instanceof SocketTimeoutException){
            onException("600", "网络连接超时", e);
        } else {
            onException("-1", e.getMessage(), e);
        }
    }

    abstract void onException(String code, String message, Throwable e);
}
