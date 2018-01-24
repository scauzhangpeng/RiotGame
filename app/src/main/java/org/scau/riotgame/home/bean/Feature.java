package org.scau.riotgame.home.bean;

/**
 * Created by ZP on 2017/9/1.
 */

public class Feature {


    /**
     * iconUrl : http://ossweb-img.qq.com/upload/qqtalk/lol_hero/gc_252025079662119.png
     * intent : qtpage://match_subscribelist
     * name : 赛程订阅
     */

    private String iconUrl;
    private String intent;
    private String name;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
