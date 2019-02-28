package com.muugi.riot.news.view;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.muugi.riot.news.R;
import com.muugi.riot.news.adapter.HotNewsAdapter;
import com.muugi.riot.news.base.BaseNewsFragment;
import com.muugi.riot.news.bean.News;
import com.muugi.riot.news.contract.HotNewsContract;
import com.muugi.riot.news.model.Injection;
import com.muugi.riot.news.presenter.HotNewsPresenter;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.basiclib.recyclerview.MultipleTypeSupport;
import com.xyz.riotcommon.RouterConstants;

/**
 * 热点资讯.
 * 单一的列表界面，所有的操作都封装在{@link BaseNewsFragment},
 * {@link HotNewsFragment} 仅仅需要做一些初始化的工作.
 * Created by ZP on 2018/11/10.
 */
@Route(path = RouterConstants.NEWS_HOT)
public class HotNewsFragment extends BaseNewsFragment<News, HotNewsContract.View, HotNewsContract.Presenter> implements HotNewsContract.View {

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
    protected HotNewsContract.Presenter initPresenter() {
        return new HotNewsPresenter("471", Injection.provideNewsRepository());
    }

    @Override
    public void onItemClick(View view, int position) {
        openWebView(mData.get(position).getArticle_url());
    }
}
