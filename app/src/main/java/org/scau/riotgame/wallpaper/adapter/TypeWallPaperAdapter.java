package org.scau.riotgame.wallpaper.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;

import org.scau.riotgame.R;
import org.scau.riotgame.utils.ImageLoadUtil;
import org.scau.riotgame.wallpaper.bean.WallPaperDetail;

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
