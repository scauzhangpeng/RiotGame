package com.muugi.album;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.io.File;
import java.util.List;

/**
 * Created by ZP on 2018/7/18.
 */

public interface AlbumContract {

    interface View extends BaseView {
        void showAlbumListData(List<ImageFolder> data);
    }

    interface DetailView extends BaseView {
        void showAlbumPictureUnderFolder(List<File> data);
    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void getAlbumPictureList();
    }

    interface ModelCallback {
        void onSuccess(List<ImageFolder> data);

        void onFailure(String message);
    }

    interface DetailModelCallback {
        void onSuccess(List<File> data);
    }

    abstract class DetailPresenter extends BasePresenter<DetailView> {
        abstract void getAlbumPictureUnderFolder(String uri);
    }
}
