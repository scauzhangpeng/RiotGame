package com.muugi.album;

/**
 * Created by ZP on 2018/9/18.
 */

public interface AlbumCallbackContract {

    public interface AlbumListItemClickListener {
        void onClick(String dir, String name);
    }

    public interface AlbumDetailSelectClickListener {
        void onClick(String dir, String path, String fileSize);

        void onUnSelected();
    }
}
