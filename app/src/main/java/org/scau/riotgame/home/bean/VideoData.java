package org.scau.riotgame.home.bean;

import java.util.List;

/**
 * Created by ZP on 2017/8/30.
 */

public class VideoData {

    private List<HotAuthor> HotRecAuthorList;

    private List<HotWpv> HotRecWpvlist;

    private List<HotEnter> HotRecEnterList;

    private List<HotMatch> HotRecMatchList;

    public List<HotMatch> getHotRecMatchList() {
        return HotRecMatchList;
    }

    public void setHotRecMatchList(List<HotMatch> hotRecMatchList) {
        HotRecMatchList = hotRecMatchList;
    }

    public List<HotEnter> getHotRecEnterList() {
        return HotRecEnterList;
    }

    public void setHotRecEnterList(List<HotEnter> hotRecEnterList) {
        HotRecEnterList = hotRecEnterList;
    }

    public List<HotWpv> getHotRecWpvlist() {
        return HotRecWpvlist;
    }

    public void setHotRecWpvlist(List<HotWpv> hotRecWpvlist) {
        HotRecWpvlist = hotRecWpvlist;
    }

    public List<HotAuthor> getHotRecAuthorList() {
        return HotRecAuthorList;
    }

    public void setHotRecAuthorList(List<HotAuthor> hotRecAuthorList) {
        HotRecAuthorList = hotRecAuthorList;
    }
}
