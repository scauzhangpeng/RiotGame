package com.muugi.album;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2018/7/18.
 */

public class AlbumAdapter extends BasicAdapter<ImageFolder> {

    public AlbumAdapter(List<ImageFolder> datas, Context context) {
        super(R.layout.item_album_list, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, ImageFolder imageFloder, int position) {
        holder.setText(R.id.path, mContext.getString(R.string.album_name_and_count, imageFloder.getName(), imageFloder.getCount()));
        ImageLoadUtil.loadImage(mContext, imageFloder.getFirstImagePath(), R.drawable.teemo_1, (ImageView) holder.getView(R.id.album));
    }
}
