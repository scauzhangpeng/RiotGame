package org.scau.riotgame.home.bean;

/**
 * Created by ZP on 2017/9/8.
 */

public class Card {

    /**
     * 最近在玩
     */
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

    /**
     * 英雄时刻
     */
    /**
     * title : 冰霜女巫强势三杀，引爆全场
     * publication_date : 2017-09-01 00:54:13
     * pv : 260893
     * play_num : 260893
     * v_len : 01:51
     * image_with_btn : True
     * image_url_small : http://p.qpic.cn/qtlol/0/77bfdac0eb6cc1515b958716c1b9d14fT1504198447249656/
     * newstype : 强势三杀
     * vid : 02a1228e05c24ee5bee64963d45f8d50
     * article_url : http://ptlogin2.qq.com/qt_hero_h5player?ADTAG=video.hero.lolmobile&game_id=2103041&file_uuid=02a1228e05c24ee5bee64963d45f8d50&clientuin=$&clientkey=$&keyindex=19
     */

    private String title;
    private String publication_date;
    private String pv;
    private String play_num;
    private String v_len;
    private String image_with_btn;
    private String image_url_small;
    private String newstype;
    private String vid;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getPlay_num() {
        return play_num;
    }

    public void setPlay_num(String play_num) {
        this.play_num = play_num;
    }

    public String getV_len() {
        return v_len;
    }

    public void setV_len(String v_len) {
        this.v_len = v_len;
    }

    public String getImage_with_btn() {
        return image_with_btn;
    }

    public void setImage_with_btn(String image_with_btn) {
        this.image_with_btn = image_with_btn;
    }

    public String getImage_url_small() {
        return image_url_small;
    }

    public void setImage_url_small(String image_url_small) {
        this.image_url_small = image_url_small;
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }


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

    @Override
    public String toString() {
        return "Card{" +
                "hero_id='" + hero_id + '\'' +
                ", use_times='" + use_times + '\'' +
                ", win_rate='" + win_rate + '\'' +
                ", achievement_num='" + achievement_num + '\'' +
                ", achievement_name='" + achievement_name + '\'' +
                ", intent='" + intent + '\'' +
                ", article_url='" + article_url + '\'' +
                ", color='" + color + '\'' +
                ", title='" + title + '\'' +
                ", publication_date='" + publication_date + '\'' +
                ", pv='" + pv + '\'' +
                ", play_num='" + play_num + '\'' +
                ", v_len='" + v_len + '\'' +
                ", image_with_btn='" + image_with_btn + '\'' +
                ", image_url_small='" + image_url_small + '\'' +
                ", newstype='" + newstype + '\'' +
                ", vid='" + vid + '\'' +
                '}';
    }
}
