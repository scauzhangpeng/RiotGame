package org.scau.riotgame.home.bean;

import java.util.List;

/**
 * Created by ZP on 2018/11/11.
 */
public class WholeVideoData {

    private String total;
    private String totalpage;
    private String page;

    private List<HotMatch> result;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(String totalpage) {
        this.totalpage = totalpage;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<HotMatch> getResult() {
        return result;
    }

    public void setResult(List<HotMatch> result) {
        this.result = result;
    }
}
