package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.SimpleRefreshFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.home.HotNewsAdapter;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.HotNewsContract;
import org.scau.riotgame.home.presenter.HotNewsPresenter;
import org.scau.riotgame.webview.WebViewActivity;

import java.util.List;

/**
 * Created by ZP on 2018/11/10.
 */
public class HotNewsFragment extends SimpleRefreshFragment<News, HotNewsContract.View, HotNewsContract.Presenter> implements HotNewsContract.View {

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
    protected BasicAdapter<News> getAdapter() {
        return new HotNewsAdapter(mData, getActivity(), mMultipleTypeSupport);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNews();
    }

    @Override
    protected HotNewsContract.Presenter initPresenter() {
        return new HotNewsPresenter();
    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        bundle.putString("url", mData.get(position).getArticle_url());
        openActivity(WebViewActivity.class, bundle);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.refreshNews();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mSmartRefreshLayout.autoRefresh();
    }

    @Override
    public void showHotNewsList(List<News> news) {
        mData.clear();
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreHotNewsList(int currentPage, List<News> news) {
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishLoadmore();
    }
}
