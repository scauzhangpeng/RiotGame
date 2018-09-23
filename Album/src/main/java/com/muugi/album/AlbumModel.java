package com.muugi.album;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import com.xyz.basiclib.executor.AppExecutors;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by ZP on 2018/8/7.
 */

public class AlbumModel {

    private Context mContext;

    private AppExecutors mAppExecutors;

    public AlbumModel() {
        mAppExecutors = new AppExecutors();
    }

    public void setContext(Context context) {
        if (context != null) {
            mContext = context.getApplicationContext();
        }
    }

    public Context getContext() {
        return mContext;
    }


    public void getAlbumListData(final AlbumContract.ModelCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<ImageFolder> imageFolders = realGetAlbumListData(getContext());
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (imageFolders == null) {
                            callback.onFailure("get album fail");
                        } else {
                            callback.onSuccess(imageFolders);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    public void getAlbumListUnderFolder(final String uri, final String selectDir, final String selectImage,
                                        final AlbumContract.DetailModelCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                File file = new File(uri);
                if (!file.exists()) {
                    return;
                }
                File[] pngs = file.listFiles(new PictureFilter());
                final List<WrapperFile> result = new ArrayList<>();
                if (!TextUtils.isEmpty(selectDir) && selectDir.equals(uri)) {
                    for (File png : pngs) {
                        if (png.getAbsolutePath().equals(selectImage)) {
                            result.add(new WrapperFile(png, true));
                        } else {
                            result.add(new WrapperFile(png, false));
                        }
                    }
                } else {
                    for (File png : pngs) {
                        result.add(new WrapperFile(png, false));
                    }
                }

                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(result);
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }


    private List<ImageFolder> realGetAlbumListData(Context context) {
        String firstImage = null;
        int totalCount = 0;
        int mPicsSize = 0;
        File mImgDir;
        HashSet<String> mDirPaths = new HashSet<>();
        List<ImageFolder> mImageFolders = new ArrayList<>();


        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver mContentResolver = context
                .getContentResolver();

        // 只查询jpeg和png的图片
        Cursor mCursor = mContentResolver.query(mImageUri, null,
                MediaStore.Images.Media.MIME_TYPE + "=? or "
                        + MediaStore.Images.Media.MIME_TYPE + "=?",
                new String[]{"image/jpeg", "image/png"},
                MediaStore.Images.Media.DATE_ADDED + "  DESC");

        if (mCursor == null) {
            return null;
        }
        Log.e("TAG", mCursor.getCount() + "");
        while (mCursor.moveToNext()) {
            // 获取图片的路径
            String path = mCursor.getString(mCursor
                    .getColumnIndex(MediaStore.Images.Media.DATA));

            Log.e("TAG", path);
            // 拿到第一张图片的路径
            if (firstImage == null)
                firstImage = path;
            // 获取该图片的父路径名
            File parentFile = new File(path).getParentFile();
            if (parentFile == null)
                continue;
            String dirPath = parentFile.getAbsolutePath();
            ImageFolder imageFolder = null;
            // 利用一个HashSet防止多次扫描同一个文件夹（不加这个判断，图片多起来还是相当恐怖的~~）
            if (mDirPaths.contains(dirPath)) {
                continue;
            } else {
                mDirPaths.add(dirPath);
                // 初始化ImageFolder
                imageFolder = new ImageFolder();
                imageFolder.setDir(dirPath);
                imageFolder.setFirstImagePath(path);
            }

            int picSize = parentFile.list(new PictureFilter()).length;
            totalCount += picSize;

            imageFolder.setCount(picSize);
            mImageFolders.add(imageFolder);

            if (picSize > mPicsSize) {
                mPicsSize = picSize;
                mImgDir = parentFile;
            }
        }
        mCursor.close();

        // 扫描完成，辅助的HashSet也就可以释放内存了
        mDirPaths = null;

        return mImageFolders;
    }

    private static class PictureFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String filename) {
            return filename.endsWith(".jpg") || filename.endsWith(".JPG")
                    || filename.endsWith(".png") || filename.endsWith("PNG")
                    || filename.endsWith(".jpeg") || filename.endsWith(".JPEG");
        }
    }
}
