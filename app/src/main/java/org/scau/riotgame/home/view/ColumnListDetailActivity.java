package org.scau.riotgame.home.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.recyclerview.AverageSpaceItemDecoration;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.CommonActivity;
import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;
import org.scau.riotgame.home.HotNewsAdapter;
import org.scau.riotgame.home.WholeVideoAdapter;
import org.scau.riotgame.home.bean.HotMatch;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.ColumnListDetailContract;
import org.scau.riotgame.home.presenter.ColumnListDetailPresenter;
import org.scau.riotgame.utils.ScreenUtil;
import org.scau.riotgame.webview.WebViewActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ZP on 2018/11/18.
 */
public class ColumnListDetailActivity extends CommonActivity<ColumnListDetailContract.View, ColumnListDetailContract.Presenter>
        implements ColumnListDetailContract.View, OnRefreshListener, OnLoadmoreListener, BasicAdapter.OnItemClickListener {


    @BindView(R.id.iv_column_logo)
    CircleImageView mIvColumnLogo;
    @BindView(R.id.tv_columnlist_title)
    TextView mTvColumnlistTitle;
    @BindView(R.id.tv_columnlist_author)
    TextView mTvColumnlistAuthor;
    @BindView(R.id.tv_columnlist_desc)
    TextView mTvColumnlistDesc;
    @BindView(R.id.tv_columnlist_book)
    TextView mTvColumnlistBook;
    @BindView(R.id.column_list_detail_layout)
    RelativeLayout mColumnListDetailLayout;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_layout)
    CollapsingToolbarLayout mCollapsingLayout;
    @BindView(R.id.appbar_layout)
    AppBarLayout mAppbarLayout;
    @BindView(R.id.rv_column_list_detail)
    RecyclerView mRvColumnListDetail;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private List<News> mData;
    private HotNewsAdapter mAdapter;
    private List<HotMatch> mHotMatches;
    private WholeVideoAdapter mWholeVideoAdapter;
    private String cid;
    private boolean isVideo = false;

    @Override
    protected void initTopBar(View topView) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_column_list_detail;
    }

    @Override
    protected int getTopBarContentId() {
        return 0;
    }

    @Override
    protected int getTopBarLayoutId() {
        return 0;
    }

    @Override
    protected ColumnListDetailContract.Presenter initPresenter() {
        return new ColumnListDetailPresenter();
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        final String title = getIntent().getStringExtra("title");
        final String author = getIntent().getStringExtra("author");
        String desc = getIntent().getStringExtra("desc");
        cid = getIntent().getStringExtra("id");
        String logo = getIntent().getStringExtra("logo");
        String isBook = getIntent().getStringExtra("isBook");
        isVideo = getIntent().getBooleanExtra("isVideo", false);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbarTitle.setText("专栏详情");
        mAppbarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(final AppBarLayout appBarLayout, final int verticalOffset) {
                mAppbarLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        int totalScrollRange = appBarLayout.getTotalScrollRange();
                        int abs = Math.abs(verticalOffset);
                        float v = abs * 1.0f / totalScrollRange * 1.0f;

                        mColumnListDetailLayout.setAlpha(1.0f - v);
                        if (v == 1) {
                            mToolbarTitle.setText(title);
                        } else {
                            mToolbarTitle.setText("专栏详情");
                        }
                    }
                });
            }
        });


        mTvColumnlistAuthor.setText(author);
        mTvColumnlistDesc.setText(desc);
        mTvColumnlistTitle.setText(title);
        ImageLoadUtil.loadImage(this, logo, R.drawable.default_lol_ex, mIvColumnLogo);
        if ("1".equals(isBook)) {
            mTvColumnlistBook.setText("已订阅");
            mTvColumnlistBook.setTextColor(Color.WHITE);
            mTvColumnlistBook.setBackgroundResource(R.drawable.book_shape);
        } else {
            mTvColumnlistBook.setText("+ 订阅");
            mTvColumnlistBook.setTextColor(getResources().getColor(R.color.colorMainGold));
            mTvColumnlistBook.setBackgroundResource(R.drawable.unbook_shape);
        }
        initRefreshLayout();
        initRecyclerView();
        mRefreshLayout.autoRefresh();
    }

    private void initRefreshLayout() {
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
    }

    private void initRecyclerView() {
        mData = new ArrayList<>();
        mHotMatches = new ArrayList<>();
        mRvColumnListDetail = (RecyclerView) findViewById(R.id.rv_column_list_detail);
        mRvColumnListDetail.setNestedScrollingEnabled(false);
        if (isVideo) {
            mWholeVideoAdapter = new WholeVideoAdapter(R.layout.item_whole_video, mHotMatches, this);
            mRvColumnListDetail.setLayoutManager(new GridLayoutManager(this, 2));
            mRvColumnListDetail.addItemDecoration(new AverageSpaceItemDecoration((int) ScreenUtil.dip2px(this, 10), true));
            mRvColumnListDetail.setAdapter(mWholeVideoAdapter);
        } else {
            mAdapter = new HotNewsAdapter(mData, this, mMultipleTypeSupport);
            mRvColumnListDetail.setLayoutManager(new LinearLayoutManager(this));
            mRvColumnListDetail.setAdapter(mAdapter);
        }
        if (mAdapter != null) {
            mAdapter.setOnItemClickListener(this);
        }
        if (mWholeVideoAdapter != null) {
            mWholeVideoAdapter.setOnItemClickListener(this);
        }
    }

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
    public void onRefresh(RefreshLayout refreshlayout) {
        if (isVideo) {
            mPresenter.refreshHotMatch(cid);
        } else {
            mPresenter.refreshNews(cid);
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        if (isVideo) {
            mPresenter.loadMoreHotMatch(cid);
        } else {
            mPresenter.loadMoreNews(cid);
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("url", mData.get(position).getArticle_url());
        openActivity(WebViewActivity.class, bundle);
    }

    @Override
    public void showNewsList(List<News> news) {
        mData.clear();
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreNewsList(List<News> news) {
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void showHotMatchList(List<HotMatch> hotMatches) {
        mHotMatches.clear();
        mHotMatches.addAll(hotMatches);
        mWholeVideoAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreHotMatchList(List<HotMatch> hotMatches) {
        mHotMatches.addAll(hotMatches);
        mWholeVideoAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    public void setEnableLoadMore(boolean enableLoadMore) {
        mRefreshLayout.setEnableLoadmore(enableLoadMore);
    }
}
