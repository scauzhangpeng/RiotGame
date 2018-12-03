package com.muugi.riot.news.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.muugi.riot.news.R;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.utils.FormatUtil;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2018/11/10.
 */
public class HotNewsAdapter extends BasicAdapter<News> {


    public HotNewsAdapter(List<News> datas, Context context, MultipleTypeSupport<News> multipleTypeSupport) {
        super(datas, context, multipleTypeSupport);
    }

    @Override
    protected void bindData(BasicViewHolder holder, News news, int position) {
        if ("ordinary".equals(news.getNewstypeid())) {
            if ("True".equals(news.getIs_top())) {
                holder.setVisibility(R.id.iv_article_top, View.VISIBLE);
            } else {
                holder.setVisibility(R.id.iv_article_top, View.GONE);
            }
            holder.setText(R.id.tv_article_title, news.getTitle());
            holder.setText(R.id.tv_article_summary, news.getSummary());
            holder.setText(R.id.tv_article_pv, mContext.getString(R.string.article_pv, FormatUtil.unitToTenThousand(news.getPv())));
            if (news.getNewstype() == null || TextUtils.isEmpty(news.getNewstype())) {
                holder.setVisibility(R.id.tv_article_tag, View.GONE);
            } else {
                holder.setVisibility(R.id.tv_article_tag, View.VISIBLE);
                holder.setText(R.id.tv_article_tag, news.getNewstype());
            }
            holder.setImagePath(R.id.iv_article, new AbstractImageLoader(news.getImage_url_small()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });

            if ("True".equals(news.getImage_with_btn())) {
                holder.setVisibility(R.id.iv_article_video, View.VISIBLE);
            } else {
                holder.setVisibility(R.id.iv_article_video, View.GONE);
            }
        }

        if ("image".equals(news.getNewstypeid())) {
            holder.setText(R.id.tv_article_title, news.getTitle());
            holder.setText(R.id.tv_article_summary, news.getSummary());
            holder.setText(R.id.tv_article_pv, mContext.getString(R.string.article_pv, FormatUtil.unitToTenThousand(news.getPv())));
            if (news.getNewstype() == null || TextUtils.isEmpty(news.getNewstype())) {
                holder.setVisibility(R.id.tv_article_tag, View.GONE);
            } else {
                holder.setText(R.id.tv_article_tag, news.getNewstype());
            }

            holder.setImagePath(R.id.iv_article_big, new AbstractImageLoader(news.getBig_image_url()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });

            holder.setImagePath(R.id.iv_article_small, new AbstractImageLoader(news.getSmall_image_url()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });

            holder.setImagePath(R.id.iv_article_count, new AbstractImageLoader(news.getCount_image_url()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });
        }

        if ("report".equals(news.getNewstypeid())) {
            holder.setText(R.id.tv_article_title, news.getTitle());

            holder.setText(R.id.tv_article_pv, mContext.getString(R.string.article_pv, FormatUtil.unitToTenThousand(news.getPv())));
            if (news.getNewstype() == null || TextUtils.isEmpty(news.getNewstype())) {
                holder.setVisibility(R.id.tv_article_tag, View.GONE);
            } else {
                holder.setText(R.id.tv_article_tag, news.getNewstype());
            }
            holder.setImagePath(R.id.iv_article, new AbstractImageLoader(news.getImage_url_small()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });

            holder.setImagePath(R.id.iv_logo_teama, new AbstractImageLoader(news.getTeama_logo()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });
            holder.setText(R.id.tv_name_teama, news.getTeama_name());
            holder.setText(R.id.tv_match_result, news.getMarch_result());
            holder.setImagePath(R.id.iv_logo_teamb, new AbstractImageLoader(news.getTeamb_logo()) {
                @Override
                public void loadImage(ImageView imageView, String path) {
                    ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                }
            });
            holder.setText(R.id.tv_name_teamb, news.getTeamb_name());
        }
    }
}

