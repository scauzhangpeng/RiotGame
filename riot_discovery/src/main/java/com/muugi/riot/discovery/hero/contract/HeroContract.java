package com.muugi.riot.discovery.hero.contract;

import com.muugi.riot.discovery.hero.bean.Hero;
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
        public abstract void getAllHeros();
    }

    interface FreeView extends BaseView {
        void showFreeHeros(List<Hero> heros);
    }

    abstract class FreePresenter extends BasePresenter<FreeView> {
        public abstract void getFreeHeros();
    }

    interface AllView extends BaseView {
        void showHeroBackground(String bgText);
    }

    abstract class AllPresenter extends BasePresenter<AllView> {
        public abstract void getHeroDetail(String heroId);
    }
}
