package org.scau.riotgame.hero;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;

import java.util.List;

/**
 * Created by ZP on 2018/2/26.
 */

public class GoodsDetailAdapter extends BasicAdapter<String> {

    public GoodsDetailAdapter(List<String> datas, Context context) {
        super(R.layout.item_goods_detail, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, String s, int position) {
        ImageView iv = holder.getView(R.id.iv_good_detail_icon);
        ImageLoadUtil.loadImage(mContext, s, R.drawable.default_lol_ex, iv);
    }
}
