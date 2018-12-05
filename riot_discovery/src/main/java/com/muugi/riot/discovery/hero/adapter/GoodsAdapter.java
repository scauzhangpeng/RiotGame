package com.muugi.riot.discovery.hero.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.muugi.riot.discovery.R;
import com.muugi.riot.discovery.hero.bean.GoodBean;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2018/2/26.
 */

public class GoodsAdapter extends BasicAdapter<GoodBean.ItemsBean> {


    public GoodsAdapter(List<GoodBean.ItemsBean> datas, Context context) {
        super(R.layout.item_good, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, GoodBean.ItemsBean goodBean, int position) {
        holder.setText(R.id.tv_good_name, goodBean.getName());
        ImageView iv = holder.getView(R.id.iv_good_icon);
        String url = "http://down.qq.com/qqtalk/lolApp/img/item/" + goodBean.getGood_id() + ".png";
        ImageLoadUtil.loadImage(mContext, url, R.drawable.default_lol_ex, iv);
    }
}
