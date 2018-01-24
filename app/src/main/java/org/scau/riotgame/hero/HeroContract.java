package org.scau.riotgame.hero;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.util.List;

/**
 * Created by ZP on 2018/1/24.
 */

public interface HeroContract {

    interface View extends BaseView {
        void showAllHeros(List<Hero> heros);
    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void getAllHeros();
    }

    interface FreeView extends BaseView {
        void showFreeHeros(List<Hero> heros);
    }

    abstract class FreePresenter extends BasePresenter<FreeView> {
        abstract void getFreeHeros();
    }
}
