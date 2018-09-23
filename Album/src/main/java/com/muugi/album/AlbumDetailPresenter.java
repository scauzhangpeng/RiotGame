package com.muugi.album;

import android.content.Context;

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
    void getAlbumPictureUnderFolder(String uri, final String currentSelectImage, final String currentSelectDir) {
        mAlbumModel.getAlbumListUnderFolder(uri, currentSelectDir, currentSelectImage, new AlbumContract.DetailModelCallback() {
            @Override
            public void onSuccess(List<WrapperFile> data) {
                if (getView() != null) {
                    getView().showAlbumPictureUnderFolder(data);
                }
            }
        });
    }
}
