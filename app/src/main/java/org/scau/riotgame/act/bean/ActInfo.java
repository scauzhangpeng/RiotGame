package org.scau.riotgame.act.bean;

import java.util.List;

/**
 * Created by ZP on 2018/6/8.
 */

public class ActInfo {


    /**
     * code : 0
     * gallery : 366
     * act_list : ["47002","49398","51245","51258","51276"]
     * tablist : [{"name":"正在进行","url":"http://qt.qq.com/php_cgi/news/php/varcache_getactnews.php?t=open&lasttime="},{"name":"已结束","url":"http://qt.qq.com/php_cgi/news/php/varcache_getactnews.php?t=close&lasttime="}]
     * actnum : 5
     */

    private int code;
    private int gallery;
    private int actnum;
    private List<String> act_list;
    private List<TablistBean> tablist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getGallery() {
        return gallery;
    }

    public void setGallery(int gallery) {
        this.gallery = gallery;
    }

    public int getActnum() {
        return actnum;
    }

    public void setActnum(int actnum) {
        this.actnum = actnum;
    }

    public List<String> getAct_list() {
        return act_list;
    }

    public void setAct_list(List<String> act_list) {
        this.act_list = act_list;
    }

    public List<TablistBean> getTablist() {
        return tablist;
    }

    public void setTablist(List<TablistBean> tablist) {
        this.tablist = tablist;
    }

    public static class TablistBean {
        /**
         * name : 正在进行
         * url : http://qt.qq.com/php_cgi/news/php/varcache_getactnews.php?t=open&lasttime=
         */

        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
