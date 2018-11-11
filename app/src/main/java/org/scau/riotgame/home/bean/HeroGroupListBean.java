package org.scau.riotgame.home.bean;

/**
 * Created by ZP on 2018/11/11.
 */
public class HeroGroupListBean {

    private News mNews;

    private String type;

    public HeroGroupListBean(News news, String type) {
        mNews = news;
        this.type = type;
    }

    public News getNews() {
        return mNews;
    }

    public void setNews(News news) {
        mNews = news;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
