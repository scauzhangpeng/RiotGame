package org.scau.riotgame.home.view;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.SimpleRefreshFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.home.HotNewsAdapter;
import org.scau.riotgame.home.bean.News;
import org.scau.riotgame.home.contract.OfficialNewsContract.View;
import org.scau.riotgame.home.presenter.OfficialNewsPresenter;

import java.util.List;

/**
 * Created by ZP on 2018/11/11.
 */
public class OfficialNewsFragment extends SimpleRefreshFragment<News, View, OfficialNewsPresenter> implements View {

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
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);
        mPresenter.refreshNews();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.loadMoreNews();
    }

    @Override
    protected OfficialNewsPresenter initPresenter() {
        return new OfficialNewsPresenter();
    }

    @Override
    public void onItemClick(android.view.View view, int position) {

    }

    @Override
    public void showOfficialNewsList(List<News> news) {
        mData.clear();
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishRefresh();
    }

    @Override
    public void showMoreOfficialNewsList(int currentPage, List<News> news) {
        mData.addAll(news);
        mAdapter.notifyDataSetChanged();
        mSmartRefreshLayout.finishLoadmore();
    }

    @Override
    protected void requestData() {
        super.requestData();
        mSmartRefreshLayout.autoRefresh();
    }
}
