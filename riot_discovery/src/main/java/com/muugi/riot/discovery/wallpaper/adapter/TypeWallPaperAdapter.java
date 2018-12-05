package com.muugi.riot.discovery.wallpaper.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.muugi.riot.discovery.R;
import com.muugi.riot.discovery.wallpaper.bean.WallPaperDetail;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2018/6/6.
 */

public class TypeWallPaperAdapter extends BasicAdapter<WallPaperDetail> {

    public TypeWallPaperAdapter(List<WallPaperDetail> datas, Context context) {
        super(R.layout.item_wallpaper_kind, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, WallPaperDetail wallPaperDetail, int position) {
        String name = wallPaperDetail.getName();
        holder.setText(R.id.tv_wallpaper_name, name);
        ImageLoadUtil.loadImage(mContext, wallPaperDetail.getThumbUrl(), R.drawable.default_lol_ex, (ImageView) holder.getView(R.id.iv_wallpaper));
    }
}
