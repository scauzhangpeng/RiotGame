package org.scau.riotgame.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.scau.riotgame.R;
import org.scau.riotgame.utils.ImageLoadUtil;

import java.util.List;

/**
 * Created by ZP on 2017/8/2.
 */

public class ClubAdapter extends CommAdapter<Club.ClubsBean, ClubAdapter.ClubViewHolder> {


    public ClubAdapter(List<Club.ClubsBean> list, Context context) {
        super(list, context);
    }

    @Override
    public ClubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_club, parent, false);
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ClubViewHolder holder, int position) {
        Club.ClubsBean club = mList.get(position);
        ImageLoadUtil.loadCircleImage(mContext, club.getIconUrl(), holder.mImageView);
        holder.mTextView.setText(club.getName());
        holder.itemView.setTag(position);
    }

    class ClubViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        private TextView mTextView;

        public ClubViewHolder(View view) {
            super(view);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_club_icon);
            mTextView = (TextView) itemView.findViewById(R.id.tv_club_name);
        }
    }
}
