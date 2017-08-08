package org.scau.riotgame.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ZP on 2017/8/8.
 */

public abstract class RiotGameAdapter<T> extends RecyclerView.Adapter<RiotGameViewHolder> {

    protected int mLayoutId;//布局id
    protected List<T> mDatas;//数据源
    protected Context mContext;//上下文
    private LayoutInflater mInflater;
    private MultipleTypeSupport<T> mMultipleTypeSupport;

    public RiotGameAdapter(List<T> datas, Context context, MultipleTypeSupport<T> multipleTypeSupport) {
        this(-1, datas, context);
        mMultipleTypeSupport = multipleTypeSupport;
    }

    public RiotGameAdapter(int layoutId, List<T> datas, Context context) {
        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemViewType(int position) {
        if (mMultipleTypeSupport != null) {
            return mMultipleTypeSupport.getLayoutId(mDatas.get(position), position);
        }
        return super.getItemViewType(position);
    }

    @Override
    public RiotGameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mMultipleTypeSupport != null) {
            mLayoutId = viewType;
        }
        View itemView = mInflater.inflate(mLayoutId, parent, false);
        return new RiotGameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RiotGameViewHolder holder, int position) {
        bindData(holder, mDatas.get(position), position);
    }

    protected abstract void bindData(RiotGameViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
