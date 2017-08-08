package org.scau.riotgame.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by ZP on 2017/8/2.
 */

public abstract class CommAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> mList;
    protected Context mContext;

    public CommAdapter(List<T> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }
}
