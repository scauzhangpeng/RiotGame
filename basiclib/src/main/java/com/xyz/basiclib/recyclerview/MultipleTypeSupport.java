package com.xyz.basiclib.recyclerview;

/**
 * Created by ZP on 2017/8/8.
 */

public interface MultipleTypeSupport<T> {

    int getLayoutId(T t, int position);
}
