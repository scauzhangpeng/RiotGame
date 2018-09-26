package org.scau.riotgame.home.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.AbstractImageLoader;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.BasicViewHolder;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.basiclib.recyclerview.WrapperAdapter;
import com.xyz.riotcommon.CommonFragment;
import com.xyz.riotcommon.ImageLoadUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.scau.riotgame.R;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.NewsContract;
import org.scau.riotgame.home.presenter.NewsPresenter;
import org.scau.riotgame.utils.FormatUtil;
import org.scau.riotgame.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ZP on 2017/7/27.
 */

public class NewsFragment extends CommonFragment<NewsContract.View, NewsContract.Presenter> implements NewsContract.View, OnRefreshListener, OnLoadmoreListener {


    @Bind(R.id.rv_hero_free)
    RecyclerView mRvHeroFree;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private BasicAdapter<News> mAdapter;
    private List<News> mNews;

    private Banner mBanner;
    private List<String> images;

    private WrapperAdapter<News> mWrapperAdapter;


    private MultipleTypeSupport<News> mMultipleTypeSupport = new MultipleTypeSupport<News>() {
        @Override
        public int getLayoutId(News news, int position) {

            if ("image".equals(news.getNewstypeid())) {
                return R.layout.item_news_image;
            } else if ("report".equals(news.getNewstypeid())) {
                return R.layout.item_news_report;
            } else {
                return R.layout.item_news_default;
            }


        }
    };

    @Override
    public void showNewsList(List<News> news) {
        mNews.clear();
        mNews.addAll(news);
        mWrapperAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreNewsList(int currentPage, List<News> news) {
        mNews.addAll(news);
        mWrapperAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void showBannerNewsList(List<News> bannerNews) {
        images.clear();
        for (int i = 0; i < bannerNews.size(); i++) {
            images.add(bannerNews.get(i).getImage_url_big());
        }
        mBanner.setImages(images);
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ImageLoadUtil.loadImage(context, path.toString(), R.drawable.default_lol_ex, imageView);
            }
        });
        mBanner.start();
    }

    @Override
    protected void initViewsAndEvents(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.initViewsAndEvents(inflater, container, savedInstanceState);
        mRvHeroFree.setLayoutManager(new LinearLayoutManager(getActivity()));
        mNews = new ArrayList<>();

        mAdapter = new BasicAdapter<News>(mNews, getActivity(), mMultipleTypeSupport) {
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
                    holder.setText(R.id.tv_article_pv, getString(R.string.article_pv, FormatUtil.unitToTenThousand(news.getPv())));
                    if (news.getNewstype() == null || TextUtils.isEmpty(news.getNewstype())) {
                        holder.setVisibility(R.id.tv_article_tag, View.GONE);
                    } else {
                        holder.setVisibility(R.id.tv_article_tag, View.VISIBLE);
                        holder.setText(R.id.tv_article_tag, news.getNewstype());
                    }
                    holder.setImagePath(R.id.iv_article, new AbstractImageLoader(news.getImage_url_small()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
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
                    holder.setText(R.id.tv_article_pv, getString(R.string.article_pv, FormatUtil.unitToTenThousand(news.getPv())));
                    if (news.getNewstype() == null || TextUtils.isEmpty(news.getNewstype())) {
                        holder.setVisibility(R.id.tv_article_tag, View.GONE);
                    } else {
                        holder.setText(R.id.tv_article_tag, news.getNewstype());
                    }

                    holder.setImagePath(R.id.iv_article_big, new AbstractImageLoader(news.getBig_image_url()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });

                    holder.setImagePath(R.id.iv_article_small, new AbstractImageLoader(news.getSmall_image_url()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });

                    holder.setImagePath(R.id.iv_article_count, new AbstractImageLoader(news.getCount_image_url()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });
                }

                if ("report".equals(news.getNewstypeid())) {
                    holder.setText(R.id.tv_article_title, news.getTitle());

                    holder.setText(R.id.tv_article_pv, getString(R.string.article_pv, FormatUtil.unitToTenThousand(news.getPv())));
                    if (news.getNewstype() == null || TextUtils.isEmpty(news.getNewstype())) {
                        holder.setVisibility(R.id.tv_article_tag, View.GONE);
                    } else {
                        holder.setText(R.id.tv_article_tag, news.getNewstype());
                    }
                    holder.setImagePath(R.id.iv_article, new AbstractImageLoader(news.getImage_url_small()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });

                    holder.setImagePath(R.id.iv_logo_teama, new AbstractImageLoader(news.getTeama_logo()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });
                    holder.setText(R.id.tv_name_teama, news.getTeama_name());
                    holder.setText(R.id.tv_match_result, news.getMarch_result());
                    holder.setImagePath(R.id.iv_logo_teamb, new AbstractImageLoader(news.getTeamb_logo()) {
                        @Override
                        public void loadImage(ImageView imageView, String path) {
                            ImageLoadUtil.loadImage(getActivity(), path, R.drawable.default_lol_ex, imageView);
                        }
                    });
                    holder.setText(R.id.tv_name_teamb, news.getTeamb_name());
                }
            }

        };

        mAdapter.setOnItemClickListener(new BasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", mNews.get(position).getArticle_url());
                startActivity(intent);
            }
        });
        mWrapperAdapter = new WrapperAdapter<News>(mAdapter);

        LayoutInflater inflaterHeader = LayoutInflater.from(getActivity());
        View headerBanner = initHeaderBanner(inflaterHeader, container);

        mWrapperAdapter.addHeaderView(headerBanner);

        mRvHeroFree.setAdapter(mWrapperAdapter);
        //mRvHeroFree.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hero_free;
    }

    @Override
    protected NewsContract.Presenter initPresenter() {
        return new NewsPresenter();
    }

    private View initHeaderBanner(LayoutInflater inflater, ViewGroup container) {
        View headerBanner = inflater.inflate(R.layout.header_news_gallery, container, false);
        mBanner = (Banner) headerBanner.findViewById(R.id.banner_news);
        images = new ArrayList<>();
        return headerBanner;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
//        mRefreshLayout.autoRefresh();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.d(TAG, "setUserVisibleHint: " + isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
//            mRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.refreshNews();
        mPresenter.refreshBannerNews();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNews();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mRefreshLayout.autoRefresh();
    }
}
