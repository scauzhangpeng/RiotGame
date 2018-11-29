package org.scau.riotgame.home.bean;

import java.util.List;

/**
 * Created by ZP on 2018/11/11.
 */
public class NewVersionCardItem {

    private List<NewVersionCard> cardlist;
    /**
     * intent : qtpage://newver_the_ver_main?version_key=20181025&default_tab_id=274&newver_user_type=normal
     * newstype : 新版本英雄
     * change_hero_num_desc : 8个
     * col_id :
     * version_key : 20181025
     * newstypeid : newverhero
     * endtime :
     * card_id : 4
     * position : 1
     * actnews_id :
     * shortv_type :
     * change_hero_desc : 已拥有的英雄有改动
     * change_hero_ver : 8.21版本改动：
     * article_id : card4
     * begintime : 2017-06-13 17:34:52
     * version_name : 8.21
     */

    private String intent;
    private String newstype;
    private String change_hero_num_desc;
    private String col_id;
    private String version_key;
    private String newstypeid;
    private String endtime;
    private String card_id;
    private String position;
    private String actnews_id;
    private String shortv_type;
    private String change_hero_desc;
    private String change_hero_ver;
    private String article_id;
    private String begintime;
    private String version_name;
    /**
     * change_skin_ver : 8.23版本皮肤：
     * change_skin_num_desc : 11个
     * change_skin_desc : 新皮肤
     */

    private String change_skin_ver;
    private String change_skin_num_desc;
    private String change_skin_desc;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    public String getChange_hero_num_desc() {
        return change_hero_num_desc;
    }

    public void setChange_hero_num_desc(String change_hero_num_desc) {
        this.change_hero_num_desc = change_hero_num_desc;
    }

    public String getCol_id() {
        return col_id;
    }

    public void setCol_id(String col_id) {
        this.col_id = col_id;
    }

    public String getVersion_key() {
        return version_key;
    }

    public void setVersion_key(String version_key) {
        this.version_key = version_key;
    }

    public String getNewstypeid() {
        return newstypeid;
    }

    public void setNewstypeid(String newstypeid) {
        this.newstypeid = newstypeid;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getActnews_id() {
        return actnews_id;
    }

    public void setActnews_id(String actnews_id) {
        this.actnews_id = actnews_id;
    }

    public String getShortv_type() {
        return shortv_type;
    }

    public void setShortv_type(String shortv_type) {
        this.shortv_type = shortv_type;
    }

    public String getChange_hero_desc() {
        return change_hero_desc;
    }

    public void setChange_hero_desc(String change_hero_desc) {
        this.change_hero_desc = change_hero_desc;
    }

    public String getChange_hero_ver() {
        return change_hero_ver;
    }

    public void setChange_hero_ver(String change_hero_ver) {
        this.change_hero_ver = change_hero_ver;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public List<NewVersionCard> getCardlist() {
        return cardlist;
    }

    public void setCardlist(List<NewVersionCard> cardlist) {
        this.cardlist = cardlist;
    }

    public String getChange_skin_ver() {
        return change_skin_ver;
    }

    public void setChange_skin_ver(String change_skin_ver) {
        this.change_skin_ver = change_skin_ver;
    }

    public String getChange_skin_num_desc() {
        return change_skin_num_desc;
    }

    public void setChange_skin_num_desc(String change_skin_num_desc) {
        this.change_skin_num_desc = change_skin_num_desc;
    }

    public String getChange_skin_desc() {
        return change_skin_desc;
    }

    public void setChange_skin_desc(String change_skin_desc) {
        this.change_skin_desc = change_skin_desc;
    }
}
