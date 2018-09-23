package com.muugi.album;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2018/8/7.
 */

public class AlbumDetailAdapter extends BasicAdapter<WrapperFile> {


    public AlbumDetailAdapter(List<WrapperFile> datas, Context context) {
        super(R.layout.item_album_detail, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, WrapperFile file, int position) {
        ImageView imageView = holder.getView(R.id.iv_album_detail);
        ImageLoadUtil.loadImage(mContext, file.getFile().getAbsolutePath(), R.drawable.teemo_1, imageView);

        CheckBox cbSelected = holder.getView(R.id.cb_album_selected);
        cbSelected.setChecked(file.isSelected());
    }
}
