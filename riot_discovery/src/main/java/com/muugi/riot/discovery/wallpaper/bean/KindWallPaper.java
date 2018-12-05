package com.muugi.riot.discovery.wallpaper.bean;

import java.util.List;

/**
 * Created by ZP on 2018/6/6.
 */

public class KindWallPaper extends WallPaperResponse {
    private List<WallPaperDetail> categories;

    public List<WallPaperDetail> getCategories() {
        return categories;
    }

    public void setCategories(List<WallPaperDetail> categories) {
        this.categories = categories;
    }
}
