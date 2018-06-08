package com.xyz.basiclib.mvp;

/**
 * Created by ZP on 2017/8/16.
 */

public interface BaseView {

    void showToastLong(String msg);

    void showToastShort(String msg);

    void showEmptyPage(String msg);

    void showErrorPage(String msg);
}
