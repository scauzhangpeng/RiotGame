package com.xyz.riotcommon;

import java.util.List;

/**
 * Created by ZP on 2019/2/18.
 */
public interface SimpleRefreshView<T> {
    void showListData(List<T> data);

    void showMoreListData(int currentPage, List<T> data);

    void setEnableLoadMore(boolean enableLoadMore);

    void setEnableRefresh(boolean enableRefresh);
}
