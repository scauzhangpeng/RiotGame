package com.xyz.riotcommon.bean;

import java.util.List;

/**
 * Created by ZP on 2017/8/16.
 */

public class PageResponse<T> {


    /**
     * next : True
     * nextpage : 1
     * this_page_num : 20
     */
    private int code;
    private String msg;
    private String next;
    private String nextpage;
    private String this_page_num;
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getNextpage() {
        return nextpage;
    }

    public void setNextpage(String nextpage) {
        this.nextpage = nextpage;
    }

    public String getThis_page_num() {
        return this_page_num;
    }

    public void setThis_page_num(String this_page_num) {
        this.this_page_num = this_page_num;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
