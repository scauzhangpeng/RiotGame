package com.muugi.album;

import android.content.Context;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import java.io.File;
import java.util.List;

/**
 * Created by ZP on 2018/8/7.
 */

public class AlbumDetailAdapter extends BasicAdapter<File> {

    public AlbumDetailAdapter(List<File> datas, Context context) {
        super(R.layout.item_album_detail, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, File file, int position) {
        ImageView imageView = holder.getView(R.id.iv_album_detail);
        ImageLoadUtil.loadImage(mContext, file.getAbsolutePath(), R.drawable.teemo_1, imageView);
    }
}
