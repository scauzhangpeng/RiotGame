package com.muugi.album;

/**
 * Created by ZP on 2018/9/18.
 */

public interface AlbumFragmentCallback {

    public void openAlbumDetailFragment(String dir, String name);

    public void selectPicture(String dir, String path);
}
