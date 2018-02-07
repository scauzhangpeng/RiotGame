package com.xyz.basiclib.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by ZP on 2018/1/31.
 */

public class ImageLoader {

    private Context mContext;

    private String url;

    private ImageView mImageView;

    private int placeholder;

    private boolean isCircle;

    private ImageLoader(Builder builder) {
        mContext = builder.mContext;
        url = builder.url;
        mImageView = builder.mImageView;
        placeholder = builder.placeholder;
        isCircle = builder.isCircle;
        RequestOptions options = new RequestOptions();
        options.placeholder(placeholder);
        if (isCircle) {
            Glide.with(mContext).asBitmap().load(url).apply(options).into(new BitmapImageViewTarget(mImageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable =
                            RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    mImageView.setImageDrawable(circularBitmapDrawable);
                }
            });
        } else {
            Glide.with(mContext).load(url).apply(options).into(mImageView);
        }
    }


    public static final class Builder {
        private String url;
        private ImageView mImageView;
        private int placeholder;
        private Context mContext;
        private boolean isCircle;

        public Builder() {
        }

        public Builder(ImageLoader copy) {
            this.mContext = copy.mContext;
            this.url = copy.url;
            this.mImageView = copy.mImageView;
            this.placeholder = copy.placeholder;
            this.isCircle = copy.isCircle;
        }

        public Builder with(Context val) {
            mContext = val;
            return this;
        }

        public Builder load(String val) {
            url = val;
            return this;
        }

        public ImageLoader into(ImageView val) {
            mImageView = val;
            return new ImageLoader(this);
        }

        public Builder placeholder(int val) {
            placeholder = val;
            return this;
        }

        public Builder isCircle(boolean val) {
            isCircle = val;
            return this;
        }
    }

    private BitmapImageViewTarget circleImageViewTarget = new BitmapImageViewTarget(mImageView) {
        @Override
        protected void setResource(Bitmap resource) {
            RoundedBitmapDrawable circularBitmapDrawable =
                    RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
            circularBitmapDrawable.setCircular(true);
            mImageView.setImageDrawable(circularBitmapDrawable);
        }
    };
}
