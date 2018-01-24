package org.scau.riotgame.home.bean;

/**
 * Created by ZP on 2017/9/8.
 */

public class CardRecommendHero {


    /**
     * hero_id : 90
     * color : 0x6c519c,0xcc803a96,0xa5803a96
     * hero_name : 玛尔扎哈
     * hero_nick : 虚空先知
     * ranking : 2
     * ranking_mode : 国服胜率
     * ranking_change : 2
     * intent : qtpage://hero_detail?hero=90®ion=7&tab=3
     * win_rate : 559
     */

    private String hero_id;
    private String color;
    private String hero_name;
    private String hero_nick;
    private String ranking;
    private String ranking_mode;
    private String ranking_change;
    private String intent;
    private String win_rate;

    public String getHero_id() {
        return hero_id;
    }

    public void setHero_id(String hero_id) {
        this.hero_id = hero_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHero_name() {
        return hero_name;
    }

    public void setHero_name(String hero_name) {
        this.hero_name = hero_name;
    }

    public String getHero_nick() {
        return hero_nick;
    }

    public void setHero_nick(String hero_nick) {
        this.hero_nick = hero_nick;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getRanking_mode() {
        return ranking_mode;
    }

    public void setRanking_mode(String ranking_mode) {
        this.ranking_mode = ranking_mode;
    }

    public String getRanking_change() {
        return ranking_change;
    }

    public void setRanking_change(String ranking_change) {
        this.ranking_change = ranking_change;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getWin_rate() {
        return win_rate;
    }

    public void setWin_rate(String win_rate) {
        this.win_rate = win_rate;
    }
}
