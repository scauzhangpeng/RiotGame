package org.scau.riotgame.wallpaper.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;

import org.scau.riotgame.R;

import com.xyz.riotcommon.ImageLoadUtil;
import org.scau.riotgame.utils.ScreenUtil;
import org.scau.riotgame.wallpaper.bean.WallPaperDetail;

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
            layoutParams.height = (int) ScreenUtil.dip2px(mContext, Integer.parseInt(wallpapersBean.getThumb_height()));
        } else {
            layoutParams.height = (int) (thumb_height * 1.5);
        }
//        layoutParams.width = (int) ScreenUtil.dip2px(mContext, Integer.parseInt(wallpapersBean.getThumb_width()));
        ivWallPaper.setLayoutParams(layoutParams);

        ImageLoadUtil.loadImage(mContext, wallpapersBean.getThumbUrl(), R.drawable.default_lol_ex, ivWallPaper);
    }
}
