package org.scau.riotgame.home;

import org.scau.riotgame.home.bean.ColumnList;

/**
 * Created by ZP on 2018/11/9.
 */
public class ListColumnListWrapper {

    private ColumnList mColumnList;

    private int type;

    public ListColumnListWrapper(ColumnList columnList, int type) {
        mColumnList = columnList;
        this.type = type;
    }

    public ColumnList getColumnList() {
        return mColumnList;
    }

    public void setColumnList(ColumnList columnList) {
        mColumnList = columnList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
