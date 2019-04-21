package org.scau.riotgame.act;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;
import org.scau.riotgame.act.bean.ActDetail;

import java.util.List;

/**
 * Created by ZP on 2018/6/8.
 */

public class ActAdapter extends BasicAdapter<ActDetail> {
    public ActAdapter(List<ActDetail> data, Context context) {
        super(R.layout.item_act_detail, data, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, ActDetail actDetail, int position) {
        holder.setText(R.id.tv_act_title, actDetail.getTitle());
        holder.setText(R.id.tv_act_summery, actDetail.getActnews_reward());
        holder.setText(R.id.tv_act_date_left, actDetail.getInsert_date());
        ImageView ivActIcon = holder.getView(R.id.iv_act_icon);
        ImageLoadUtil.loadImage(mContext, actDetail.getImage_url_small(), R.drawable.default_lol_ex, ivActIcon);
    }
}
