package org.scau.riotgame.home.contract;


import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import org.scau.riotgame.home.bean.HotAuthor;
import org.scau.riotgame.home.bean.HotEnter;
import org.scau.riotgame.home.bean.HotMatch;
import org.scau.riotgame.home.bean.HotWpv;

import java.util.List;

/**
 * Created by ZP on 2017/8/24.
 */

public interface VideoContract {

    interface View extends BaseView {
        void showHotAuthorList(List<HotAuthor> hotAuthors);

        void showHotWpvList(List<HotWpv> hotWpvs);

        void showHotEnterList(List<HotEnter> hotEnters);

        void showHotMatchList(List<HotMatch> hotMatches);

        void showHotMatchTop(HotMatch hotMatch);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getHotAuthorList();

        public abstract void getHotWpvList();
    }
}
