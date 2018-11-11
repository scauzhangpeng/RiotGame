package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.ImageLoadUtil;
import com.xyz.riotcommon.SimpleRefreshFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.NewVersionCard;
import org.scau.riotgame.home.bean.NewVersionCardItem;
import org.scau.riotgame.home.bean.NewVersionListBean;
import org.scau.riotgame.home.contract.NewVersionContract;
import org.scau.riotgame.home.presenter.NewVersionPresenter;
import org.scau.riotgame.utils.FormatUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZP on 2018/1/24.
 */

public class NewVersionFragment extends SimpleRefreshFragment<NewVersionListBean, NewVersionContract.View, NewVersionContract.Presenter> implements NewVersionContract.View {

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

    private MultipleTypeSupport<NewVersionListBean> mMultipleTypeSupport = new MultipleTypeSupport<NewVersionListBean>() {
        @Override
        public int getLayoutId(NewVersionListBean heroGroupListBean, int position) {
            if ("newverhero".equals(heroGroupListBean.getType())) {
                return R.layout.layout_version_hero;
            }

            if ("newverskin".equals(heroGroupListBean.getType())) {
                return R.layout.layout_version_skin;
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
            }
        };

        mNewVersionSkin = new ArrayList<>();
        mNewVersionSkinAdapter = new BasicAdapter<NewVersionCard>(R.layout.item_version_skin, mNewVersionSkin, getActivity()) {
            @Override
            protected void bindData(BasicViewHolder holder, NewVersionCard card, int position) {
                holder.setText(R.id.iv_hero_skin_desc, card.getHero_nick());
                holder.setImagePath(R.id.iv_hero_skin, new AbstractImageLoader(card.getSkin_pic_url()) {
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
        return new NewVersionPresenter();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    protected BasicAdapter<NewVersionListBean> getAdapter() {
        return new BasicAdapter<NewVersionListBean>(mData, getActivity(), mMultipleTypeSupport) {
            @Override
            protected void bindData(BasicViewHolder holder, NewVersionListBean newVersionListBean, int position) {
                if ("newverhero".equals(newVersionListBean.getType())) {
                    mRvNewVersionHero = holder.getView(R.id.rv_version_hero);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvNewVersionHero.setLayoutManager(linearLayoutManager);
                    mRvNewVersionHero.setAdapter(mNewVersionHeroAdapter);
                    return;
                }

                if ("newverskin".equals(newVersionListBean.getType())) {
                    mRvNewVersionSkin = holder.getView(R.id.rv_version_skin);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    mRvNewVersionSkin.setLayoutManager(linearLayoutManager);
                    mRvNewVersionSkin.setAdapter(mNewVersionSkinAdapter);
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
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.requestNewVersionNews();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNewVersionNews();
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void showNewVersionNews(List<NewVersionListBean> news) {
        mData.clear();
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mPresenter.requestNewVersionCard();
    }

    @Override
    public void showMoreNewVersionNews(int currentPage, List<NewVersionListBean> news) {
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishLoadmore();
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
    public void updateCardItem(int position, NewVersionListBean bean) {
        mData.add(position, bean);
        mAdapter.notifyDataSetChanged();
    }
}
