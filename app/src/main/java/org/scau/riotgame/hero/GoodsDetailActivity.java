package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.OSSWebManager;

import com.xyz.riotcommon.ImageLoadUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import retrofit2.Response;

/**
 * Created by ZP on 2018/2/26.
 */

public class GoodsDetailActivity extends SimpleTopBarActivity {

    @Bind(R.id.iv_good_icon)
    ImageView mIvGoodIcon;
    @Bind(R.id.tv_good_name)
    TextView mTvGoodName;
    @Bind(R.id.tv_prop_list)
    TextView mTvPropList;
    @Bind(R.id.tv_goods_map_list)
    TextView mTvGoodsMapList;
    @Bind(R.id.tv_price)
    TextView mTvPrice;
    @Bind(R.id.tv_coprice)
    TextView mTvCoprice;
    @Bind(R.id.tv_saleprice)
    TextView mTvSaleprice;
    @Bind(R.id.tv_good_desc)
    TextView mTvGoodDesc;

    @Bind(R.id.rv_produce_need)
    RecyclerView mRvProduceNeed;
    @Bind(R.id.ll_produce_need)
    LinearLayout mLlProduceNeed;
    @Bind(R.id.rv_can_produce)
    RecyclerView mRvCanProduce;
    @Bind(R.id.ll_can_produce)
    LinearLayout mLlCanProduce;
    @Bind(R.id.rv_suit_hero)
    RecyclerView mRvSuitHero;
    @Bind(R.id.ll_suit_hero)
    LinearLayout mLlSuitHero;

    private int mGoodId;

    private List<String> mProduceNeedList;
    private List<String> mCanProduceList;
    private List<String> mSuitHeroList;

    private GoodsDetailAdapter mProduceNeedAdapter;
    private GoodsDetailAdapter mCanProduceAdapter;
    private GoodsDetailHeroAdapter mSuitHeroAdapter;

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        super.initViewsAndEvents(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mGoodId = extras.getInt("good_id");
            ImageLoadUtil.loadImage(this, "http://down.qq.com/qqtalk/lolApp/img/item/" + mGoodId + ".png",
                    R.drawable.default_lol_ex, mIvGoodIcon);
        }
        mProduceNeedList = new ArrayList<>();
        mProduceNeedAdapter = new GoodsDetailAdapter(mProduceNeedList, this);
        mRvProduceNeed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRvProduceNeed.setAdapter(mProduceNeedAdapter);

        mCanProduceList = new ArrayList<>();
        mCanProduceAdapter = new GoodsDetailAdapter(mCanProduceList, this);
        mRvCanProduce.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRvCanProduce.setAdapter(mCanProduceAdapter);

        mSuitHeroList = new ArrayList<>();
        mSuitHeroAdapter = new GoodsDetailHeroAdapter(mSuitHeroList, this);
        mRvSuitHero.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRvSuitHero.setAdapter(mSuitHeroAdapter);
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_goods_detail;
    }

    @Override
    protected void onResume() {
        super.onResume();
        OSSWebManager.getInstance().getGoodsDetail(mGoodId, new HttpCallback<GoodsDetailBean>() {
            @Override
            public void doOnSuccess(@NonNull GoodsDetailBean goodsDetailBean, Response<GoodsDetailBean> response) {
                showGoodsBaseInfo(goodsDetailBean.getName(), goodsDetailBean.getProplist(), goodsDetailBean.getMaplist());
                showGoodsPrice(goodsDetailBean.getPrice(), goodsDetailBean.getCoprice(), goodsDetailBean.getSaleprice());
                showGoodsDesc(goodsDetailBean.getGood_desc());
                List<String> produceResp = new ArrayList<String>();
                List<String> produceneedlist = goodsDetailBean.getProduceneedlist();
                for (int i = 0; i < produceneedlist.size(); i++) {
                    String s = produceneedlist.get(i);
                    if (!TextUtils.isEmpty(s)) {
                        String url = "http://down.qq.com/qqtalk/lolApp/img/item/" + s + ".png";
                        produceResp.add(url);
                    }

                }
                showGoodsProduceNeed(produceResp);

                //
                List<String> canProduceResp = new ArrayList<String>();
                List<String> canproducelist = goodsDetailBean.getCanproducelist();
                for (int i = 0; i < canproducelist.size(); i++) {
                    String s = canproducelist.get(i);
                    if (!TextUtils.isEmpty(s)) {
                        String url = "http://down.qq.com/qqtalk/lolApp/img/item/" + s + ".png";
                        canProduceResp.add(url);
                    }
                }
                showGoodsCanProduce(canProduceResp);

                //
                List<String> suitHeroResp = new ArrayList<String>();
                List<String> suithero = goodsDetailBean.getSuithero();
                for (int i = 0; i < suithero.size(); i++) {
                    String s = suithero.get(i);
                    if (!TextUtils.isEmpty(s)) {
                        String url = "http://down.qq.com/qqtalk/lolApp/img/hero/" + s + ".png";
                        suitHeroResp.add(url);
                    }
                }
                showGoodsSuitHeros(suitHeroResp);
            }

            @Override
            public void doOnError(Response<GoodsDetailBean> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }


    private void showGoodsBaseInfo(String name, List<String> proplist, List<String> maplist) {
        mTvGoodName.setText(name);
        if (proplist != null && proplist.size() != 0) {
            String prop = "";
            for (int i = 0; i < proplist.size(); i++) {
                prop += proplist.get(i);
            }
            mTvPropList.setText(prop);
        }
        if (maplist != null) {
            String map = "";
            for (int i = 0; i < maplist.size(); i++) {
                map += maplist.get(i);
            }
            mTvGoodsMapList.setText(map);
        }
    }

    private void showGoodsPrice(String price, String coprice, String saleprice) {
        mTvPrice.setText(price);
        if (TextUtils.isEmpty(coprice)) {

        }
        mTvCoprice.setText(coprice);
        mTvSaleprice.setText(saleprice);
    }

    private void showGoodsDesc(String good_desc) {
        mTvGoodDesc.setText(good_desc);
    }

    private void showGoodsProduceNeed(List<String> produceneedlist) {
        if (produceneedlist != null && produceneedlist.size() != 0) {
            mLlProduceNeed.setVisibility(View.VISIBLE);
            mProduceNeedList.clear();
            mProduceNeedList.addAll(produceneedlist);
            mProduceNeedAdapter.notifyDataSetChanged();
        }
    }

    private void showGoodsCanProduce(List<String> canproducelist) {
        if (canproducelist != null && canproducelist.size() != 0) {
            mLlCanProduce.setVisibility(View.VISIBLE);
            mCanProduceList.clear();
            mCanProduceList.addAll(canproducelist);
            mCanProduceAdapter.notifyDataSetChanged();
        }
    }

    private void showGoodsSuitHeros(List<String> suithero) {
        if (suithero != null && suithero.size() != 0) {
            mLlSuitHero.setVisibility(View.VISIBLE);
            mSuitHeroList.clear();
            mSuitHeroList.addAll(suithero);
            mSuitHeroAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
