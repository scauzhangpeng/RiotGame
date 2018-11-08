package org.scau.riotgame.home;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;

import java.util.List;

/**
 * Created by ZP on 2018/2/8.
 */

public class ColumnListAdapter extends BasicAdapter<ListColumnListWrapper> {

    public ColumnListAdapter(List<ListColumnListWrapper> datas, Context context, MultipleTypeSupport<ListColumnListWrapper> multipleTypeSupport) {
        super(datas, context, multipleTypeSupport);
    }

    @Override
    protected void bindData(BasicViewHolder holder, ListColumnListWrapper columnList, int position) {
        if (columnList.getType() == 0) {
            holder.setText(R.id.tv_col_title, columnList.getColumnList().getCol_title());
            holder.setText(R.id.tv_col_author, columnList.getColumnList().getAuthor());
            holder.setText(R.id.tv_col_book_num, columnList.getColumnList().getBook_num());
            holder.setText(R.id.tv_col_des, columnList.getColumnList().getCol_des());
            holder.setImagePath(R.id.iv_col_logo, new AbstractImageLoader(columnList.getColumnList().getLogo()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadCircleImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });
            if (columnList.getColumnList().getCol_from() != null && !TextUtils.isEmpty(columnList.getColumnList().getCol_from())) {
                holder.setVisibility(R.id.iv_col_video_tag, View.VISIBLE);
            } else {
                holder.setVisibility(R.id.iv_col_video_tag, View.GONE);
            }
        }

        //book
        if (columnList.getType() == 1) {
            holder.setText(R.id.tv_col_title, columnList.getColumnList().getCol_title());
            holder.setText(R.id.tv_col_des, columnList.getColumnList().getLast_news_title());
            holder.setImagePath(R.id.iv_col_logo, new AbstractImageLoader(columnList.getColumnList().getLogo()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadCircleImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });
            if (columnList.getColumnList().getCol_from() != null && !TextUtils.isEmpty(columnList.getColumnList().getCol_from())) {
                holder.setVisibility(R.id.iv_col_video_tag, View.VISIBLE);
            } else {
                holder.setVisibility(R.id.iv_col_video_tag, View.GONE);
            }
        }

        //recommend
        if (columnList.getType() == 2) {
            holder.setText(R.id.tv_col_title, columnList.getColumnList().getCol_title());
            holder.setText(R.id.tv_col_des, columnList.getColumnList().getCol_des());
            holder.setImagePath(R.id.iv_col_logo, new AbstractImageLoader(columnList.getColumnList().getLogo()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadCircleImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });
            if (columnList.getColumnList().getCol_from() != null && !TextUtils.isEmpty(columnList.getColumnList().getCol_from())) {
                holder.setVisibility(R.id.iv_col_video_tag, View.VISIBLE);
            } else {
                holder.setVisibility(R.id.iv_col_video_tag, View.GONE);
            }
        }
    }
}
