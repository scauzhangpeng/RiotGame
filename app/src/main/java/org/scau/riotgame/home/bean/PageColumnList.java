package org.scau.riotgame.home.bean;

import java.util.List;

/**
 * Created by ZP on 2017/8/23.
 */

public class PageColumnList {


    /**
     * msg : ok
     * code : 0
     * unbook_list : []
     * recommend_list : []
     * book_list : []
     * hasnext : 1
     */

    private String msg;
    private int code;
    private String hasnext;
    private List<ColumnList> unbook_list;
    private List<ColumnList> recommend_list;
    private List<ColumnList> book_list;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getHasnext() {
        return hasnext;
    }

    public void setHasnext(String hasnext) {
        this.hasnext = hasnext;
    }

    public List<ColumnList> getUnbook_list() {
        return unbook_list;
    }

    public void setUnbook_list(List<ColumnList> unbook_list) {
        this.unbook_list = unbook_list;
    }

    public List<ColumnList> getRecommend_list() {
        return recommend_list;
    }

    public void setRecommend_list(List<ColumnList> recommend_list) {
        this.recommend_list = recommend_list;
    }

    public List<ColumnList> getBook_list() {
        return book_list;
    }

    public void setBook_list(List<ColumnList> book_list) {
        this.book_list = book_list;
    }
}
