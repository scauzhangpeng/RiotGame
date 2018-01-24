package org.scau.riotgame.home.bean;

/**
 * Created by ZP on 2017/9/8.
 */

public class CardRecentHero {


    /**
     * hero_id : 127
     * use_times : 33场
     * win_rate : 40%
     * achievement_num : 22658点
     * achievement_name : 织法之杖
     * intent : qtpage://hero_detail?hero=127®ion=7&tab=2
     * article_url :
     * color : 0x385db6,0x248eac,0xa5248eac
     */

    private String hero_id;
    private String use_times;
    private String win_rate;
    private String achievement_num;
    private String achievement_name;
    private String intent;
    private String article_url;
    private String color;

    public String getHero_id() {
        return hero_id;
    }

    public void setHero_id(String hero_id) {
        this.hero_id = hero_id;
    }

    public String getUse_times() {
        return use_times;
    }

    public void setUse_times(String use_times) {
        this.use_times = use_times;
    }

    public String getWin_rate() {
        return win_rate;
    }

    public void setWin_rate(String win_rate) {
        this.win_rate = win_rate;
    }

    public String getAchievement_num() {
        return achievement_num;
    }

    public void setAchievement_num(String achievement_num) {
        this.achievement_num = achievement_num;
    }

    public String getAchievement_name() {
        return achievement_name;
    }

    public void setAchievement_name(String achievement_name) {
        this.achievement_name = achievement_name;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
