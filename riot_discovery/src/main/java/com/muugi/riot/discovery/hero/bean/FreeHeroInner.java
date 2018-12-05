package com.muugi.riot.discovery.hero.bean;

import java.util.List;

/**
 * Created by ZP on 2018/8/6.
 */

public class FreeHeroInner {


    /**
     * id : Viktor
     * key : 112
     * name : 机械先驱
     * title : 维克托
     * tags : ["Mage"]
     * info : {"attack":2,"defense":4,"magic":10,"difficulty":9}
     * image : {"full":"Viktor.png","sprite":"champion4.png","group":"champion","x":288,"y":0,"w":48,"h":48}
     */

    private String id;
    private String key;
    private String name;
    private String title;
    private InfoBean info;
    private ImageBean image;
    private List<String> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public ImageBean getImage() {
        return image;
    }

    public void setImage(ImageBean image) {
        this.image = image;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public static class InfoBean {
        /**
         * attack : 2
         * defense : 4
         * magic : 10
         * difficulty : 9
         */

        private int attack;
        private int defense;
        private int magic;
        private int difficulty;

        public int getAttack() {
            return attack;
        }

        public void setAttack(int attack) {
            this.attack = attack;
        }

        public int getDefense() {
            return defense;
        }

        public void setDefense(int defense) {
            this.defense = defense;
        }

        public int getMagic() {
            return magic;
        }

        public void setMagic(int magic) {
            this.magic = magic;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(int difficulty) {
            this.difficulty = difficulty;
        }
    }

    public static class ImageBean {
        /**
         * full : Viktor.png
         * sprite : champion4.png
         * group : champion
         * x : 288
         * y : 0
         * w : 48
         * h : 48
         */

        private String full;
        private String sprite;
        private String group;
        private int x;
        private int y;
        private int w;
        private int h;

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getSprite() {
            return sprite;
        }

        public void setSprite(String sprite) {
            this.sprite = sprite;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }
    }
}
