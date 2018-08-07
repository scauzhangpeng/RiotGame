package org.scau.riotgame.hero;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;

import java.util.List;

/**
 * Created by ZP on 2018/2/8.
 */

public class HeroAllAdapter extends BasicAdapter<Hero> {
    public HeroAllAdapter(List<Hero> datas, Context context) {
        super(R.layout.item_hero_all, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, Hero hero, int position) {
        holder.setText(R.id.tv_hero_name, hero.getName())
                .setImagePath(R.id.iv_hero_header, new AbstractImageLoader(hero.getId() + "") {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadCircleImage(mContext, "http://down.qq.com/qqtalk/lolApp/img/hero/" + path + ".png", R.drawable.default_lol_ex, imageView);
                    }
                })
                .setText(R.id.tv_hero_nick, hero.getNick())
                .setText(R.id.tv_hero_tags, hero.getTag1() + "/" + hero.getTag2() + "/" + hero.getTag3());
    }
}
