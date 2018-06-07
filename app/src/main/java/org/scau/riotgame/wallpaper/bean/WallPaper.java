package org.scau.riotgame.wallpaper.bean;

import java.util.List;

/**
 * Created by ZP on 2018/6/6.
 */

public class WallPaper extends WallPaperResponse {

    private List<WallPaperDetail> wallpapers;

    public List<WallPaperDetail> getWallpapers() {
        return wallpapers;
    }

    public void setWallpapers(List<WallPaperDetail> wallpapers) {
        this.wallpapers = wallpapers;
    }
}
