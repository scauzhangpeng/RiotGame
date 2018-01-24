package org.scau.riotgame.hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZP on 2018/1/24.
 */

public class AllHeroPresenter extends HeroContract.Presenter {
    @Override
    void getAllHeros() {
        List<Hero> heros = new ArrayList<>();
        heros = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Hero hero = new Hero();
            hero.setUrl("http://ossweb-img.qq.com/images/lol/web201310/skin/small62000.jpg");
            hero.setName("齐天大圣" + i);
            hero.setNickName("孙悟空" + i);
            hero.setTag("战士");
            hero.setRate(55);
            heros.add(hero);
        }
        if (getView() != null) {
            getView().showAllHeros(heros);
        }
    }
}
