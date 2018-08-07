package org.scau.riotgame.hero;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;

import java.util.List;

/**
 * Created by ZP on 2018/2/8.
 */

public class HeroFreeAdapter extends BasicAdapter<Hero> {
    public HeroFreeAdapter(List<Hero> datas, Context context) {
        super(R.layout.item_hero, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, Hero hero, int position) {
        holder.setText(R.id.tv_hero_name, hero.getName());
        holder.setText(R.id.tv_hero_nickname, hero.getNick());
        holder.setText(R.id.tv_rate, "");
        holder.setText(R.id.tv_tag, hero.getTag1());
        ImageView imageView = (ImageView) holder.getView(R.id.iv_header);
        ImageLoadUtil.loadCircleImage(mContext, "", R.drawable.default_lol_ex, imageView);
    }
}
