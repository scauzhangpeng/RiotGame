package com.muugi.riot.discovery.wallpaper.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.muugi.riot.discovery.R;
import com.muugi.riot.discovery.wallpaper.bean.WallPaperDetail;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.util.ScreenUtil;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2018/6/6.
 */

public class HotWallPaperAdapter extends BasicAdapter<WallPaperDetail> {

    public HotWallPaperAdapter(List<WallPaperDetail> datas, Context context) {
        super(R.layout.item_wallpaper, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, WallPaperDetail wallpapersBean, int position) {
        ImageView ivWallPaper = holder.getView(R.id.iv_wallpaper);
        ViewGroup.LayoutParams layoutParams = ivWallPaper.getLayoutParams();
        int thumb_height = Integer.parseInt(wallpapersBean.getThumb_height());
        int thumb_width = Integer.parseInt(wallpapersBean.getThumb_width());
        if (thumb_height > thumb_width) {
            layoutParams.height = (int) ScreenUtil.dp2px(mContext, Integer.parseInt(wallpapersBean.getThumb_height()));
        } else {
            layoutParams.height = (int) (thumb_height * 1.5);
        }
//        layoutParams.width = (int) ScreenUtil.dip2px(mContext, Integer.parseInt(wallpapersBean.getThumb_width()));
        ivWallPaper.setLayoutParams(layoutParams);

        ImageLoadUtil.loadImage(mContext, wallpapersBean.getThumbUrl(), R.drawable.default_lol_ex, ivWallPaper);
    }
}
