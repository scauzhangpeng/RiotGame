package com.muugi.riot.discovery.hero.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.muugi.riot.discovery.R;
import com.muugi.riot.discovery.hero.bean.Hero;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
        ImageView imageView = (CircleImageView) holder.getView(R.id.iv_header);
        ImageLoadUtil.loadImage(mContext, "", R.drawable.default_lol_ex, imageView);
    }
}
