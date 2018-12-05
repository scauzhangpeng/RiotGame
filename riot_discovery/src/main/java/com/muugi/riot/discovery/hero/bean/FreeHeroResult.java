package com.muugi.riot.discovery.hero.bean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ZP on 2018/8/6.
 */

public class FreeHeroResult {

    private HashMap<String, String> keys;
    private HashMap<String, FreeHeroInner> data;

    private List<String> date;
    private String version;
    private String updated;


    public HashMap<String, String> getKeys() {
        return keys;
    }

    public void setKeys(HashMap<String, String> keys) {
        this.keys = keys;
    }

    public HashMap<String, FreeHeroInner> getData() {
        return data;
    }

    public void setData(HashMap<String, FreeHeroInner> data) {
        this.data = data;
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
