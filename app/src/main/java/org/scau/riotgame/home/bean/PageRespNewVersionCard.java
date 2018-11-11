package org.scau.riotgame.home.bean;

import java.util.List;

/**
 * Created by ZP on 2018/11/11.
 */
public class PageRespNewVersionCard {
    private String msg;
    private int code;

    private List<NewVersionCardItem> list;

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

    public List<NewVersionCardItem> getList() {
        return list;
    }

    public void setList(List<NewVersionCardItem> list) {
        this.list = list;
    }
}
