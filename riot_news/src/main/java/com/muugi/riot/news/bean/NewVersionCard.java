package com.muugi.riot.news.bean;

/**
 * Created by ZP on 2018/11/11.
 */
public class NewVersionCard {


    /**
     * intent : qtpage://newver_the_ver_main?version_key=20181025&default_tab_id=276&selected_item_id=1859&newver_user_type=normal
     * hero_tag : 4
     * skin_pic_url : http://gpcd.gtimg.cn/upload/qqtalk/lol_newsver/201810/241744463262055.png
     * skin_pic_url_origin : http://gpcd.gtimg.cn/upload/qqtalk/lol_newsver/201810/241744463262055.png
     * hero_name : 伊芙琳
     * hero_nick : 痛苦之拥
     * color : 0x00000000,0x09879c
     * hero_id : 28
     * hero_head_img_url :
     */

    private String intent;
    private String skin_pic_url;
    private String skin_pic_url_origin;
    private String hero_name;
    private String hero_nick;
    private String color;
    private int hero_id;
    private String hero_head_img_url;
    /**
     * hero_bg_img_url : http://down.qq.com/qqtalk/lolApp/images/hero_background/Zoe_Splash_0.jpg
     * hero_desc : Q伤害提升
     * hero_tag : 已拥有
     */

    private String hero_bg_img_url;
    private String hero_desc;
    private String hero_tag;


    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }


    public String getSkin_pic_url() {
        return skin_pic_url;
    }

    public void setSkin_pic_url(String skin_pic_url) {
        this.skin_pic_url = skin_pic_url;
    }

    public String getSkin_pic_url_origin() {
        return skin_pic_url_origin;
    }

    public void setSkin_pic_url_origin(String skin_pic_url_origin) {
        this.skin_pic_url_origin = skin_pic_url_origin;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public String getHero_head_img_url() {
        return hero_head_img_url;
    }

    public void setHero_head_img_url(String hero_head_img_url) {
        this.hero_head_img_url = hero_head_img_url;
    }

    public String getHero_bg_img_url() {
        return hero_bg_img_url;
    }

    public void setHero_bg_img_url(String hero_bg_img_url) {
        this.hero_bg_img_url = hero_bg_img_url;
    }

    public String getHero_desc() {
        return hero_desc;
    }

    public void setHero_desc(String hero_desc) {
        this.hero_desc = hero_desc;
    }

    public String getHero_tag() {
        return hero_tag;
    }

    public void setHero_tag(String hero_tag) {
        this.hero_tag = hero_tag;
    }
}
