package org.scau.riotgame.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xyz.riotcommon.ImageLoadUtil;

import org.scau.riotgame.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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
        ImageLoadUtil.loadImage(mContext, club.getIconUrl(), R.drawable.default_lol_ex, holder.mImageView);
        holder.mTextView.setText(club.getName());
        holder.itemView.setTag(position);
    }

    class ClubViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView mImageView;

        private TextView mTextView;

        public ClubViewHolder(View view) {
            super(view);
            mImageView = (CircleImageView) itemView.findViewById(R.id.iv_club_icon);
            mTextView = (TextView) itemView.findViewById(R.id.tv_club_name);
        }
    }
}
