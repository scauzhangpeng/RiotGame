package org.scau.riotgame.act.bean;

import java.util.List;

/**
 * Created by ZP on 2018/6/8.
 */

public class ActDetailResponse {

    private int this_page_num;
    private String now;
    private int actnum;
    private String lasttime;
    private String next;
    private List<ActDetail> list;

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<ActDetail> getList() {
        return list;
    }

    public void setList(List<ActDetail> list) {
        this.list = list;
    }

    public int getThis_page_num() {
        return this_page_num;
    }

    public void setThis_page_num(int this_page_num) {
        this.this_page_num = this_page_num;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public int getActnum() {
        return actnum;
    }

    public void setActnum(int actnum) {
        this.actnum = actnum;
    }
}
