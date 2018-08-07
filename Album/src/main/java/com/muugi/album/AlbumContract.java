package com.muugi.album;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

/**
 * Created by ZP on 2018/7/18.
 */

public interface AlbumContract {

    interface View extends BaseView {

    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void getAlbumPictureList();
    }
}
