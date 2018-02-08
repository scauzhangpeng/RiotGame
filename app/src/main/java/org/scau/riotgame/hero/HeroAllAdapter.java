package org.scau.riotgame.hero;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;

import org.scau.riotgame.R;
import org.scau.riotgame.utils.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2018/2/8.
 */

public class HeroAllAdapter extends BasicAdapter<Hero> {
    public HeroAllAdapter(List<Hero> datas, Context context) {
        super(R.layout.item_hero, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, Hero hero, int position) {
        holder.setText(R.id.tv_hero_name, hero.getName())
                .setImagePath(R.id.iv_header, new AbstractImageLoader(hero.getUrl()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadCircleImage(mContext, path, R.drawable.default_lol_ex, imageView);
                    }
                })
                .setText(R.id.tv_hero_nickname, hero.getNickName());
    }
}
