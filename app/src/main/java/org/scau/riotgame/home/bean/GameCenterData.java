package org.scau.riotgame.home.bean;

import java.util.List;

/**
 * Created by ZP on 2017/9/1.
 */

public class GameCenterData {

    private int result;

    private List<Feature> normal_features;

    private List<Feature> gallery_features;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<Feature> getNormal_features() {
        return normal_features;
    }

    public void setNormal_features(List<Feature> normal_features) {
        this.normal_features = normal_features;
    }

    public List<Feature> getGallery_features() {
        return gallery_features;
    }

    public void setGallery_features(List<Feature> gallery_features) {
        this.gallery_features = gallery_features;
    }
}
