package com.muugi.riot.news.bean;

import java.util.List;

/**
 * Created by ZP on 2017/9/8.
 */

public class CardItem {

    /**
     * newstypeid : RecentHeroCard
     * data : []
     * position : 1
     * article_id :
     * article_url :
     * intent : qtpage://hero_main?tab=1
     * hero_name : 丽桑卓
     */

    private String newstypeid;
    private String position;
    private String article_id;
    private String article_url;
    private String intent;
    private String hero_name;
    private List<Card> data;

    public String getNewstypeid() {
        return newstypeid;
    }

    public void setNewstypeid(String newstypeid) {
        this.newstypeid = newstypeid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getHero_name() {
        return hero_name;
    }

    public void setHero_name(String hero_name) {
        this.hero_name = hero_name;
    }

    public List<Card> getData() {
        return data;
    }

    public void setData(List<Card> data) {
        this.data = data;
    }
}
