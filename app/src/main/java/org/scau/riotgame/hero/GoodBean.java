package org.scau.riotgame.hero;

import java.util.List;

/**
 * Created by ZP on 2018/2/26.
 */

public class GoodBean {


    private List<ItemsBean> items;
    private List<String> props;
    private List<String> maps;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public List<String> getProps() {
        return props;
    }

    public void setProps(List<String> props) {
        this.props = props;
    }

    public List<String> getMaps() {
        return maps;
    }

    public void setMaps(List<String> maps) {
        this.maps = maps;
    }

    public static class ItemsBean {
        /**
         * othernames : ["小饼干"]
         * maplist : ["召唤师峡谷","水晶之痕","扭曲丛林","嚎哭深渊"]
         * name : 活力夹心饼干
         * good_id : 2009
         * proplist : ["对线","消耗品"]
         */

        private String name;
        private int good_id;
        private List<String> othernames;
        private List<String> maplist;
        private List<String> proplist;

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
}
