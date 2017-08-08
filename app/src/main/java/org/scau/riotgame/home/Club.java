package org.scau.riotgame.home;

import java.util.List;

/**
 * Created by ZP on 2017/8/2.
 */

public class Club {


    /**
     * result : 0
     * clubs : [{"id":"9","name":"WE","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_9.png?3663","fansCount":2480328,"clubvote":78585,"trendTopicId":"267","fansTopicId":"9","adminUin":"","allowurl":0,"tab":"Post","sh_id":"12","adminUuid":"8ef1e2dc-4054-4a73-8bd5-de9579d6d927"},{"id":"7","name":"OMG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_7.png?3770","fansCount":3169572,"clubvote":112291,"trendTopicId":"262","fansTopicId":"7","adminUin":"","allowurl":0,"tab":"Post","sh_id":"6","adminUuid":"97abd23b-efd2-4922-8055-bea5bbc1bedd"},{"id":"13","name":"EDG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_13.png?3736","fansCount":5785534,"clubvote":723691,"trendTopicId":"261","fansTopicId":"13","adminUin":"","allowurl":0,"tab":"Post","sh_id":"1","adminUuid":"11819949-064a-48c4-9f62-4056c1511b8a"},{"id":"245","name":"DAN","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_245.png?8236","fansCount":21292,"clubvote":51,"trendTopicId":"277","fansTopicId":"245","adminUin":"","allowurl":0,"tab":"Post","sh_id":"42","adminUuid":"91c458ac-a973-4f28-a81e-4c25c2fd6db7"},{"id":"244","name":"SNG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_244.png?8242","fansCount":10109,"clubvote":61,"trendTopicId":"278","fansTopicId":"244","adminUin":"","allowurl":0,"tab":"Post","sh_id":"41","adminUuid":"2c4c5f57-00bd-453b-9ebf-9cd81289db7f"},{"id":"103","name":"RNG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_103.png?3690","fansCount":3362135,"clubvote":46177,"trendTopicId":"266","fansTopicId":"103","adminUin":"","allowurl":0,"tab":"Post","sh_id":"8","adminUuid":"f472f933-28e3-4eae-b691-310927d8d1ad"},{"id":"6","name":"IG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_6.png?0900","fansCount":2015526,"clubvote":31098,"trendTopicId":"260","fansTopicId":"6","adminUin":"","allowurl":0,"tab":"Post","sh_id":"2","adminUuid":"4d591293-e616-4073-a5d8-5e03105ea9dd"},{"id":"10","name":"LGD","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_10.png?9433","fansCount":2469665,"clubvote":74305,"trendTopicId":"259","fansTopicId":"10","adminUin":"","allowurl":0,"tab":"Post","sh_id":"4","adminUuid":"78b50568-2aac-4320-bb7d-5b5f52368645"},{"id":"43","name":"Snake","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_43.png?9457","fansCount":2032494,"clubvote":68540,"trendTopicId":"268","fansTopicId":"43","adminUin":"","allowurl":0,"tab":"Post","sh_id":"9","adminUuid":"c7adb2cb-d7ba-437a-a8c1-f7995c855222"},{"id":"41","name":"Newbee","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_41.png?5476","fansCount":2077775,"clubvote":51094,"trendTopicId":"264","fansTopicId":"41","adminUin":"","allowurl":0,"tab":"Post","sh_id":"7","adminUuid":"8d48ca9f-793e-4d26-89dd-3eb658198620"},{"id":"202","name":"IM","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_202.png?0970","fansCount":204312,"clubvote":550,"trendTopicId":"275","fansTopicId":"202","adminUin":"","allowurl":0,"tab":"Post","sh_id":"57","adminUuid":"e5b59056-41dc-4abc-9cc9-d3f138119bb9"},{"id":"230","name":"JDG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_230.png?5689","fansCount":54295,"clubvote":155,"trendTopicId":"276","fansTopicId":"230","adminUin":"","allowurl":0,"tab":"Post","sh_id":"29","adminUuid":"b8696c86-97e9-431e-bc04-e37753df052d"},{"id":"44","name":"VG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_44.png?7479","fansCount":1790201,"clubvote":12950,"trendTopicId":"263","fansTopicId":"44","adminUin":"","allowurl":0,"tab":"Post","sh_id":"11","adminUuid":"6ae65dfc-f9a3-4ad8-be96-f5be325749e3"}]
     * topics : []
     */

    private int result;
    private List<ClubsBean> clubs;
    private List<?> topics;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<ClubsBean> getClubs() {
        return clubs;
    }

    public void setClubs(List<ClubsBean> clubs) {
        this.clubs = clubs;
    }

    public List<?> getTopics() {
        return topics;
    }

    public void setTopics(List<?> topics) {
        this.topics = topics;
    }

    public static class ClubsBean {
        /**
         * id : 9
         * name : WE
         * iconUrl : http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_9.png?3663
         * fansCount : 2480328
         * clubvote : 78585
         * trendTopicId : 267
         * fansTopicId : 9
         * adminUin :
         * allowurl : 0
         * tab : Post
         * sh_id : 12
         * adminUuid : 8ef1e2dc-4054-4a73-8bd5-de9579d6d927
         */

        private String id;
        private String name;
        private String iconUrl;
        private int fansCount;
        private int clubvote;
        private String trendTopicId;
        private String fansTopicId;
        private String adminUin;
        private int allowurl;
        private String tab;
        private String sh_id;
        private String adminUuid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getClubvote() {
            return clubvote;
        }

        public void setClubvote(int clubvote) {
            this.clubvote = clubvote;
        }

        public String getTrendTopicId() {
            return trendTopicId;
        }

        public void setTrendTopicId(String trendTopicId) {
            this.trendTopicId = trendTopicId;
        }

        public String getFansTopicId() {
            return fansTopicId;
        }

        public void setFansTopicId(String fansTopicId) {
            this.fansTopicId = fansTopicId;
        }

        public String getAdminUin() {
            return adminUin;
        }

        public void setAdminUin(String adminUin) {
            this.adminUin = adminUin;
        }

        public int getAllowurl() {
            return allowurl;
        }

        public void setAllowurl(int allowurl) {
            this.allowurl = allowurl;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }

        public String getSh_id() {
            return sh_id;
        }

        public void setSh_id(String sh_id) {
            this.sh_id = sh_id;
        }

        public String getAdminUuid() {
            return adminUuid;
        }

        public void setAdminUuid(String adminUuid) {
            this.adminUuid = adminUuid;
        }
    }
}
