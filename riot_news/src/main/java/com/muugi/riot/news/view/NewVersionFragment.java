package com.muugi.riot.news.view;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.muugi.riot.news.R;
import com.muugi.riot.news.base.BaseNewsFragment;
import com.muugi.riot.news.bean.NewVersionCard;
import com.muugi.riot.news.bean.NewVersionCardItem;
import com.muugi.riot.news.bean.NewVersionListBean;
import com.muugi.riot.news.contract.NewVersionContract;
import com.muugi.riot.news.model.Injection;
import com.muugi.riot.news.presenter.NewVersionPresenter;
import com.muugi.riot.news.utils.FormatUtil;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.ImageLoadUtil;
import com.xyz.riotcommon.RouterConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 新版本资讯.
 * "新版本英雄"、"新版本皮肤" 与 "版本改动总览"、"版本改动焦点"不同时出现.
 *
 * Created by ZP on 2018/1/24.
 */
@Route(path = RouterConstants.NEWS_VERSION)
public class NewVersionFragment extends BaseNewsFragment<NewVersionListBean, NewVersionContract.View, NewVersionContract.Presenter> implements NewVersionContract.View {

    /**
     * 新版本英雄
     */
    private RecyclerView mRvNewVersionHero;
    private BasicAdapter<NewVersionCard> mNewVersionHeroAdapter;
    private List<NewVersionCard> mNewVersionHero;

    /**
     * 新版本皮肤
     */
    private RecyclerView mRvNewVersionSkin;
    private BasicAdapter<NewVersionCard> mNewVersionSkinAdapter;
    private List<NewVersionCard> mNewVersionSkin;

    /**
     * 版本改动总览
     */
    private RecyclerView mRvNewsVersionScan;
    private BasicAdapter<NewVersionCard> mNewVersionScanAdapter;
    private List<NewVersionCard> mNewVersionScan;

    /**
     * 版本改动焦点
     */
    private RecyclerView mRvNewsVersionAbout;
    private BasicAdapter<NewVersionCard> mNewVersionAboutAdapter;
    private List<NewVersionCard> mNewVersionAbout;

