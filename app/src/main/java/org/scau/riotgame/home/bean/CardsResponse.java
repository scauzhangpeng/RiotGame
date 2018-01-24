package org.scau.riotgame.home.bean;

import java.util.List;

/**
 * Created by ZP on 2017/9/8.
 */

public class CardsResponse {

    private String code;

    private List<CardItem> list;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CardItem> getList() {
        return list;
    }

    public void setList(List<CardItem> list) {
        this.list = list;
    }
}
