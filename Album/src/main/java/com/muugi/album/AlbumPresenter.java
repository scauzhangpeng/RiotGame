package com.muugi.album;

import android.content.Context;
import android.os.Environment;

import java.util.List;

/**
 * Created by ZP on 2018/7/23.
 */

public class AlbumPresenter extends AlbumContract.Presenter {

    private AlbumModel mAlbumModel;

    public AlbumPresenter(Context context) {
        mAlbumModel = new AlbumModel();
        mAlbumModel.setContext(context);
    }

    @Override
    void getAlbumPictureList() {
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            if (getView() != null) {
                getView().showToastShort("暂无外存");
            }
            return;
        }

        mAlbumModel.getAlbumListData(new AlbumContract.ModelCallback() {
            @Override
            public void onSuccess(List<ImageFolder> data) {
                if (getView() != null) {
                    getView().showAlbumListData(data);
                }
            }

            @Override
            public void onFailure(String message) {
                if (getView() != null) {
                    getView().showToastShort(message);
                }
            }
        });
    }
}
