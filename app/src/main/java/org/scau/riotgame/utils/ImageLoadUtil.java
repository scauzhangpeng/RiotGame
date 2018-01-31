package org.scau.riotgame.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

/**
 * Created by ZP on 2017/8/2.
 */

public class ImageLoadUtil {

    public static void loadCircleImage(final Context context, String url, int placeholder, final ImageView imageView) {
        RequestOptions options = new RequestOptions();
        options.placeholder(placeholder);
        Glide.with(context).asBitmap().load(url).apply(options).into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    public static void loadImage(Context context, String url, int placeholder, ImageView imageView) {
        RequestOptions options = new RequestOptions();
        options.placeholder(placeholder);
        Glide.with(context).load(url).apply(options).into(imageView);
    }
}
