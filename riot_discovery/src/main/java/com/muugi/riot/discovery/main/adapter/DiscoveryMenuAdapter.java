package com.muugi.riot.discovery.main.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.muugi.riot.discovery.R;
import com.muugi.riot.discovery.main.bean.DiscoveryMenu;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2018/2/7.
 */

public class DiscoveryMenuAdapter extends BasicAdapter<DiscoveryMenu> {

    public DiscoveryMenuAdapter(List<DiscoveryMenu> datas, Context context) {
        super(R.layout.item_discovery_menu, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, DiscoveryMenu discoveryMenu, int position) {
        holder.setText(R.id.tv_discovery_menu_title, discoveryMenu.getTitle());
        ImageLoadUtil.loadImage(mContext, discoveryMenu.getImage_url_big(),
                R.drawable.default_lol_ex, (ImageView) holder.getView(R.id.iv_discovery_menu));
    }
}
