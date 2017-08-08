package org.scau.riotgame.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ZP on 2017/8/8.
 */

public class RiotGameViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;

    public RiotGameViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }


    public <V extends View> V getView(int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            mViews.put(id, view);
        }
        return (V) view;
    }

    public RiotGameViewHolder setText(int id, String text) {
        TextView tv = getView(id);
        tv.setText(text);
        return this;
    }

    public RiotGameViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public RiotGameViewHolder setImagePath(int viewId, ImageLoader imageLoder) {
        ImageView view = getView(viewId);
        imageLoder.loadImage(view, imageLoder.getPath());
        return this;
    }

    public abstract static class ImageLoader {
        private String path;

        public ImageLoader(String path) {
            this.path = path;
        }

        //需要复写该方法加载图片
        public abstract void loadImage(ImageView imageView, String path);

        public String getPath() {
            return path;
        }
    }
}
