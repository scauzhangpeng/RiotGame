package com.xyz.riotcommon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.ByteArrayOutputStream;

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

    public static void loadBitmap(Context context, String url, final SimpleTargetCallback callback) {
        RequestOptions options = new RequestOptions();
        Glide.with(context).asBitmap().load(url).apply(options).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                callback.onResourceReady(resource);
            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                callback.onLoadFailed(errorDrawable);
            }
        });
    }

    public interface SimpleTargetCallback {
        public void onResourceReady(Bitmap resource);

        public void onLoadFailed(@Nullable Drawable errorDrawable);
    }

    /**
     * Bitmap to bytes.
     *
     * @param bitmap The bitmap.
     * @param format The format of bitmap.
     * @return bytes
     */
    public static byte[] bitmap2Bytes(final Bitmap bitmap, final Bitmap.CompressFormat format) {
        if (bitmap == null) return null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(format, 100, baos);
        return baos.toByteArray();
    }
}
