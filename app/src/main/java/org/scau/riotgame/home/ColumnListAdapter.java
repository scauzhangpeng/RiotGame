package org.scau.riotgame.home;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.ColumnList;
import org.scau.riotgame.utils.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2018/2/8.
 */

public class ColumnListAdapter extends BasicAdapter<ColumnList> {

    public ColumnListAdapter(List<ColumnList> datas, Context context) {
        super(R.layout.item_columlist_unbook, datas, context);
    }

    @Override
    protected void bindData(BasicViewHolder holder, ColumnList columnList, int position) {
        holder.setText(R.id.tv_col_title, columnList.getCol_title());
        holder.setText(R.id.tv_col_author, columnList.getAuthor());
        holder.setText(R.id.tv_col_book_num, columnList.getBook_num());
        holder.setText(R.id.tv_col_des, columnList.getCol_des());
        holder.setImagePath(R.id.iv_col_logo, new AbstractImageLoader(columnList.getLogo()) {
            @Override
            public void loadImage(ImageView imageView, String path) {
                ImageLoadUtil.loadCircleImage(mContext, path, R.drawable.default_lol_ex, imageView);
            }
        });
        if (columnList.getCol_from() != null && !TextUtils.isEmpty(columnList.getCol_from())) {
            holder.setVisibility(R.id.iv_col_video_tag, View.VISIBLE);
        } else {
            holder.setVisibility(R.id.iv_col_video_tag, View.GONE);
        }
    }
}
