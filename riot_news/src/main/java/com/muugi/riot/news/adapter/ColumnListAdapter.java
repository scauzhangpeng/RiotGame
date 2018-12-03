package com.muugi.riot.news.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.muugi.riot.news.R;
import com.muugi.riot.news.bean.SpecialColumnListBean;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.basiclib.util.DateUtil;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ZP on 2018/2/8.
 */

public class ColumnListAdapter extends BasicAdapter<SpecialColumnListBean> {

    public ColumnListAdapter(List<SpecialColumnListBean> datas, Context context, MultipleTypeSupport<SpecialColumnListBean> multipleTypeSupport) {
        super(datas, context, multipleTypeSupport);
    }

    @Override
    protected void bindData(BasicViewHolder holder, SpecialColumnListBean columnList, int position) {
        if (columnList.getType() == 0) {
            holder.setText(R.id.tv_col_title, columnList.getColumnList().getCol_title());
            holder.setText(R.id.tv_col_author, columnList.getColumnList().getAuthor());
            holder.setText(R.id.tv_col_book_num, columnList.getColumnList().getBook_num());
            holder.setText(R.id.tv_col_des, columnList.getColumnList().getCol_des());
            CircleImageView logoView = holder.getView(R.id.iv_col_logo);
            ImageLoadUtil.loadImage(mContext, columnList.getColumnList().getLogo(), R.drawable.default_lol_ex, logoView);
            if (columnList.getColumnList().getCol_from() != null && !TextUtils.isEmpty(columnList.getColumnList().getCol_from())) {
                holder.setVisibility(R.id.iv_col_video_tag, View.VISIBLE);
            } else {
                holder.setVisibility(R.id.iv_col_video_tag, View.GONE);
            }
        }

        //book
        if (columnList.getType() == 1) {
            String last_update = columnList.getColumnList().getLast_update();
            String updateTime = DateUtil.strToStr(last_update, DateUtil.DATE_FORMAT_SEC, DateUtil.DATE_FORMAT_MONTH_DAY);
            holder.setText(R.id.tv_col_update_time, updateTime + "更新");
            holder.setText(R.id.tv_col_title, columnList.getColumnList().getCol_title());
            holder.setText(R.id.tv_col_des, columnList.getColumnList().getLast_news_title());
            holder.setImagePath(R.id.iv_col_logo, new AbstractImageLoader(columnList.getColumnList().getLogo()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
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
                    ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });
            if (columnList.getColumnList().getCol_from() != null && !TextUtils.isEmpty(columnList.getColumnList().getCol_from())) {
                holder.setVisibility(R.id.iv_col_video_tag, View.VISIBLE);
            } else {
                holder.setVisibility(R.id.iv_col_video_tag, View.GONE);
            }
        }

        if (columnList.getType() == 3) {
            holder.setText(R.id.tv_columnlist_desc, "未订阅");
        }

        if (columnList.getType() == 4) {
            holder.setText(R.id.tv_columnlist_desc, "已订阅");
        }

        if (columnList.getType() == 5) {
            holder.setText(R.id.tv_columnlist_desc, "栏目推荐");
        }
    }

    public boolean isVideoColumnList(int position) {
        SpecialColumnListBean specialColumnListBean = mDatas.get(position);
        if (specialColumnListBean.getColumnList().getCol_from() != null
                && !TextUtils.isEmpty(specialColumnListBean.getColumnList().getCol_from())) {
            return true;
        }
        return false;
    }
}