    private MultipleTypeSupport<NewVersionListBean> mMultipleTypeSupport = new MultipleTypeSupport<NewVersionListBean>() {
        @Override
        public int getLayoutId(NewVersionListBean heroGroupListBean, int position) {
            if ("newverhero".equals(heroGroupListBean.getType())) {
                return R.layout.layout_version_hero;
            }

            if ("newverskin".equals(heroGroupListBean.getType())) {
                return R.layout.layout_version_skin;
            }

            if ("newverscan".equals(heroGroupListBean.getType())) {
                return R.layout.layout_version_scan;
            }

            if ("newverabout".equals(heroGroupListBean.getType())) {
                return R.layout.layout_version_about;
            }

            return R.layout.item_news_default;
        }
    };

    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mNewVersionHero = new ArrayList<>();
        mNewVersionHeroAdapter = new BasicAdapter<NewVersionCard>(R.layout.item_version_hero, mNewVersionHero, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, NewVersionCard card, int position) {
                holder.setText(R.id.tv_hero_desc, card.getHero_desc());
                holder.setText(R.id.tv_hero_nickname, card.getHero_nick());
                holder.setImagePath(R.id.iv_hero_logo, new AbstractImageLoader(card.getHero_head_img_url()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                    }
                });
                ImageView view = holder.getView(R.id.rl_background);
                ImageLoadUtil.blurTransformation(mContext, card.getHero_bg_img_url(), new CustomViewTarget<ImageView, Bitmap>(view) {
                    @Override
                    protected void onResourceCleared(@Nullable Drawable placeholder) {

                    }

                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {

                    }

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        view.setImageBitmap(resource);
                    }
                });
            }
        };

        mNewVersionSkin = new ArrayList<>();
        mNewVersionSkinAdapter = new BasicAdapter<NewVersionCard>(R.layout.item_version_skin, mNewVersionSkin, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, NewVersionCard card, int position) {
                holder.setText(R.id.iv_hero_skin_desc, card.getHero_nick() + " " + card.getHero_name());
                holder.setImagePath(R.id.iv_hero_skin, new AbstractImageLoader(card.getSkin_pic_url()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                    }
                });
                holder.setImagePath(R.id.iv_hero_logo, new AbstractImageLoader(card.getHero_head_img_url()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };

        mNewVersionScan = new ArrayList<>();
        mNewVersionScanAdapter = new BasicAdapter<NewVersionCard>(R.layout.item_version_scan, mNewVersionScan, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, NewVersionCard card, int position) {
                holder.setText(R.id.tv_change_type, card.getChange_type());
                holder.setText(R.id.tv_num, getString(R.string.vserion_scan_num, card.getNum()));
                holder.setImagePath(R.id.iv_scan_icon, new AbstractImageLoader(card.getChange_type_img()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };

        mNewVersionAbout = new ArrayList<>();
        mNewVersionAboutAdapter = new BasicAdapter<NewVersionCard>(R.layout.item_version_about, mNewVersionAbout, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, NewVersionCard card, int position) {
                holder.setText(R.id.iv_about_pv, FormatUtil.unitToTenThousand(card.getPv()));
                holder.setText(R.id.tv_about_title, card.getTitle());
                holder.setImagePath(R.id.iv_about_icon, new AbstractImageLoader(card.getImage_url_small()) {
                    @Override
                    public void loadImage(ImageView imageView, String path) {
                        ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                    }
                });
            }
        };
        super.initViewsAndEvents(inflater, container, savedInstanceState);
    }

    @Override
    protected NewVersionContract.Presenter initPresenter() {
        return new NewVersionPresenter("367", Injection.provideNewsRepository());
    }

    @Override
    protected BasicAdapter<NewVersionListBean> getAdapter() {
        return new BasicAdapter<NewVersionListBean>(mData, getActivity(), mMultipleTypeSupport) {
            @Override
            protected void bindData(BasicViewHolder holder, NewVersionListBean newVersionListBean, int position) {
                if ("newverhero".equals(newVersionListBean.getType())) {
                    HashMap<String, String> header = newVersionListBean.getHeader();
                    holder.setText(R.id.tv_change_hero_ver, header.get("ver"));
                    holder.setText(R.id.tv_change_hero_desc, header.get("desc"));
                    holder.setText(R.id.tv_change_hero_num, header.get("num"));
                    mRvNewVersionHero = holder.getView(R.id.rv_version_hero);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvNewVersionHero.setLayoutManager(linearLayoutManager);
                    mRvNewVersionHero.setAdapter(mNewVersionHeroAdapter);
                    return;
                }

                if ("newverskin".equals(newVersionListBean.getType())) {
                    HashMap<String, String> header = newVersionListBean.getHeader();
                    holder.setText(R.id.tv_change_hero_ver, header.get("ver"));
                    holder.setText(R.id.tv_change_hero_desc, header.get("desc"));
                    holder.setText(R.id.tv_change_hero_num, header.get("num"));
                    mRvNewVersionSkin = holder.getView(R.id.rv_version_skin);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvNewVersionSkin.setLayoutManager(linearLayoutManager);
                    mRvNewVersionSkin.setAdapter(mNewVersionSkinAdapter);
                    return;
                }

                if ("newverscan".equals(newVersionListBean.getType())) {
                    HashMap<String, String> header = newVersionListBean.getHeader();
                    holder.setText(R.id.tv_change_scan_ver, header.get("ver"));
                    holder.setText(R.id.tv_change_scan_desc, header.get("desc"));
                    holder.setText(R.id.tv_change_scan_num, header.get("num"));
                    mRvNewsVersionScan = holder.getView(R.id.rv_version_scan);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvNewsVersionScan.setLayoutManager(linearLayoutManager);
                    mRvNewsVersionScan.setAdapter(mNewVersionScanAdapter);
                    return;
                }

                if ("newverabout".equals(newVersionListBean.getType())) {
                    HashMap<String, String> header = newVersionListBean.getHeader();
                    holder.setText(R.id.tv_change_about_ver, header.get("ver"));
                    holder.setText(R.id.tv_change_about_desc, header.get("desc"));
                    holder.setText(R.id.tv_change_about_num, header.get("num"));
                    mRvNewsVersionAbout = holder.getView(R.id.rv_version_about);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvNewsVersionAbout.setLayoutManager(linearLayoutManager);
                    mRvNewsVersionAbout.setAdapter(mNewVersionAboutAdapter);
                    return;
                }
                if ("news".equals(newVersionListBean.getType())) {
                    if ("ordinary".equals(newVersionListBean.getNews().getNewstypeid())) {
                        if ("True".equals(newVersionListBean.getNews().getIs_top())) {
                            holder.setVisibility(R.id.iv_article_top, View.VISIBLE);
                        } else {
                            holder.setVisibility(R.id.iv_article_top, View.GONE);
                        }
                        holder.setText(R.id.tv_article_title, newVersionListBean.getNews().getTitle());
                        holder.setText(R.id.tv_article_summary, newVersionListBean.getNews().getSummary());
                        holder.setText(R.id.tv_article_pv, mContext.getString(R.string.article_pv, FormatUtil.unitToTenThousand(newVersionListBean.getNews().getPv())));
                        if (newVersionListBean.getNews().getNewstype() == null || TextUtils.isEmpty(newVersionListBean.getNews().getNewstype())) {
                            holder.setVisibility(R.id.tv_article_tag, View.GONE);
                        } else {
                            holder.setVisibility(R.id.tv_article_tag, View.VISIBLE);
                            holder.setText(R.id.tv_article_tag, newVersionListBean.getNews().getNewstype());
                        }
                        holder.setImagePath(R.id.iv_article, new AbstractImageLoader(newVersionListBean.getNews().getImage_url_small()) {
                            @Override
                            public void loadImage(ImageView imageView, String path) {
                                ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                            }
                        });

                        if ("True".equals(newVersionListBean.getNews().getImage_with_btn())) {
                            holder.setVisibility(R.id.iv_article_video, View.VISIBLE);
                        } else {
                            holder.setVisibility(R.id.iv_article_video, View.GONE);
                        }
                    }

                    if ("image".equals(newVersionListBean.getNews().getNewstypeid())) {
                        holder.setText(R.id.tv_article_title, newVersionListBean.getNews().getTitle());
                        holder.setText(R.id.tv_article_summary, newVersionListBean.getNews().getSummary());
                        holder.setText(R.id.tv_article_pv, mContext.getString(R.string.article_pv, FormatUtil.unitToTenThousand(newVersionListBean.getNews().getPv())));
                        if (newVersionListBean.getNews().getNewstype() == null || TextUtils.isEmpty(newVersionListBean.getNews().getNewstype())) {
                            holder.setVisibility(R.id.tv_article_tag, View.GONE);
                        } else {
                            holder.setText(R.id.tv_article_tag, newVersionListBean.getNews().getNewstype());
                        }

                        holder.setImagePath(R.id.iv_article_big, new AbstractImageLoader(newVersionListBean.getNews().getBig_image_url()) {
                            @Override
                            public void loadImage(ImageView imageView, String path) {
                                ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                            }
                        });

                        holder.setImagePath(R.id.iv_article_small, new AbstractImageLoader(newVersionListBean.getNews().getSmall_image_url()) {
                            @Override
                            public void loadImage(ImageView imageView, String path) {
                                ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                            }
                        });

                        holder.setImagePath(R.id.iv_article_count, new AbstractImageLoader(newVersionListBean.getNews().getCount_image_url()) {
                            @Override
                            public void loadImage(ImageView imageView, String path) {
                                ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                            }
                        });
                    }

                    if ("report".equals(newVersionListBean.getNews().getNewstypeid())) {
                        holder.setText(R.id.tv_article_title, newVersionListBean.getNews().getTitle());

                        holder.setText(R.id.tv_article_pv, mContext.getString(R.string.article_pv, FormatUtil.unitToTenThousand(newVersionListBean.getNews().getPv())));
                        if (newVersionListBean.getNews().getNewstype() == null || TextUtils.isEmpty(newVersionListBean.getNews().getNewstype())) {
                            holder.setVisibility(R.id.tv_article_tag, View.GONE);
                        } else {
                            holder.setText(R.id.tv_article_tag, newVersionListBean.getNews().getNewstype());
                        }
                        holder.setImagePath(R.id.iv_article, new AbstractImageLoader(newVersionListBean.getNews().getImage_url_small()) {
                            @Override
                            public void loadImage(ImageView imageView, String path) {
                                ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                            }
                        });

                        holder.setImagePath(R.id.iv_logo_teama, new AbstractImageLoader(newVersionListBean.getNews().getTeama_logo()) {
                            @Override
                            public void loadImage(ImageView imageView, String path) {
                                ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                            }
                        });
                        holder.setText(R.id.tv_name_teama, newVersionListBean.getNews().getTeama_name());
                        holder.setText(R.id.tv_match_result, newVersionListBean.getNews().getMarch_result());
                        holder.setImagePath(R.id.iv_logo_teamb, new AbstractImageLoader(newVersionListBean.getNews().getTeamb_logo()) {
                            @Override
                            public void loadImage(ImageView imageView, String path) {
                                ImageLoadUtil.loadImage(mContext, path, R.drawable.default_lol_ex, imageView);
                            }
                        });
                        holder.setText(R.id.tv_name_teamb, newVersionListBean.getNews().getTeamb_name());
                    }
                }

            }
        };
    }

    @Override
    public void onItemClick(View view, int position) {
        NewVersionListBean newVersionListBean = mData.get(position);
        if ("news".equals(newVersionListBean.getType())) {
            openWebView(newVersionListBean.getNews().getArticle_url());
        }
    }

    @Override
    public void showListData(List<NewVersionListBean> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
        mPresenter.requestNewVersionCard();
    }

    @Override
    public void showNewVersionHero(NewVersionCardItem cards) {
        mNewVersionHero.clear();
        mNewVersionHero.addAll(cards.getCardlist());
        mNewVersionHeroAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showNewVersionSkin(NewVersionCardItem cards) {
        mNewVersionSkin.clear();
        mNewVersionSkin.addAll(cards.getCardlist());
        mNewVersionSkinAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showNewsVersionScan(NewVersionCardItem cards) {
        mNewVersionScan.clear();
        mNewVersionScan.addAll(cards.getCardlist());
        mNewVersionScanAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showNewsVersionAbout(NewVersionCardItem cards) {
        mNewVersionAbout.clear();
        mNewVersionAbout.addAll(cards.getCardlist());
        mNewVersionAboutAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void updateCardItem(int position, NewVersionListBean bean) {
        mData.add(position, bean);
        mAdapter.notifyDataSetChanged();
    }
}
