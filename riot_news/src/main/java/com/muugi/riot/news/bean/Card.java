package com.muugi.riot.news.bean;

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


    /**
     * 玩家英雄秀
     * user_id : 147589ff-5b11-488c-b2ef-e225f5238019
     * content : 找个霞一起灵活组排
     * has_pic : False
     * has_video : False
     * praise_num : 0
     * comment_num : 2
     * is_hot :
     * game_nick : 坏威威仔
     * logo_url : http://p.qlogo.cn/qtl_user/3708aae54ba76aeaaae167c5be920dd915a6497353cdb03c136aa1073db0f9a0/120
     * rank : 黄金V
     */

    private String user_id;
    private String content;
    private String has_pic;
    private String has_video;
    private String praise_num;
    private String comment_num;
    private String is_hot;
    private String game_nick;
    private String logo_url;
    private String rank;
    /**
     * 英雄推荐
     * hero_name : 维克托
     * hero_nick : 机械先驱
     * ranking : 4
     * ranking_mode : 国服胜率
     * ranking_change : 1
     */

    private String hero_name;
    private String hero_nick;
    private String ranking;
    private String ranking_mode;
    private String ranking_change;
    /**
     * 推荐攻略
     * article_id : 30845
     * content_id : 30845
     * newstypeid : ordinary
     * channel_desc :
     * channel_id : <2>:<10>,<2>:<11>,<2>:<11>:<113>,<2>:<12>
     * insert_date : 2017-04-28 10:55:15
     * summary : 虐狗新套路！新英雄逆羽霞登场！
     * score : 3
     * targetid : 1901264849
     * is_act : 0
     * is_subject : 0
     * is_new : 0
     * is_top : False
     * image_spec : 1
     * is_report : True
     * is_direct : False
     * image_url_big : http://ossweb-img.qq.com/upload/qqtalk/news/201704/281055155146229_480.jpg
     * image_url_bigop : http://ossweb-img.qq.com/upload/qqtalk/news/201704/281055155146229_686.jpg
     * image_url_banner :
     * image_url_act :
     * bmatchid : 0
     * pics_id : 0
     * is_purchase : 0
     * commentid :
     * actnews_enddate :
     * actnews_reward :
     * doc_id :
     * author : MISS
     */

    private String article_id;
    private String content_id;
    private String newstypeid;
    private String channel_desc;
    private String channel_id;
    private String insert_date;
    private String summary;
    private String score;
    private String targetid;
    private String is_act;
    private String is_subject;
    private String is_new;
    private String is_top;
    private String image_spec;
    private String is_report;
    private String is_direct;
    private String image_url_big;
    private String image_url_bigop;
    private String image_url_banner;
    private String image_url_act;
    private String bmatchid;
    private String pics_id;
    private String is_purchase;
    private String commentid;
    private String actnews_enddate;
    private String actnews_reward;
    private String doc_id;
    private String author;


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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHas_pic() {
        return has_pic;
    }

    public void setHas_pic(String has_pic) {
        this.has_pic = has_pic;
    }

    public String getHas_video() {
        return has_video;
    }

    public void setHas_video(String has_video) {
        this.has_video = has_video;
    }

    public String getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(String praise_num) {
        this.praise_num = praise_num;
    }

    public String getComment_num() {
        return comment_num;
    }

    public void setComment_num(String comment_num) {
        this.comment_num = comment_num;
    }

    public String getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(String is_hot) {
        this.is_hot = is_hot;
    }

    public String getGame_nick() {
        return game_nick;
    }

    public void setGame_nick(String game_nick) {
        this.game_nick = game_nick;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getNewstypeid() {
        return newstypeid;
    }

    public void setNewstypeid(String newstypeid) {
        this.newstypeid = newstypeid;
    }

    public String getChannel_desc() {
        return channel_desc;
    }

    public void setChannel_desc(String channel_desc) {
        this.channel_desc = channel_desc;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(String insert_date) {
        this.insert_date = insert_date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTargetid() {
        return targetid;
    }

    public void setTargetid(String targetid) {
        this.targetid = targetid;
    }

    public String getIs_act() {
        return is_act;
    }

    public void setIs_act(String is_act) {
        this.is_act = is_act;
    }

    public String getIs_subject() {
        return is_subject;
    }

    public void setIs_subject(String is_subject) {
        this.is_subject = is_subject;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getIs_top() {
        return is_top;
    }

    public void setIs_top(String is_top) {
        this.is_top = is_top;
    }

    public String getImage_spec() {
        return image_spec;
    }

    public void setImage_spec(String image_spec) {
        this.image_spec = image_spec;
    }

    public String getIs_report() {
        return is_report;
    }

    public void setIs_report(String is_report) {
        this.is_report = is_report;
    }

    public String getIs_direct() {
        return is_direct;
    }

    public void setIs_direct(String is_direct) {
        this.is_direct = is_direct;
    }

    public String getImage_url_big() {
        return image_url_big;
    }

    public void setImage_url_big(String image_url_big) {
        this.image_url_big = image_url_big;
    }

    public String getImage_url_bigop() {
        return image_url_bigop;
    }

    public void setImage_url_bigop(String image_url_bigop) {
        this.image_url_bigop = image_url_bigop;
    }

    public String getImage_url_banner() {
        return image_url_banner;
    }

    public void setImage_url_banner(String image_url_banner) {
        this.image_url_banner = image_url_banner;
    }

    public String getImage_url_act() {
        return image_url_act;
    }

    public void setImage_url_act(String image_url_act) {
        this.image_url_act = image_url_act;
    }

    public String getBmatchid() {
        return bmatchid;
    }

    public void setBmatchid(String bmatchid) {
        this.bmatchid = bmatchid;
    }

    public String getPics_id() {
        return pics_id;
    }

    public void setPics_id(String pics_id) {
        this.pics_id = pics_id;
    }

    public String getIs_purchase() {
        return is_purchase;
    }

    public void setIs_purchase(String is_purchase) {
        this.is_purchase = is_purchase;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getActnews_enddate() {
        return actnews_enddate;
    }

    public void setActnews_enddate(String actnews_enddate) {
        this.actnews_enddate = actnews_enddate;
    }

    public String getActnews_reward() {
        return actnews_reward;
    }

    public void setActnews_reward(String actnews_reward) {
        this.actnews_reward = actnews_reward;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
