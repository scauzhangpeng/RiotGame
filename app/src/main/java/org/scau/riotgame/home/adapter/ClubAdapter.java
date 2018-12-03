package org.scau.riotgame.home.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.Club;

import java.util.List;

/**
 * Created by ZP on 2017/8/2.
 */

public class ClubAdapter extends BasicAdapter<Club.ClubsBean> {

    public ClubAdapter(List<Club.ClubsBean> datas, Context context) {
        super(R.layout.item_club, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, Club.ClubsBean club, int position) {
        holder.setImagePath(R.id.iv_club_icon, new AbstractImageLoader(club.getIconUrl()) {
            @Override
            public void loadImage(ImageView imageView, String path) {
                ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
            }
        });
        holder.setText(R.id.tv_club_name, club.getName());
    }
}
