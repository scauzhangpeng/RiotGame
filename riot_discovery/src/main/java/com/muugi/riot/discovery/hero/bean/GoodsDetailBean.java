package com.muugi.riot.discovery.hero.bean;

import java.util.List;

/**
 * Created by ZP on 2018/2/26.
 */

public class GoodsDetailBean {


    /**
     * canproducelist : ["3004","3172","3031","3124","3008","3184","3181","3812","3139","3074"]
     * greatguide :
     * name : 十字镐
     * good_id : 1037
     * price : 875
     * produceneedlist : [""]
     * last_modify_date : 2017-02-28 11:06:53
     * suithero : ["29","236","11","21","121","92","91","23","67","81","119","104","42","133","110","96","22","18","126","114","157","6","429"]
     * othernames : [""]
     * maplist : ["召唤师峡谷","水晶之痕","扭曲丛林","嚎哭深渊"]
     * saleprice : 613
     * coprice : 0
     * proplist : ["伤害"]
     * active : true
     * good_desc : +25攻击力
     * id : 1220
     * insert_date : 2015-07-21 18:40:04
     */

    private String greatguide;
    private String name;
    private int good_id;
    private String price;
    private String last_modify_date;
    private String saleprice;
    private String coprice;
    private boolean active;
    private String good_desc;
    private int id;
    private String insert_date;
    private List<String> canproducelist;
    private List<String> produceneedlist;
    private List<String> suithero;
    private List<String> othernames;
    private List<String> maplist;
    private List<String> proplist;

    public String getGreatguide() {
        return greatguide;
    }

    public void setGreatguide(String greatguide) {
        this.greatguide = greatguide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLast_modify_date() {
        return last_modify_date;
    }

    public void setLast_modify_date(String last_modify_date) {
        this.last_modify_date = last_modify_date;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getCoprice() {
        return coprice;
    }

    public void setCoprice(String coprice) {
        this.coprice = coprice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getGood_desc() {
        return good_desc;
    }

    public void setGood_desc(String good_desc) {
        this.good_desc = good_desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(String insert_date) {
        this.insert_date = insert_date;
    }

    public List<String> getCanproducelist() {
        return canproducelist;
    }

    public void setCanproducelist(List<String> canproducelist) {
        this.canproducelist = canproducelist;
    }

    public List<String> getProduceneedlist() {
        return produceneedlist;
    }

    public void setProduceneedlist(List<String> produceneedlist) {
        this.produceneedlist = produceneedlist;
    }

    public List<String> getSuithero() {
        return suithero;
    }

    public void setSuithero(List<String> suithero) {
        this.suithero = suithero;
    }

    public List<String> getOthernames() {
        return othernames;
    }

    public void setOthernames(List<String> othernames) {
        this.othernames = othernames;
    }

    public List<String> getMaplist() {
        return maplist;
    }

    public void setMaplist(List<String> maplist) {
        this.maplist = maplist;
    }

    public List<String> getProplist() {
        return proplist;
    }

    public void setProplist(List<String> proplist) {
        this.proplist = proplist;
    }
}
