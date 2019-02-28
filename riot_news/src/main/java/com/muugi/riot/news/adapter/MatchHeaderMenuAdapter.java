package com.muugi.riot.news.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.muugi.riot.news.R;
import com.muugi.riot.news.bean.Feature;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2019/2/28.
 */
public class MatchHeaderMenuAdapter extends BasicAdapter<Feature> {

    public MatchHeaderMenuAdapter(List<Feature> datas, Context context) {
        super(R.layout.item_header_menu, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, Feature feature, int position) {
        holder.setText(R.id.tv_menu, feature.getName());
        ImageLoadUtil.loadImage(mContext, feature.getIconUrl(), R.drawable.default_lol_ex, (ImageView) holder.getView(R.id.iv_menu));
    }
}
