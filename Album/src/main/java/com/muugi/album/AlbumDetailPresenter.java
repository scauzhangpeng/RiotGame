package com.muugi.album;

import android.content.Context;

import java.io.File;
import java.util.List;

/**
 * Created by ZP on 2018/8/7.
 */

public class AlbumDetailPresenter extends AlbumContract.DetailPresenter {


    private AlbumModel mAlbumModel;

    public AlbumDetailPresenter(Context context) {
        mAlbumModel = new AlbumModel();
        mAlbumModel.setContext(context);
    }

    @Override
    void getAlbumPictureUnderFolder(String uri) {
        mAlbumModel.getAlbumListUnderFolder(uri, new AlbumContract.DetailModelCallback() {
            @Override
            public void onSuccess(List<File> data) {
                if (getView() != null) {
                    getView().showAlbumPictureUnderFolder(data);
                }
            }
        });
    }
}
