package org.scau.riotgame.home;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.DiscoveryMenu;

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
        ImageLoadUtil.loadCircleImage(mContext, discoveryMenu.getImage_url_big(),
                R.drawable.default_lol_ex, (ImageView) holder.getView(R.id.iv_discovery_menu));
    }
}
