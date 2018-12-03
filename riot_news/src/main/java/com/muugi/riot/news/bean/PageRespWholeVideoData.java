package com.muugi.riot.news.bean;

/**
 * Created by ZP on 2018/11/11.
 */
public class PageRespWholeVideoData {

    private String status;

    private WholeVideoData msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WholeVideoData getMsg() {
        return msg;
    }

    public void setMsg(WholeVideoData msg) {
        this.msg = msg;
    }
}
