package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

import com.xyz.riotcommon.net.HttpCallback;
import org.scau.riotgame.http.OSSWebManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Response;

/**
 * Created by ZP on 2018/2/26.
 */

public class GoodsListActivity extends SimpleTopBarActivity implements OnRefreshListener, BasicAdapter.OnItemClickListener {


    @BindView(R.id.rv_layout_refresh)
    RecyclerView mRvLayoutRefresh;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private List<GoodBean.ItemsBean> mGoodsList;
    private GoodsAdapter mGoodsAdapter;


    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        mRvLayoutRefresh.setLayoutManager(new GridLayoutManager(this, 4));
        mGoodsList = new ArrayList<>();
        mGoodsAdapter = new GoodsAdapter(mGoodsList, this);
        mRvLayoutRefresh.setAdapter(mGoodsAdapter);

        mRefreshLayout.setOnRefreshListener(this);
        mGoodsAdapter.setOnItemClickListener(this);
        mRefreshLayout.setEnableLoadmore(false);
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_goods_list;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRefreshLayout.autoRefresh();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        OSSWebManager.getInstance().getGoods(new HttpCallback<GoodBean>() {
            @Override
            public void doOnSuccess(@NonNull GoodBean goodBean, Response<GoodBean> response) {
                List<GoodBean.ItemsBean> items = goodBean.getItems();
                mGoodsList.clear();
                mGoodsList.addAll(items);
                mGoodsAdapter.notifyDataSetChanged();
                mRefreshLayout.finishRefresh();
            }

            @Override
            public void doOnError(Response<GoodBean> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Bundle bundle = new Bundle();
        int good_id = mGoodsList.get(position).getGood_id();
        bundle.putInt("good_id", good_id);
        openActivity(GoodsDetailActivity.class, bundle);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
