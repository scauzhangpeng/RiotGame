package org.scau.riotgame.home;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.AbsListView;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.HotMatch;
import org.scau.riotgame.utils.ScreenUtil;

import java.util.List;

/**
 * Created by ZP on 2018/11/29.
 */
public class WholeVideoAdapter extends BasicAdapter<HotMatch> {

    public WholeVideoAdapter(int layoutId, List<HotMatch> datas, Context context) {
        super(layoutId, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, HotMatch hotMatch, int position) {
        measureHeight(holder);
        holder.setText(R.id.tv_video_time, hotMatch.getTime());
        holder.setText(R.id.tv_hot_match_title, hotMatch.getTitle());
        holder.setText(R.id.tv_hot_match_play, mContext.getString(R.string.information_video_play, hotMatch.getPlay()));
        holder.setImagePath(R.id.iv_hot_match_thumb, new AbstractImageLoader(hotMatch.getThumb()) {
            @Override
            public void loadImage(ImageView imageView, String path) {
                ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
            }
        });
    }

    /**
     * item的长宽为（屏幕宽度 - 间距）/ 列数.
     */
    private void measureHeight(BasicViewHolder holder) {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;
        int screenPadding = (int) ScreenUtil.dip2px(mContext, 30);
        AbsListView.LayoutParams mParams = new AbsListView.LayoutParams(
                (width - screenPadding) / 2,
                (int) ScreenUtil.dip2px(mContext, 176));
        holder.itemView.setLayoutParams(mParams);
    }
}
